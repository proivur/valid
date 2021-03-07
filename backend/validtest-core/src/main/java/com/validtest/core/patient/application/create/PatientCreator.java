package com.validtest.core.patient.application.create;

import com.validtest.core.patient.domain.Patient;
import com.validtest.core.patient.domain.PatientRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("PatientCreator")
public class PatientCreator {

  private static final Logger LOG = LogManager.getLogger(PatientCreator.class);

  @Autowired
  private PatientRepository patientRepository;

  public void save(Patient patient) {
    patientRepository.create(patient);
  }

}
