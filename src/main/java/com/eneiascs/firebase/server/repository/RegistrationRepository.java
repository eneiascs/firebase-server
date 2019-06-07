package com.eneiascs.firebase.server.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.eneiascs.firebase.server.domain.Registration;

public interface RegistrationRepository extends CrudRepository<Registration, Long> {
	@Query("select r from Registration r where r.token=:token and r.id = (select max(reg.id) from Registration reg)")
	Optional<Registration> findCurrentRegistration(@Param("token") String token);

}
