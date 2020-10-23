package com.tlg.web.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.tlg.web.repository.PrivilegeRepository;
import com.tlg.web.repository.RoleRepository;
import com.tlg.web.repository.UserRepository;

@Component
public class UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RoleRepository roleRepository;

  @Autowired
  private PrivilegeRepository privilegeRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Transactional
  public void initSystem() {

  }

}
