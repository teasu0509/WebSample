package com.tlg.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tlg.web.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

  Role findByName(String string);

}
