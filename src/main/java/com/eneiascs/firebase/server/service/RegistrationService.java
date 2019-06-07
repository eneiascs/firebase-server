package com.eneiascs.firebase.server.service;

import java.util.Optional;

import com.eneiascs.firebase.server.domain.Registration;
import com.eneiascs.firebase.server.domain.dto.RegistrationDTO;

public interface RegistrationService {

	Iterable<Registration> findAll();

	Optional<Registration> findById(Long id);

	void delete(Registration registration);

	Registration save(Registration registration);

	RegistrationDTO register(RegistrationDTO registrationDTO);

	Optional<Registration> findCurrentRegistration(String token);
}