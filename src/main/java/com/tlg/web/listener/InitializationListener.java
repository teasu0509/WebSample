package com.tlg.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebListener
public class InitializationListener implements ServletContextListener {
  private static final Logger log = LoggerFactory.getLogger(InitializationListener.class);

  @Override
  public void contextDestroyed(ServletContextEvent e) {
    log.info("{} : The application stopped", e.getServletContext().getContextPath());
  }

  @Override
  public void contextInitialized(ServletContextEvent e) {
    log.info("{} : The application started", e.getServletContext().getContextPath());
  }

}
