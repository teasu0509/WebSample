package com.tlg.web.entity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Entity
public class Privilege {

  public static final Privilege USERMANAGER = new Privilege("Meun.UserManager", "使用者管理", "userManager");
  public static final Privilege ROLEMANAGER = new Privilege("Meun.RoleManager", "角色管理", "roleManager");
  public static final Privilege MEUNMANAGER = new Privilege("Meun.MeunManager", "選單管理", "meunManager");

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(unique = true)
  private String key;

  private String name;

  private String url;

  @ManyToMany(mappedBy = "privileges")
  private Collection<Role> roles;

  @SuppressWarnings("unused")
  private Privilege() {
    // Jpa use only
  }

  public Privilege(String key, String name, String url) {
    this.key = key;
    this.name = name;
    this.url = url;
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

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public Collection<Role> getRoles() {
    return roles;
  }

  public void setRoles(Collection<Role> roles) {
    this.roles = roles;
  }

  public GrantedAuthority toGrantedAuthority() {
    return new SimpleGrantedAuthority(getKey());
  }
}
