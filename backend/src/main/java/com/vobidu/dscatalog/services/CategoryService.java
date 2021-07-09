package com.vobidu.dscatalog.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vobidu.dscatalog.dto.CategoryDTO;
import com.vobidu.dscatalog.entities.Category;
import com.vobidu.dscatalog.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	public List<CategoryDTO> findAll() {
		List<Category> list = repository.findAll();
		
		List<CategoryDTO> listDto = list.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
		
		return listDto;
	}
}
