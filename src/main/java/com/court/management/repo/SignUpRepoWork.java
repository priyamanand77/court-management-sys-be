package com.court.management.repo;

import com.court.management.model.SignUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SignUpRepoWork extends JpaRepository<SignUp,Long> {

    Optional<SignUp> findByEmail(String email);
}
