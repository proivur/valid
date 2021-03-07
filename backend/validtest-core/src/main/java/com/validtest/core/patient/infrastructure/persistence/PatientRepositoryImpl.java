package com.validtest.core.patient.infrastructure.persistence;

import com.google.common.base.Joiner;
import com.validtest.core.patient.domain.PatientRepository;
import com.validtest.core.patient.infrastructure.persistence.spec.PatientSpecification;
import com.validtest.core.patient.infrastructure.persistence.spec.PatientSpecificationsBuilder;
import com.validtest.shared.domain.DomainObjectAlreadyExist;
import com.validtest.shared.domain.PatientId;
import com.validtest.shared.domain.RecordStatus;
import com.validtest.shared.infrastructure.persistence.specs.SpecSearchCriteria;
import com.validtest.shared.infrastructure.persistence.util.SearchOperation;
import com.validtest.core.patient.domain.Patient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Repository
@PropertySource("classpath:sql-statements.xml")
public class PatientRepositoryImpl implements PatientRepository {

    private static final Logger LOG = LogManager.getLogger(PatientRepositoryImpl.class);

    private EntityManager em;

    @Autowired
    private Environment env;

    @Autowired
    private PatientRepositoryJPA patientRepository;

    @Autowired
    public PatientRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public void create(Patient patient) {
        Optional<Patient> exist = findByName(patient);

        if (exist.isPresent()) {
            throw new DomainObjectAlreadyExist(Patient.class, patient.firstName().value() + " " + patient.lastName().value());
        }

        patient = Patient.create(patient.id(), patient.firstName(), patient.lastName(), patient.status());

        patientRepository.save(patient);
    }

    @Override
    public void update(Patient patient) {
        Optional<Patient> exist = findByName(patient);

        if (exist.isPresent() && !patient.id().value().equals(exist.get().id().value())) {
            throw new DomainObjectAlreadyExist(Patient.class, patient.firstName().value() +  " " + patient.lastName().value());
        }

        patient = Patient.create(patient.id(), patient.firstName(), patient.lastName(), patient.status());

        patientRepository.save(patient);
    }

    private Optional<Patient> findByName(Patient patient) {
        SpecSearchCriteria criteriaFirstName = new SpecSearchCriteria("firstName", ":", "*", patient.firstName().value(), "*");
        PatientSpecification specFirstName = new PatientSpecification(criteriaFirstName);
        SpecSearchCriteria criteriaLastName = new SpecSearchCriteria("lastName", ":", "*", patient.lastName().value(), "*");
        PatientSpecification specLastName = new PatientSpecification(criteriaLastName);
        Optional<Patient> patientFound = patientRepository.findOne(Specification.where(specFirstName).and(specLastName));

        return patientFound;
    }

    @Override
    public Optional<Patient> findById(PatientId patientId) {
        SpecSearchCriteria criteria = new SpecSearchCriteria("id", SearchOperation.EQUALITY, patientId);
        PatientSpecification spec = new PatientSpecification(criteria);
        return patientRepository.findOne(Specification.where(spec));
    }

    @Override
    public Page<Patient> findAll(String filter, Integer pageNo, Integer pageSize, String sortBy, String direction) {
        String fixedFilter = filter.isEmpty() ? "status!R" : filter + ",status!R";
        PatientSpecificationsBuilder builder = new PatientSpecificationsBuilder();
        String operationSetExper = Joiner.on("|").join(SearchOperation.SIMPLE_OPERATION_SET);
        String regexDate = "[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}";
        Pattern pattern = Pattern.compile("(\\p{Punct}?)(\\w+?)(" + operationSetExper + ")(\\p{Punct}?)([\\w\\s]+?|" + regexDate + ")(\\p{Punct}?),");
        Matcher matcher = pattern.matcher(fixedFilter + ",");

        while (matcher.find()) {
            LOG.debug("matcher.group(1){" + matcher.group(1) + "}," +
                    "matcher.group(2){" + matcher.group(2) + "}," +
                    "matcher.group(3){" + matcher.group(3) + "}," +
                    "matcher.group(5){" + matcher.group(5) + "}," +
                    "matcher.group(4){" + matcher.group(4) + "}," +
                    "matcher.group(6){" + matcher.group(6) + "}");

            builder.with(matcher.group(1), matcher.group(2), matcher.group(3), matcher.group(5), matcher.group(4), matcher.group(6));
        }

        Specification<Patient> spec = builder.build();
        Pageable paging = PageRequest.of(pageNo, pageSize, (direction.equals("") || direction.equals("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending()));

        return patientRepository.findAll(spec, paging);
    }

    private Patient cloneWithStatus(Patient current, String status) {
        return Patient.create(
                current.id(),
                current.firstName(),
                current.lastName(),
                RecordStatus.create(status)
        );
    }

    @Override
    public void logicallyDelete(PatientId patientId) {
        findById(patientId).ifPresent(current -> {
            if (current.status().value().equals("R")) {
                return;
            }

            Patient toChangeStatus = cloneWithStatus(current, "R");
            patientRepository.save(toChangeStatus);
        });
    }

    @Override
    public void reactivate(PatientId patientId) {
        findById(patientId).ifPresent(current -> {
            if (current.status().value().equals("R") || current.status().value().equals("A")) {
                return;
            }

            Patient toChangeStatus = cloneWithStatus(current, "A");
            patientRepository.save(toChangeStatus);
        });
    }

    @Override
    public void deactivate(PatientId patientId) {
        findById(patientId).ifPresent(current -> {
            if (current.status().value().equals("R") || current.status().value().equals("D")) {
                return;
            }

            Patient toChangeStatus = cloneWithStatus(current, "D");
            patientRepository.save(toChangeStatus);
        });
    }

}