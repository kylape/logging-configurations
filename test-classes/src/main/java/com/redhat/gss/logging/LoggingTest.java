/*
 * To the extent possible under law, Red Hat, Inc. has dedicated all copyright 
 * to this software to the public domain worldwide, pursuant to the CC0 Public 
 * Domain Dedication. This software is distributed without any warranty.  See 
 * <http://creativecommons.org/publicdomain/zero/1.0/>.
 */
package com.redhat.gss.logging;

public class LoggingTest {
  private org.slf4j.Logger slf4j                = org.slf4j.LoggerFactory.getLogger(this.getClass());
  private org.apache.log4j.Logger log4j         = org.apache.log4j.Logger.getLogger(this.getClass());
  private org.jboss.logging.Logger jbossLogging = org.jboss.logging.Logger.getLogger(this.getClass());
  private java.util.logging.Logger julLogger    = java.util.logging.Logger.getLogger(this.getClass().getName());

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
