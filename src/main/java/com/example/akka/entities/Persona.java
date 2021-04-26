package com.example.akka.entities;

import java.io.Serializable;

public class Persona implements Serializable {
  private String email;
  private String mobilePhoneNumber;
  private String officePhoneNumber;
  private String firstName;
  private String middleName;
  private String lastName;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getMobilePhoneNumber() {
    return mobilePhoneNumber;
  }

  public void setMobilePhoneNumber(String mobilePhoneNumber) {
    this.mobilePhoneNumber = mobilePhoneNumber;
  }

  public String getOfficePhoneNumber() {
    return officePhoneNumber;
  }

  public void setOfficePhoneNumber(String officePhoneNumber) {
    this.officePhoneNumber = officePhoneNumber;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
}
