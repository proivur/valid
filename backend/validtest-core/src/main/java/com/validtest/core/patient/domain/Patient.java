package com.validtest.core.patient.domain;

import com.validtest.shared.domain.*;

/**
 * Patient domain model.
 */
public class Patient extends AggregateRoot {

  private PatientId id;
  private FirstName firstName;
  private LastName lastName;
  private RecordStatus status;

  public static Patient create(PatientId id, FirstName firstName, LastName lastName, RecordStatus status) {

    Patient patient = new Patient(id, firstName, lastName, status);

    return patient;
  }

  public Patient(PatientId id) {
    this.id = id;
  }

  public Patient(PatientId id, FirstName firstName, LastName lastName, RecordStatus status) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.status = status;
  }

  public Patient() {
    super();
  }

  public static Patient create(String id) {
    Patient patient = new Patient(PatientId.create(id));

    return patient;
  }

  public PatientId id() {
    return id;
  }

  public FirstName firstName() {
    return firstName;
  }

  public LastName lastName() {
    return lastName;
  }

  public RecordStatus status() {
    return status;
  }

}
