package com.br.depen.api_depen.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.br.depen.api_depen.entities.Protocol;
import com.br.depen.api_depen.repository.ProtocoloRepository;

@Service
public class ProtocoloServiceImpl implements ProtocoloService{
	@Autowired
    private ProtocoloRepository protocoloRepository;

    @Override
    public Protocol save(Protocol protocol) {
        return protocoloRepository.save(protocol);
    }


    @Override
    public List<Protocol> findAll() {
        return protocoloRepository.findAll();
    }

    @Override
    public Optional<Protocol> findById(Long id) {
        return protocoloRepository.findById(id);
    }


    @Override
    public Protocol update(Protocol protocol) {
        return protocoloRepository.save(protocol);
    }

    @Override
    public void deleteById(Long id) {
    	protocoloRepository.deleteById(id);
    }
}
