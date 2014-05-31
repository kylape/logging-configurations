package com.redhat.gss.logging;

import javax.jws.WebService;

@WebService(endpointInterface="com.redhat.gss.logging.TestEndpoint",
            serviceName="TestEndpoint")
public class TestEndpointImpl implements TestEndpoint {
  public void logTest() {
    LoggingTest test = new LoggingTest(TestEndpoint.class.getName());
    test.test();
    test.classInfo();
  }
}
