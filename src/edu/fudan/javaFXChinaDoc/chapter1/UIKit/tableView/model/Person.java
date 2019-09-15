package edu.fudan.javaFXChinaDoc.chapter1.UIKit.tableView.model;

import javafx.beans.property.SimpleStringProperty;

public class Person {
  private final SimpleStringProperty firstName;
  private final SimpleStringProperty secondName;
  private final SimpleStringProperty email;

  public Person(String firstName, String secondName, String email) {
    this.firstName = new SimpleStringProperty(firstName);
    this.secondName = new SimpleStringProperty(secondName);
    this.email = new SimpleStringProperty(email);
  }

  public String getFirstName() {
    return firstName.get();
  }

  public SimpleStringProperty firstNameProperty() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName.set(firstName);
  }

  public String getSecondName() {
    return secondName.get();
  }

  public SimpleStringProperty secondNameProperty() {
    return secondName;
  }

  public void setSecondName(String secondName) {
    this.secondName.set(secondName);
  }

  public String getEmail() {
    return email.get();
  }

  public SimpleStringProperty emailProperty() {
    return email;
  }

  public void setEmail(String email) {
    this.email.set(email);
  }
}
