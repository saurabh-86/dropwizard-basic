package com.company.core.services;

import com.company.api.PersonDTO;

import java.util.UUID;

public interface PersonService {

    PersonDTO get(UUID personId);

    void createOrUpdate(UUID personId, PersonDTO updatedPerson);
}
