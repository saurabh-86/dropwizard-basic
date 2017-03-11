package com.company.resources;

import com.company.DropwizardBasicApplication;
import com.company.DropwizardBasicConfiguration;
import com.company.api.PersonDTO;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit.DropwizardAppRule;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonResourceAcceptanceTest {

    @ClassRule
    public static final DropwizardAppRule<DropwizardBasicConfiguration> RULE =
            new DropwizardAppRule<>(DropwizardBasicApplication.class, ResourceHelpers.resourceFilePath("my-app-config.yaml"));

    @Test
    public void testPutAndGet() {
        Client client = new JerseyClientBuilder(RULE.getEnvironment()).build("test client");

        UUID personId = UUID.randomUUID();
        PersonDTO personDTO = PersonDTO.builder().name("saurabh").build();

        Response putResponse = client.target(
                String.format("http://localhost:%d/persons/%s", RULE.getLocalPort(), personId))
                .request()
                .put(Entity.json(personDTO));

        assertThat(putResponse.getStatusInfo().getFamily()).isEqualTo(Response.Status.Family.SUCCESSFUL);

        Response getResponse = client.target(
                String.format("http://localhost:%d/persons/%s", RULE.getLocalPort(), personId))
                .request().get();

        assertThat(getResponse.readEntity(PersonDTO.class).getName()).isEqualTo("saurabh");
    }

}
