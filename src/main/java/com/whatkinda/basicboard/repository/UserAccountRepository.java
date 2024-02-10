package com.whatkinda.basicboard.repository;

import com.whatkinda.basicboard.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
}
