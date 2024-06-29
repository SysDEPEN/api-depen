package com.br.depen.api_depen.services;

import java.util.List;
import java.util.Optional;

public interface RequerimentoInfo {

    RequerimentoInfo save(RequerimentoInfo requerimentoInfo);

    List<RequerimentoInfo> findAll();

    Optional<RequerimentoInfo> findById(Long id);

    RequerimentoInfo update (Long id, RequerimentoInfo requerimentoInfo);

    void deleteById(Long id);
}
