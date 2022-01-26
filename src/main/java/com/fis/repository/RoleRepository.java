package com.fis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fis.model.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
