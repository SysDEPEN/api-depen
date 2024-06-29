package com.br.depen.api_depen.services;

import com.br.depen.api_depen.entities.RequerimentoInfo;

import java.util.List;
import java.util.Optional;

public interface RequerimentoInfoService {

    RequerimentoInfo save(RequerimentoInfo requerimentoInfo);

    List<RequerimentoInfo> findAll();

    Optional<RequerimentoInfo> findById(Long id);

    RequerimentoInfo update(Long id, RequerimentoInfo protocols);

    void deleteById(Long id);
}
