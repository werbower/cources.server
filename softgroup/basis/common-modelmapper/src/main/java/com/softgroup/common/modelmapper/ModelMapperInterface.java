package com.softgroup.common.modelmapper;

public interface ModelMapperInterface {
    <D> D map(Object source, Class<D> destinationType);
}
