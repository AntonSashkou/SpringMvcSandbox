package com.sashkou.sandbox.service;

import com.sashkou.sandbox.model.CreateDemoRequest;
import com.sashkou.sandbox.model.DemoDTO;
import com.sashkou.sandbox.model.UpdateDemoRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel="spring")
public interface DemoMapper {

    @Mapping(target = "name", source = "name")
    DemoDTO createDemoRequestToDemoDTO(CreateDemoRequest createDemoRequest);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    DemoDTO updateDemoRequestToDemoDTO(UpdateDemoRequest updateDemoRequest);
}
