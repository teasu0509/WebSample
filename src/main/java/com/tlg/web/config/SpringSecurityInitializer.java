package com.tlg.web.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.tlg.web.filter.SiteMeshFilter;

public class SpringSecurityInitializer extends AbstractSecurityWebApplicationInitializer {
  @Override
  protected void beforeSpringSecurityFilterChain(ServletContext servletContext) {
    FilterRegistration.Dynamic characterEncodingFilter = servletContext.addFilter("encodingFilter",
        new CharacterEncodingFilter());
    characterEncodingFilter.setInitParameter("encoding", "UTF-8");
    characterEncodingFilter.setInitParameter("forceEncoding", "true");
    characterEncodingFilter.addMappingForUrlPatterns(null, true, "/*");
  }

  @Override
  protected void afterSpringSecurityFilterChain(ServletContext servletContext) {
    insertFilters(servletContext, new SiteMeshFilter());
  }
}
