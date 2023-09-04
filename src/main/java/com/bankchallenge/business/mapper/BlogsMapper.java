package com.bankchallenge.business.mapper;

import com.bankchallenge.business.dto.BlogsDto;
import com.bankchallenge.infrastructure.entity.Blogs;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BlogsMapper {

    Blogs toEntity(final BlogsDto dto);

    BlogsDto toDto(final Blogs entity);

    List<BlogsDto> toDto(final List<Blogs> entity);
    List<Blogs> toEntity(final List<BlogsDto> dto);

}
