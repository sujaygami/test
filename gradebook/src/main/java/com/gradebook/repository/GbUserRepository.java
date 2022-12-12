package com.gradebook.repository;

import com.gradebook.model.GbUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GbUserRepository extends JpaRepository<GbUser, String> {
}
