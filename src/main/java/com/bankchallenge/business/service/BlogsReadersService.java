package com.bankchallenge.business.service;

import com.bankchallenge.business.dto.BlogsDto;
import com.bankchallenge.business.dto.BlogsReadersDto;
import com.bankchallenge.business.dto.ReadersDto;

import java.util.List;

public interface BlogsReadersService {

    void save(final Long id, final BlogsDto blogsDto, final ReadersDto readersDto);

    List<BlogsReadersDto> getAll();

    void delete(final List<BlogsReadersDto> listDto);

}
