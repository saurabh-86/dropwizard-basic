package com.company.core.services;

import com.company.api.PersonDTO;
import com.company.core.mappers.PersonMapper;
import com.company.db.daos.PersonDAO;
import com.company.db.entities.Person;
import com.google.inject.Inject;
import lombok.RequiredArgsConstructor;

import javax.ws.rs.NotFoundException;
import java.util.UUID;

@RequiredArgsConstructor(onConstructor = @_(@Inject))
public class PersonServiceImpl implements PersonService {

    private final PersonDAO personDAO;

    @Override
    public UUID createPerson(PersonDTO newPerson) {
        Person person = PersonMapper.transform(newPerson);
        return personDAO.create(person);
    }

    @Override
    public PersonDTO getPerson(UUID personId) {
        Person personEntity = personDAO.findById(personId);
        return PersonMapper.transform(personEntity);
    }

    @Override
    public void updatePerson(UUID personId, PersonDTO updatedPerson) {
        Person personEntity = personDAO.findById(personId);
        if (personEntity == null)
            throw new NotFoundException();

        PersonMapper.updateEntity(personEntity, updatedPerson);

        personDAO.update(personEntity);
    }
}
