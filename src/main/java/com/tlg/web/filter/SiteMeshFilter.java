package com.tlg.web.filter;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

public class SiteMeshFilter extends ConfigurableSiteMeshFilter {
  @Override
  protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
    builder.addDecoratorPath("/*", "/WEB-INF/views/layouts/base.jsp");
    builder.addExcludedPath("/login*");
    builder.addExcludedPath("/logout*");
    builder.addExcludedPath("/admin/h2/*");
  }
}
