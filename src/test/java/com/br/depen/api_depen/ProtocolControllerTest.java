package com.br.depen.api_depen;

import com.br.depen.api_depen.controller.ProtocolController;
import com.br.depen.api_depen.entities.Protocols;
import com.br.depen.api_depen.services.ProtocoloService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ProtocolController.class)
public class ProtocolControllerTest {

    @MockBean
    private ProtocoloService protocoloService;

    @InjectMocks
    private ProtocolController protocolController;

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(protocolController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void testFindAllProtocols_Success() throws Exception {
        Protocols protocol = new Protocols();
        protocol.setId(1L);
        protocol.setCreated_at(LocalDateTime.now());
        protocol.setUpdated_at(LocalDateTime.now());
        protocol.setStatus(1L);

        when(protocoloService.findAll()).thenReturn(Collections.singletonList(protocol));

        mockMvc.perform(get("/api/v1/protocols")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L));
    }

    @Test
    void testFindProtocolById_Success() throws Exception {
        Protocols protocol = new Protocols();
        protocol.setId(1L);
        protocol.setCreated_at(LocalDateTime.now());
        protocol.setUpdated_at(LocalDateTime.now());
        protocol.setStatus(1L);

        when(protocoloService.findById(1L)).thenReturn(Optional.of(protocol));

        mockMvc.perform(get("/api/v1/protocols/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L));
    }

    @Test
    void testCreateProtocol_Success() throws Exception {
        Protocols protocol = new Protocols();
        protocol.setCreated_at(LocalDateTime.now());
        protocol.setUpdated_at(LocalDateTime.now());
        protocol.setStatus(1L);

        when(protocoloService.save(any(Protocols.class))).thenReturn(protocol);

        mockMvc.perform(post("/api/v1/protocols")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(protocol)))
                .andExpect(status().isCreated());
    }

    @Test
    void testUpdateProtocol_Success() throws Exception {
        Protocols protocol = new Protocols();
        protocol.setId(1L);
        protocol.setCreated_at(LocalDateTime.now());
        protocol.setUpdated_at(LocalDateTime.now());
        protocol.setStatus(1L);

        when(protocoloService.update(any(Protocols.class))).thenReturn(protocol);

        mockMvc.perform(put("/api/v1/protocols/update/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(protocol)))
                .andExpect(status().isOk());
    }

    @Test
    void testDeleteProtocol_Success() throws Exception {
        when(protocoloService.deleteById(1L)).thenReturn(true);
        mockMvc.perform(delete("/api/v1/protocols/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testCreateProtocol_ThrowsGenericException() throws Exception {
        Protocols protocol = new Protocols();
        protocol.setCreated_at(LocalDateTime.now());
        protocol.setUpdated_at(LocalDateTime.now());
        protocol.setStatus(1L);

        when(protocoloService.save(any(Protocols.class))).thenThrow(new RuntimeException("Generic error"));

        mockMvc.perform(post("/api/v1/protocols")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(protocol)))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Generic error"));
    }
}
