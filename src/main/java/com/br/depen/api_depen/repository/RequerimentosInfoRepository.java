package com.br.depen.api_depen.repository;

import com.br.depen.api_depen.entities.RequerimentosInfo;
import com.br.depen.api_depen.services.RequerimentoInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequerimentosInfoRepository extends JpaRepository<RequerimentosInfo, Long> {
}
