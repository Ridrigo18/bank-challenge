package com.bankchallenge.business.service;

import com.bankchallenge.business.dto.BlogsDto;
import com.bankchallenge.infrastructure.entity.Blogs;

import java.util.List;

public interface BlogsService {

    List<BlogsDto> getAll();

    void save(final BlogsDto dto);

    boolean isExistReaderById(final String title, final Long id);

    boolean isExistReader(final BlogsDto readersDto);

    void delete(final List<BlogsDto> list);

    List<BlogsDto> getBlobs(final Long idReader);


}
