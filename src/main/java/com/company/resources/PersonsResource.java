package com.company.resources;

import com.company.api.PersonDTO;
import com.company.core.services.PersonService;
import com.google.inject.Inject;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.UUID;

@Path("/persons")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonsResource {

    private final PersonService personService;

    @Inject
    public PersonsResource(PersonService personService) {
        this.personService = personService;
    }

    @GET
    @Path("/{personId}")
    @UnitOfWork
    public PersonDTO get(@PathParam("personId") UUID personId) {
        return personService.get(personId);
    }

    @PUT
    @Path("/{personId}")
    @UnitOfWork
    public void createOrUpdate(@PathParam("personId") UUID personId, PersonDTO updatedPerson) {
        personService.createOrUpdate(personId, updatedPerson);
    }
}
