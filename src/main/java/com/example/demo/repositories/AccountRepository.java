package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Account;

public interface AccountRepository extends
		JpaRepository<Account, Integer> {
	@Query(value = "SELECT acc FROM Account acc "
			+ "WHERE acc.email LIKE '%:email%'")
	public Account findByEmail(@Param("email")String email);
}
