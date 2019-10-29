package com.employeeregistry.task.domain;

abstract class ID<ID> {
  protected ID id;

  public ID() {
  }

  public ID(ID id) {
    this.id = id;
  }

  public ID getId() {
    return id;
  }

  public void setId(ID id) {
    this.id = id;
  }
}
