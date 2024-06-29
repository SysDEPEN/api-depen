package com.br.depen.api_depen.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.depen.api_depen.entities.RequerimentoInfo;
import com.br.depen.api_depen.repository.RequerimentosInfoRepository;

@Service
public class RequerimentosInfoServiceImpl implements RequerimentoInfoService{

    @Autowired
    private RequerimentosInfoRepository requerimentosInfoRepository;

    @Override
    public RequerimentoInfo save(RequerimentoInfo requerimentoInfo) {
        return requerimentosInfoRepository.save(requerimentoInfo);
    }

    @Override
    public List<RequerimentoInfo> findAll() {
        return requerimentosInfoRepository.findAll();
    }

    @Override
    public Optional<RequerimentoInfo> findById(Long id) {
        return requerimentosInfoRepository.findById(id);
    }

    @Override
    public RequerimentoInfo update(RequerimentoInfo requerimentoInfo) {
        return requerimentosInfoRepository.save(requerimentoInfo);
    }

    @Override
    public void deleteById(Long id) {
        requerimentosInfoRepository.deleteById(id);
    }
}
