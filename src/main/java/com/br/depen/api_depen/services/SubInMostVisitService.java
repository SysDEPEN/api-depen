package com.br.depen.api_depen.services;

import com.br.depen.api_depen.entities.SubInMostVisit;
import java.util.List;
import java.util.Optional;

public interface SubInMostVisitService {

	SubInMostVisit save(SubInMostVisit subInMostVisit);

    List<SubInMostVisit> findAll();

    Optional<SubInMostVisit> findById(Long id);

    SubInMostVisit update (SubInMostVisit user);

    void deleteById(Long id);
}