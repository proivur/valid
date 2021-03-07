package com.validtest.shared.infrastructure.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExceptionUtils {

  private static final Logger LOG = LogManager.getLogger(ExceptionUtils.class);

  private ExceptionUtils() {
  }

  public static void handleException (Exception ex)
  {
    LOG.error(ex, ex);
  }

}
