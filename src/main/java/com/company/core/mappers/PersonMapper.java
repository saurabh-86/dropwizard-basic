package com.company.core.mappers;

import com.company.api.PersonDTO;
import com.company.db.entities.Person;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    PersonDTO transform(Person entity);

    Person updateEntity(PersonDTO personDTO, @MappingTarget Person person);
}
