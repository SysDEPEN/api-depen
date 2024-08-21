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
            req.setName_visited(reqUpdated.getName_visited() != null ? reqUpdated.getName_visited() : req.getName_visited());
            req.setCpf_rne(reqUpdated.getCpf_rne() != null ? reqUpdated.getCpf_rne() : req.getCpf_rne());
            req.setSubject(reqUpdated.getSubject() != null ? reqUpdated.getSubject() : req.getSubject());
            req.setType_visitation(reqUpdated.getType_visitation() != null ? reqUpdated.getType_visitation() : req.getType_visitation());
            req.setState(reqUpdated.getState() != null ? reqUpdated.getState() : req.getState());
            req.setCity(reqUpdated.getCity() != null ? reqUpdated.getCity() : req.getCity());
            req.setDistrict(reqUpdated.getDistrict() != null ? reqUpdated.getDistrict() : req.getDistrict());
            req.setStreet(reqUpdated.getStreet() != null ? reqUpdated.getStreet() : req.getStreet());
            req.setNumber_house(reqUpdated.getNumber_house() != null ? reqUpdated.getNumber_house() : req.getNumber_house());
            return requerimentosInfoRepository.save(req);
        } else {
            throw new RuntimeException("Req not found with id " + id);
        }
    }

    @Override
    public void deleteById(Long id) {
        requerimentosInfoRepository.deleteById(id);
    }
}
