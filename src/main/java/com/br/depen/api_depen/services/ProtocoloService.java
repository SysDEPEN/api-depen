package com.br.depen.api_depen.services;

import java.util.List;
import java.util.Optional;
import com.br.depen.api_depen.entities.Protocol;

public interface ProtocoloService {

    Protocol save(Protocol protocol);

    List<Protocol> findAll();

    Optional<Protocol> findById(Long id);

    Protocol update (Protocol protocol);

    void deleteById(Long id);
}