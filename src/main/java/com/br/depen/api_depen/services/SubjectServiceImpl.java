package com.br.depen.api_depen.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.depen.api_depen.entities.Subject;
import com.br.depen.api_depen.repository.SubjectRepository;

@Service
public class SubjectServiceImpl implements SubjectService{
	 @Autowired
	    private SubjectRepository subjectRepository;

	    @Override
	    public Subject save(Subject subject) {
	        return subjectRepository.save(subject);
	    }

	    @Override
	    public List<Subject> findAll() {
	        return subjectRepository.findAll();
	    }

	    @Override
	    public Optional<Subject> findById(Long id) {
	        return subjectRepository.findById(id);
	    }

	    @Override
	    public Subject update(Subject subject) {
	        return subjectRepository.save(subject);
	    }

	    @Override
	    public void deleteById(Long id) {
	    	subjectRepository.deleteById(id);
	    }
}