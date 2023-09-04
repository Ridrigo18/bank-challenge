package com.bankchallenge.business.mapper;

import com.bankchallenge.business.dto.LoginUserDto;
import com.bankchallenge.infrastructure.entity.LoginUser;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LoginUserMapper {


    LoginUser toEntity(final LoginUserDto dto);

    LoginUserDto toDto(final LoginUser entity);
}
