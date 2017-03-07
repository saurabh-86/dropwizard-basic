package com.company.resources;

import com.company.api.PersonDTO;
import com.company.core.services.PersonService;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class PersonsResourceTest {

    private static final PersonService personService = mock(PersonService.class);

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new PersonsResource(personService))
            .build();

    @Test
    public void testCreatePersonInvalid() {
        PersonDTO personDTO = PersonDTO.builder().build();
        Response response = resources.client().target("/persons/b1fa5899-91d3-4572-94ca-9ecd849e3fe1")
                .request().put(Entity.entity(personDTO, MediaType.APPLICATION_JSON_TYPE));
        assertThat(response.getStatus()).isEqualTo(422);
    }
}
