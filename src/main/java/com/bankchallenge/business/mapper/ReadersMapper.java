package com.bankchallenge.business.mapper;

import com.bankchallenge.business.dto.ReadersDto;
import com.bankchallenge.infrastructure.entity.Readers;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReadersMapper {

    Readers toEntity(final ReadersDto dto);
    List<Readers> toEntity(final List<ReadersDto> dto);

    ReadersDto toDto(final Readers entity);

    List<ReadersDto> toDto(final List<Readers> entity);
}
