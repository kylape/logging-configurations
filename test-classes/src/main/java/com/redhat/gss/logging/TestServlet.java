package com.redhat.gss.logging;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.ServletException;

public class TestServlet extends HttpServlet {
  
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    try {
      LoggingTest test = new LoggingTest();
      test.test();
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}
