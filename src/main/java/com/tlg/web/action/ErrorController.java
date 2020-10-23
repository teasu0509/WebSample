package com.tlg.web.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("/errors")
public class ErrorController {

  @RequestMapping("sysError403")
  public String accesssDenied() {
    return "errors/sysError403";
  }

  @RequestMapping("sysError404")
  public String noFoundPage() {
    return "errors/sysError404";
  }

  @RequestMapping("sysError500")
  public String internalServer() {
    return "errors/sysError500";
  }

  @RequestMapping("")
  public String errorH() {
    return "errors/sysError404";
  }

}
