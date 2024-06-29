package com.br.depen.api_depen.services;

import com.br.depen.api_depen.repository.RequerimentosInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class RequerimentosInfoImpl implements RequerimentoInfo{

    @Autowired
    private RequerimentosInfoRepository requerimentosInfoRepository;

    @Override
    public RequerimentoInfo save(RequerimentoInfo requerimentoInfo) {
        return RequerimentosInfoRepository.save(requerimentoInfo);
    }

    @Override
    public List<RequerimentoInfo> findAll() {
        return RequerimentosInfoRepository.findAll();
    }

    @Override
    public Optional<RequerimentoInfo> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public RequerimentoInfo update(Long id, RequerimentoInfo requerimentoInfo) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
