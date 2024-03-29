package com.university.app.university.service;

import java.util.List;
import java.util.Optional;

import com.university.app.university.exception.AlreadyExistException;
import com.university.app.university.exception.NotExistException;
import com.university.app.university.service.dto.UniversityDTO;

/**
 * @author Thinh Tat
 *
 */
public interface UniversityService {
	UniversityDTO save(UniversityDTO universityDTO) throws AlreadyExistException;

	List<UniversityDTO> findAll();

	Optional<UniversityDTO> findOne(Long id);

	void delete(Long id) throws NotExistException;
}
