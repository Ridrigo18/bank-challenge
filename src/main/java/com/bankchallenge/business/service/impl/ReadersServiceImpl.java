package com.bankchallenge.business.service.impl;

import com.bankchallenge.business.dto.ReadersDto;
import com.bankchallenge.business.mapper.ReadersMapper;
import com.bankchallenge.business.service.ReadersService;
import com.bankchallenge.infrastructure.entity.Readers;
import com.bankchallenge.infrastructure.repository.ReadersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReadersServiceImpl implements ReadersService {

    @Autowired
    private ReadersRepository readersRepository;

    @Autowired
    private ReadersMapper readersMapper;

    @Override
    public List<ReadersDto> getAll() {
        return readersMapper.toDto(readersRepository.findAll());
    }

    public void save(final ReadersDto dto) {
        final Readers entity = readersMapper.toEntity(dto);
        readersRepository.save(entity);
    }

    @Override
    public boolean isExistReaderById(String name, Long id) {
        return readersRepository.getReadersByNameWithoutId(name, id).isPresent();
    }

    @Override
    public boolean isExistReader(final ReadersDto readersDto) {
        return readersRepository.getReaderByName(readersDto.getName()).isPresent();
    }

    @Override
    public void delete(final List<ReadersDto> list) {
        final List<Readers> listEntity = readersMapper.toEntity(list);
        readersRepository.deleteAll(listEntity);
    }

}
