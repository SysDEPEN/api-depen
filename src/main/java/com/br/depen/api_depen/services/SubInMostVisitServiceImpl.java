package com.br.depen.api_depen.services;

import java.util.List;
import java.util.Optional;

import com.br.depen.api_depen.entities.SubjectInmostVisit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.depen.api_depen.repository.SubInMostVisitRepository;

@Service
public class SubInMostVisitServiceImpl implements SubInMostVisitService{

    @Autowired
    private SubInMostVisitRepository subInMostVisitRepository;

    @Override
    public SubjectInmostVisit save(SubjectInmostVisit subInMostVisit) {
        return subInMostVisitRepository.save(subInMostVisit);
    }

    @Override
    public List<SubjectInmostVisit> findAll() {
        return subInMostVisitRepository.findAll();
    }

    @Override
    public Optional<SubjectInmostVisit> findById(Long id) {
        return subInMostVisitRepository.findById(id);
    }

    @Override
    public SubjectInmostVisit update(SubjectInmostVisit subInMostVisit) {
        return subInMostVisitRepository.save(subInMostVisit);
    }

    @Override
    public void deleteById(Long id) {
    	subInMostVisitRepository.deleteById(id);
    }
}