package com.tlg.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tlg.web.entity.Privilege;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {

  Privilege findByKey(String key);

}
