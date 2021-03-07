package com.validtest.shared.infrastructure.persistence.util;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class PredicateUtils {

    private PredicateUtils() {
    }

    public static Predicate getPredicateOfDate(Root<?> root, CriteriaBuilder builder, String key, String value) {
        Expression<String> dateStringExpr = builder.function("to_char", String.class,
                root.get(key), builder.literal("MM/DD/YYYY"));

        return builder.like(builder.lower(dateStringExpr), "%" + value + "%");
    }

}
