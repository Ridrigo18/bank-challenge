package com.bankchallenge.business.service.impl;


import com.bankchallenge.business.dto.BlogsDto;
import com.bankchallenge.business.dto.BlogsReadersDto;
import com.bankchallenge.business.dto.ReadersDto;
import com.bankchallenge.business.mapper.BlogsMapper;
import com.bankchallenge.business.mapper.BlogsReadersMapper;
import com.bankchallenge.business.mapper.ReadersMapper;
import com.bankchallenge.business.service.BlogsReadersService;
import com.bankchallenge.infrastructure.entity.BlogsReaders;
import com.bankchallenge.infrastructure.repository.BlogReadersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BlogReadersServiceImpl implements BlogsReadersService {

    @Autowired
    private BlogReadersRepository blogsRepository;

    @Autowired
    private BlogsReadersMapper blogsReadersMapper;

    @Autowired
    private BlogsMapper blogsMapper;
    @Autowired
    private ReadersMapper readersMapper;

    @Override
    public void save(final Long id, final BlogsDto blogsDto, final ReadersDto readersDto) {
        final BlogsReaders blogsReaders = new BlogsReaders();
        if (id != null) {
            blogsReaders.setId(id);
        }
        blogsReaders.setBlog(blogsMapper.toEntity(blogsDto));
        blogsReaders.setReader(readersMapper.toEntity(readersDto));
        blogsRepository.save(blogsReaders);
    }

    @Override
    public List<BlogsReadersDto> getAll() {
        return blogsReadersMapper.toDto(blogsRepository.findAll());
    }

    @Override
    public void delete(List<BlogsReadersDto> listDto) {
        blogsRepository.deleteAll(blogsReadersMapper.toEntity(listDto));
    }


}
