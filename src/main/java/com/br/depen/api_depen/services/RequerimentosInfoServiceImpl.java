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
    public RequerimentoInfo update(Long id, RequerimentoInfo reqUpdated) {
        Optional<RequerimentoInfo> currentReq = requerimentosInfoRepository.findById(id);

        if (currentReq.isPresent()) {
            RequerimentoInfo req = currentReq.get();
            req.setNome_visitado(reqUpdated.getNome_visitado() != null ? reqUpdated.getNome_visitado() : req.getNome_visitado());
            req.setCpf_rne(reqUpdated.getCpf_rne() != null ? reqUpdated.getCpf_rne() : req.getCpf_rne());
            req.setRequerimento_assunto(reqUpdated.getRequerimento_assunto() != null ? reqUpdated.getRequerimento_assunto() : req.getRequerimento_assunto());
            req.setTipo_visitacao(reqUpdated.getTipo_visitacao() != null ? reqUpdated.getTipo_visitacao() : req.getTipo_visitacao());
            req.setEstado(reqUpdated.getEstado() != null ? reqUpdated.getEstado() : req.getEstado());
            req.setCidade(reqUpdated.getCidade() != null ? reqUpdated.getCidade() : req.getCidade());
            req.setBairro(reqUpdated.getBairro() != null ? reqUpdated.getBairro() : req.getBairro());
            req.setRua(reqUpdated.getRua() != null ? reqUpdated.getRua() : req.getRua());
            req.setNumero_casa(reqUpdated.getNumero_casa() != null ? reqUpdated.getNumero_casa() : req.getNumero_casa());
            req.setId_user(reqUpdated.getId_user() != null ? reqUpdated.getId_user() : req.getId_user());
            return requerimentosInfoRepository.save(req);
        } else {
            throw new RuntimeException("sla not found with id " + id);
        }
    }

    @Override
    public void deleteById(Long id) {
        requerimentosInfoRepository.deleteById(id);
    }
}
