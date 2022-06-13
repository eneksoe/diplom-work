package com.bta.diplom.mapper;

import java.util.List;
import java.util.stream.Collectors;

public interface WebMapper<D, E> {
    D toDto(E entity);

    E toEntity(D dto);

    default List<D> toDtos(List<E> entities) {
        return entities.stream()
                .map(entity -> toDto(entity))
                .collect(Collectors.toList());
    }

    default List<E> toEntities(List<D> dtos) {
        return dtos.stream()
                .map(dto -> toEntity(dto))
                .collect(Collectors.toList());
    }

    ;
}