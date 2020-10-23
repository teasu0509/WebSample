package com.tlg.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Home {

  @GetMapping(value = { "home", "/" })
  public String homePage() {
    return "home";
  }

  @GetMapping("login")
  public String loginPage(@RequestParam(value = "error", required = false) String error,
      @RequestParam(value = "logout", required = false) String logout, Model model) {
    String errorMessge = null;
    if (error != null) {
      errorMessge = "使用者密碼錯誤或不存在！！";
    }
    if (logout != null) {
      errorMessge = "您已成功登出！！";
    }
    model.addAttribute("errorMessge", errorMessge);
    return "login";
  }

  @GetMapping("logout")
  public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if (auth != null) {
      new SecurityContextLogoutHandler().logout(request, response, auth);
    }
    return "redirect:/login?logout=true";
  }
}
