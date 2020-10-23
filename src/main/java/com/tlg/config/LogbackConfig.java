package com.tlg.config;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.rolling.FixedWindowRollingPolicy;
import ch.qos.logback.core.rolling.RollingFileAppender;
import ch.qos.logback.core.rolling.SizeBasedTriggeringPolicy;

@Configuration
public class LogbackConfig {

  @Value("${db.driver}")
  private String driver;

  @Value("${db.url}")
  private String url;

  @Value("${db.username}")
  private String username;

  @Value("${db.password}")
  private String password;

  @Value("${logback.file.path}")
  private String filePath;

  @Value("${logback.file.name}")
  private String fileName;

  @Value("${logback.file.maxFileSize}")
  private String maxFileSize;

  @Value("${logback.file.pattern}")
  private String filePattern;

  @Value("${logback.file.encoder}")
  private String fileEncoder;

  // @Bean
  // public DBAppender dbAppender() {
  //
  // Logger logger = (Logger)
  // LoggerFactory.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME);
  // logger.setLevel(Level.INFO);
  //
  // DriverManagerConnectionSource connSource = new
  // DriverManagerConnectionSource();
  // connSource.setDriverClass(driver);
  // connSource.setUrl(url);
  // connSource.setUser(username);
  // connSource.setPassword(password);
  // connSource.setContext(logger.getLoggerContext());
  // connSource.start();
  //
  // DBAppender dbAppender = new DBAppender();
  // dbAppender.setConnectionSource(connSource);
  // dbAppender.setContext(logger.getLoggerContext());
  // dbAppender.start();
  //
  // logger.addAppender(dbAppender);
  // return dbAppender;
  //
  // }

  @Bean
  public RollingFileAppender<ILoggingEvent> rollingFileAppender() {
    Logger logger = (Logger) LoggerFactory.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME);
    logger.setLevel(Level.INFO);

    RollingFileAppender<ILoggingEvent> rfAppender = new RollingFileAppender<>();
    rfAppender.setContext(logger.getLoggerContext());
    rfAppender.setFile(filePath + fileName);

    FixedWindowRollingPolicy rollingPolicy = new FixedWindowRollingPolicy();
    rollingPolicy.setContext(logger.getLoggerContext());
    rollingPolicy.setParent(rfAppender);
    rollingPolicy.setFileNamePattern(filePattern);
    rollingPolicy.start();

    SizeBasedTriggeringPolicy<ILoggingEvent> triggeringPolicy = new SizeBasedTriggeringPolicy<>();
    triggeringPolicy.setMaxFileSize(maxFileSize);
    triggeringPolicy.start();

    PatternLayoutEncoder encoder = new PatternLayoutEncoder();
    encoder.setContext(logger.getLoggerContext());
    encoder.setPattern(fileEncoder);
    encoder.start();

    rfAppender.setEncoder(encoder);
    rfAppender.setRollingPolicy(rollingPolicy);
    rfAppender.setTriggeringPolicy(triggeringPolicy);

    rfAppender.start();

    logger.addAppender(rfAppender);
    return rfAppender;

  }
}
