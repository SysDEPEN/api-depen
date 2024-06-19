package com.br.depen.api_depen.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.br.depen.api_depen.entities.Protocols;
import com.br.depen.api_depen.repository.ProtocoloRepository;

@Service
public class ProtocoloServiceImpl implements ProtocoloService{
	@Autowired
    private ProtocoloRepository protocoloRepository;

    @Override
    public Protocols save(Protocols protocols) {
        return protocoloRepository.save(protocols);
    }


    @Override
    public List<Protocols>findAll() {
        return protocoloRepository.findAll();
    }

    @Override
    public Optional<Protocols> findById(Long id) {
        return protocoloRepository.findById(id);
    }


    @Override
    public Protocols update(Protocols protocols) {
        return protocoloRepository.save(protocols);
    }

    @Override
    public void deleteById(Long id) {
    	protocoloRepository.deleteById(id);
    }
}
