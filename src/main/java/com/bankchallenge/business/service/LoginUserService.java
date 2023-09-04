package com.bankchallenge.business.service;

import com.bankchallenge.business.dto.LoginUserDto;

public interface LoginUserService {

    LoginUserDto getUserByEmail(final String email);

    void save(final LoginUserDto loginUserDto);
}
