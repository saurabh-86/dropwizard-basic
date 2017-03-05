package com.company.core.mappers;

import com.company.api.PersonDTO;
import com.company.db.entities.Person;

public class PersonMapper {

    public static PersonDTO transform(Person entity) {
        PersonDTO dto = null;
        if (entity != null) {
            dto = PersonDTO.builder()
                    .id(entity.getId())
                    .name(entity.getName())
                    .version(entity.getVersion())
                    .build();
        }
        return dto;
    }
}
