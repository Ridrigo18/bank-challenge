package com.bankchallenge.business.service.impl;


import com.bankchallenge.business.dto.BlogsDto;
import com.bankchallenge.business.mapper.BlogsMapper;
import com.bankchallenge.business.mapper.ReadersMapper;
import com.bankchallenge.business.service.BlogsService;
import com.bankchallenge.infrastructure.entity.Blogs;
import com.bankchallenge.infrastructure.entity.Readers;
import com.bankchallenge.infrastructure.repository.BlogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BlogServiceImpl implements BlogsService {

    @Autowired
    private BlogsRepository repository;

    @Autowired
    private BlogsMapper mapper;


    @Override
    public List<BlogsDto> getAll() {
        return mapper.toDto(repository.findAll());
    }

    @Override
    public void save(BlogsDto dto) {
        final Blogs entity = mapper.toEntity(dto);
        repository.save(entity);
    }

    @Override
    public boolean isExistReaderById(String title, Long id) {
        return repository.getByNameWithoutId(title, id).isPresent();
    }

    @Override
    public boolean isExistReader(BlogsDto readersDto) {
        return repository.getReaderByTitle(readersDto.getTitle()).isPresent();
    }

    @Override
    public void delete(List<BlogsDto> list) {
        final List<Blogs> listEntity = mapper.toEntity(list);
        repository.deleteAll(listEntity);
    }

    @Override
    public List<BlogsDto> getBlobs(Long idReader) {
        return mapper.toDto(repository.getBlogs(idReader));
    }
}
