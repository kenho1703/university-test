package com.university.app.university.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.university.app.university.domain.University;
import com.university.app.university.repository.UniversityRepository;
import com.university.app.university.service.UniversityService;
import com.university.app.university.service.dto.UniversityDTO;
import com.university.app.university.service.mapper.UniversityMapper;

@Service
@Transactional
public class UniversityServiceImpl implements UniversityService {

	@Autowired
	private UniversityRepository universityRepository;

	@Autowired
	private UniversityMapper universityMapper;

	@Override
	public UniversityDTO save(UniversityDTO universityDTO) {
		University university = universityMapper.toEntity(universityDTO);
		university = universityRepository.save(university);
		return universityMapper.toDto(university);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UniversityDTO> findAll() {
		return universityRepository.findAll().stream().map(universityMapper::toDto)
				.collect(Collectors.toCollection(LinkedList::new));
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<UniversityDTO> findOne(Long id) {
		return universityRepository.findById(id).map(universityMapper::toDto);
	}

	@Override
	public void delete(Long id) {
		universityRepository.deleteById(id);
	}

}
