package com.court.management.repo;

import com.court.management.model.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserTable, Long> {

}
