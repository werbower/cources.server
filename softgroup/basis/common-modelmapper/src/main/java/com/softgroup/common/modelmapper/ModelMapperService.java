package com.softgroup.common.modelmapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperService implements ModelMapperInterface{
    private final ModelMapper modelMapper;

    public ModelMapperService() {
        modelMapper = new ModelMapper();
    }

    @Override
    public <D> D map(Object source, Class<D> destinationType) {
        return modelMapper.map(source,destinationType);
    }
}
