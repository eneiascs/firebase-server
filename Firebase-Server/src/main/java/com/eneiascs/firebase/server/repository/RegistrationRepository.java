package com.eneiascs.firebase.server.repository;

import org.springframework.data.repository.CrudRepository;

import com.eneiascs.firebase.server.domain.Registration;

public interface RegistrationRepository extends CrudRepository<Registration, Long> {

}
