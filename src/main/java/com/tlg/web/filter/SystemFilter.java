package com.tlg.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName = "SystemFilter", urlPatterns = "/*")
public class SystemFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    // Do nothing
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    // request
    chain.doFilter(request, response); // 驗證JWT待開發...
    // response
  }

  @Override
  public void destroy() {
    // Do nothing
  }
}
