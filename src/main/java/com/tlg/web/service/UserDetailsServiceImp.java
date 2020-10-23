package com.tlg.web.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tlg.web.entity.Privilege;
import com.tlg.web.entity.Role;
import com.tlg.web.entity.User;
import com.tlg.web.repository.RoleRepository;
import com.tlg.web.repository.UserRepository;

@Service("userDetailsService")
@Transactional
public class UserDetailsServiceImp implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RoleRepository roleRepository;

  @Override
  public UserDetails loadUserByUsername(String email) {
    User user = userRepository.findByEmail(email);
    if (user == null) {
      return new org.springframework.security.core.userdetails.User(" ", " ", true, true, true, true,
          getAuthorities(Arrays.asList(roleRepository.findByName("ROLE_USER"))));
    }

    return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), user.isEnabled(),
        true, true, true, getAuthorities(user.getRoles()));
  }

  private Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles) {
    return getGrantedAuthorities(roles);
  }

  private List<GrantedAuthority> getGrantedAuthorities(Collection<Role> roles) {
    List<GrantedAuthority> authorities = new ArrayList<>();
    for (Role role : roles) {
      authorities.add(role.toGrantedAuthority());
      for (Privilege priv : role.getPrivileges()) {
        authorities.add(priv.toGrantedAuthority());
      }
    }
    return authorities;
  }
}