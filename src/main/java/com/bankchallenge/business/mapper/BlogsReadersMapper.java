package com.bankchallenge.business.mapper;

import com.bankchallenge.business.dto.BlogsReadersDto;
import com.bankchallenge.infrastructure.entity.BlogsReaders;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BlogsReadersMapper {

    List<BlogsReadersDto> toDto(final List<BlogsReaders> entity);
    List<BlogsReaders> toEntity(final List<BlogsReadersDto> dto);


}
