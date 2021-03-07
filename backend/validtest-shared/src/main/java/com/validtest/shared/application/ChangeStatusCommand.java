package com.validtest.shared.application;

import com.validtest.shared.domain.bus.command.Command;

public class ChangeStatusCommand implements Command {

  protected String id;
  protected String status;

  public String id() {
    return id;
  }
  public String status() {
    return status;
  }

}