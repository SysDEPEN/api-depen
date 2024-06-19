package com.br.depen.api_depen.services;

import com.br.depen.api_depen.entities.SubjectInmostVisit;
import java.util.List;
import java.util.Optional;

public interface SubInMostVisitService {

    SubjectInmostVisit save(SubjectInmostVisit subjectInmostVisit);

    List<SubjectInmostVisit> findAll();

    Optional<SubjectInmostVisit> findById(Long id);

    SubjectInmostVisit update (SubjectInmostVisit user);

    void deleteById(Long id);
}