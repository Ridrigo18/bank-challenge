package com.bankchallenge.business.service;

import com.bankchallenge.business.dto.ReadersDto;

import java.util.List;

public interface ReadersService {

    List<ReadersDto> getAll();

    void save(final ReadersDto dto);

    boolean isExistReaderById(final String name, final Long id);

    boolean isExistReader(final ReadersDto readersDto);

    void delete(final List<ReadersDto> list);

}
