package com.university.app.university.service.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateStudentDTO {
	private String name;

	private Long universityId;

	private List<Long> courseIds;
}
