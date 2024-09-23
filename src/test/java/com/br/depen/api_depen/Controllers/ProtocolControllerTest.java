package com.br.depen.api_depen.Controllers;

import com.br.depen.api_depen.controller.ProtocolController;
import com.br.depen.api_depen.repository.ProtocoloRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class ProtocolControllerTest {
    @Autowired
    ProtocolController protocolController;

    @MockBean
    ProtocoloRepository protocoloRepository;
}
