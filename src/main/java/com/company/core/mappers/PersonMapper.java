package com.company.core.mappers;

import com.company.api.PersonDTO;
import com.company.db.entities.Person;

public class PersonMapper {

    public static PersonDTO transform(Person entity) {
        PersonDTO dto = null;
        if (entity != null) {
            dto = PersonDTO.builder()
                    .name(entity.getName())
                    .version(entity.getVersion())
                    .build();
        }
        return dto;
    }

    public static void updateEntity(Person entity, PersonDTO dto) {
        entity.setName(dto.getName());
        entity.setVersion(dto.getVersion());
    }
}
