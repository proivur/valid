package com.validtest.core.patient.infrastructure.persistence;

import com.validtest.core.patient.domain.Patient;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepositoryJPA extends PagingAndSortingRepository<Patient, Long>, JpaSpecificationExecutor {

}
