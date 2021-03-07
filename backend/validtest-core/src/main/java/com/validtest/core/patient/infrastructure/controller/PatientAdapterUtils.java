package com.validtest.core.patient.infrastructure.controller;

import com.validtest.core.patient.domain.*;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public final class PatientAdapterUtils {

  private PatientAdapterUtils() {
  }

  public static PatientRequest adaptToPO(Patient entity) {
    if (entity == null) {
      return null;
    }

    PatientRequest patient = new PatientRequest();
    patient.setFirstName(entity.firstName().value());
    patient.setLastName(entity.lastName().value());
    patient.setStatus(entity.status().value());

    return patient;
  }

  public static List<PatientRequest> adapt(List<Patient> patients) {
    List<PatientRequest> response = new ArrayList<>();

    if (patients != null && patients.isEmpty()) {
      return response;
    }

    for (final Patient patient : patients) {
      response.add(adaptToPO(patient));
    }

    return response;
  }



}
