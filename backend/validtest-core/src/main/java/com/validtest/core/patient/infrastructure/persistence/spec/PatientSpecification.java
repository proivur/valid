package com.validtest.core.patient.infrastructure.persistence.spec;

import com.validtest.core.patient.domain.Patient;
import com.validtest.shared.infrastructure.persistence.specs.SpecSearchCriteria;
import com.validtest.shared.infrastructure.persistence.specs.SpecificationBase;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class PatientSpecification extends SpecificationBase implements Specification<Patient> {

    private SpecSearchCriteria criteria;

    public PatientSpecification(final SpecSearchCriteria criteria) {
        super();
        this.criteria = criteria;
    }

    public SpecSearchCriteria getCriteria() {
        return criteria;
    }

    @Override
    public Predicate toPredicate(final Root<Patient> root, final CriteriaQuery<?> query, final CriteriaBuilder builder) {
        return getPredicate(root, builder);
    }

    private Predicate getPredicate(Root<Patient> root, CriteriaBuilder builder) {
        switch (criteria.getOperation()){
            case EQUALITY:
                if (criteria.getKey().equals("creationDate")) {
                    return getPredicateOfDate(root, builder);
                }

                return builder.equal(root.get(criteria.getKey()), criteria.getValue());
            case NEGATION:
                return builder.notEqual(root.get(criteria.getKey()), criteria.getValue());
            case GREATER_THAN:
                return builder.greaterThan(root.get(criteria.getKey()), criteria.getValue().toString());
            case LESS_THAN:
                return builder.lessThan(root.get(criteria.getKey()), criteria.getValue().toString());
            case LIKE:
                return builder.like(root.get(criteria.getKey()), criteria.getValue().toString());
            case STARTS_WITH:
                return builder.like(root.get(criteria.getKey()), criteria.getValue() + "%");
            case ENDS_WITH:
                return builder.like(root.get(criteria.getKey()), "%" + criteria.getValue());
            case CONTAINS:
                if (criteria.getKey().equals("creationDate")) {
                    return getPredicateOfDate(root, builder);
                }

                return builder.like(builder.lower(root.get(criteria.getKey()).get("value")), builder.lower(builder.literal("%" + criteria.getValue() + "%")));
            default:
                return null;
        }
    }

    private Predicate getPredicateOfDate(Root<Patient> root, CriteriaBuilder builder) {
        Expression<String> dateStringExpr = builder.function("to_char", String.class,
                root.get(criteria.getKey()), builder.literal("MM/DD/YYYY"));

        return builder.like(builder.lower(dateStringExpr), "%" + criteria.getValue().toString() + "%");
    }

}
