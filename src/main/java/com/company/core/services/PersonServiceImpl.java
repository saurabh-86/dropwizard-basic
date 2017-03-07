package com.company.core.services;

import com.company.api.PersonDTO;
import com.company.core.mappers.PersonMapper;
import com.company.db.daos.PersonDAO;
import com.company.db.entities.Person;
import com.google.inject.Inject;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor(onConstructor = @_(@Inject))
public class PersonServiceImpl implements PersonService {

    private final PersonDAO personDAO;

    @Override
    public PersonDTO get(UUID personId) {
        Person personEntity = personDAO.findById(personId);
        return PersonMapper.INSTANCE.transform(personEntity);
    }

    @Override
    public void createOrUpdate(UUID personId, PersonDTO updatedPerson) {
        Person personEntity = personDAO.findById(personId);

        if (personEntity == null) {
            personEntity = new Person();
            personEntity.setId(personId);
        }

        personEntity = PersonMapper.INSTANCE.updateEntity(updatedPerson, personEntity);

        personDAO.createOrUpdate(personEntity);
    }
}
