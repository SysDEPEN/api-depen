package com.br.depen.api_depen.services;

import java.util.List;
import java.util.Optional;
import com.br.depen.api_depen.entities.Protocols;

public interface ProtocoloService {

    Protocols save(Protocols protocol);

    List<Protocols> findAll();

    Optional<Protocols> findById(Long id);

    Protocols update (Protocols protocols);

    void deleteById(Long id);
}