package com.company.core.services;

import com.company.api.PersonDTO;

import java.util.UUID;

public interface PersonService {

    UUID createPerson(PersonDTO newPerson);

    PersonDTO getPerson(UUID personId);

    void updatePerson(UUID personId, PersonDTO updatedPerson);
}
