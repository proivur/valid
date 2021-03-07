package com.validtest.core.patient.application.update;

import com.validtest.core.patient.domain.Patient;
import com.validtest.core.patient.domain.PatientRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("PatientUpdater")
public class PatientUpdater {

    private static final Logger LOG = LogManager.getLogger(PatientUpdater.class);

    @Autowired
    private PatientRepository patientRepository;

    public void reactivate(Patient patient) {
        patientRepository.reactivate(patient.id());
    }

    public void deactivate(Patient patient) {
        patientRepository.deactivate(patient.id());
    }

}
