package com.tlg.web.listener;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.tlg.web.entity.Privilege;
import com.tlg.web.entity.Role;
import com.tlg.web.entity.User;
import com.tlg.web.repository.PrivilegeRepository;
import com.tlg.web.repository.RoleRepository;
import com.tlg.web.repository.UserRepository;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

  private static final Logger log = LoggerFactory.getLogger(SetupDataLoader.class);

  boolean alreadySetup = false;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RoleRepository roleRepository;

  @Autowired
  private PrivilegeRepository privilegeRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  @Transactional
  public void onApplicationEvent(ContextRefreshedEvent event) {
    if (alreadySetup)
      return;
    log.info("SetupDataLoader Setup!");
    Privilege readPrivilege = createPrivilegeIfNotFound("READ_PRIVILEGE");
    Privilege writePrivilege = createPrivilegeIfNotFound("WRITE_PRIVILEGE");

    List<Privilege> adminPrivileges = Arrays.asList(readPrivilege, writePrivilege);
    createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
    createRoleIfNotFound("ROLE_USER", Arrays.asList(readPrivilege));

    Role adminRole = roleRepository.findByName("ROLE_ADMIN");
    Role userRole = roleRepository.findByName("ROLE_USER");

    User user = new User();
    user.setFirstName("Test");
    user.setLastName("Test");
    user.setPassword(passwordEncoder.encode("test"));
    user.setEmail("test@test.com");
    user.setRoles(Arrays.asList(adminRole, userRole));
    user.setEnabled(true);
    userRepository.save(user);

    user = new User();
    user.setFirstName("Test");
    user.setLastName("Test");
    user.setPassword(passwordEncoder.encode("a"));
    user.setEmail("a@test.com");
    user.setRoles(Arrays.asList(userRole));
    user.setEnabled(true);
    userRepository.save(user);

    alreadySetup = true;
  }

  @Transactional
  Privilege createPrivilegeIfNotFound(String key) {
    Privilege privilege = privilegeRepository.findByKey(key);
    if (privilege == null) {
      privilege = new Privilege(key, key, "#");
      privilegeRepository.save(privilege);
    }
    return privilege;
  }

  @Transactional
  Role createRoleIfNotFound(String name, Collection<Privilege> privileges) {
    Role role = roleRepository.findByName(name);
    if (role == null) {
      role = new Role(name, name);
      role.setPrivileges(privileges);
      roleRepository.save(role);
    }
    return role;
  }
}