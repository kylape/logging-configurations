/*
 * To the extent possible under law, Red Hat, Inc. has dedicated all copyright 
 * to this software to the public domain worldwide, pursuant to the CC0 Public 
 * Domain Dedication. This software is distributed without any warranty.  See 
 * <http://creativecommons.org/publicdomain/zero/1.0/>.
 */
package com.redhat.gss.logging;

import org.jboss.modules.ModuleClassLoader;

public class LoggingTest {
  private org.slf4j.Logger slf4j = null;
  private org.apache.log4j.Logger log4j = null;
  private org.jboss.logging.Logger jbossLogging = null;
  private java.util.logging.Logger julLogger = null;

  private Object[] loggers = null;

  public LoggingTest() {
    this(LoggingTest.class.getName());
  }

  public LoggingTest(String s) {
    slf4j = org.slf4j.LoggerFactory.getLogger(s);
    log4j = org.apache.log4j.Logger.getLogger(s);
    jbossLogging = org.jboss.logging.Logger.getLogger(s);
    julLogger = java.util.logging.Logger.getLogger(s);
    loggers = new Object[] {slf4j, log4j, jbossLogging, julLogger};
  }

  public void classInfo() {
    StringBuilder builder = new StringBuilder();
    builder.append("Class information:\n========================");
    for(Object logger : loggers) {
      builder.append("\nClass name:  " + logger.getClass().getName());
      builder.append("\nClassloader: ");
      ClassLoader cl = logger.getClass().getClassLoader();
      if(cl instanceof ModuleClassLoader) {
        ModuleClassLoader mcl = (ModuleClassLoader)cl;
        builder.append("ModuleClassLoader for module \"" + mcl.getModule().getIdentifier() + "\"");
      } else {
        builder.append(logger.getClass().getClassLoader());
      }
      builder.append("\n------------------------");
    }
    //Using JUL because it's probably the least likely to be misconfigured
    //Will go to server.log
    julLogger.info(builder.toString());
  }

  public void test() {
    System.out.println("Testing STDOUT");
    System.err.println("Testing STDERR");
    System.out.println("TCCL: " + Thread.currentThread().getContextClassLoader());
    slf4j.info("SFL4J");
    log4j.info("Log4J");
    jbossLogging.info("JBoss Logging");
    julLogger.info("JUL");
  }
}
