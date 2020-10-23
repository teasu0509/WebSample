package com.tlg.web.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Entity
public class Role {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String key;

  private String name;
  @ManyToMany(mappedBy = "roles")
  private Collection<User> users;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "roles_privileges", joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "privilege_id", referencedColumnName = "id"))
  private Collection<Privilege> privileges;

  @SuppressWarnings("unused")
  private Role() {
    // Jpa use only
  }

  public Role(String key, String name) {
    this.key = key;
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Collection<User> getUsers() {
    return users;
  }

  public void setUsers(Collection<User> users) {
    this.users = users;
  }

  public Collection<Privilege> getPrivileges() {
    return privileges;
  }

  public void setPrivileges(Collection<Privilege> privileges) {
    this.privileges = privileges;
  }

  public GrantedAuthority toGrantedAuthority() {
    return new SimpleGrantedAuthority(getKey());
  }
}