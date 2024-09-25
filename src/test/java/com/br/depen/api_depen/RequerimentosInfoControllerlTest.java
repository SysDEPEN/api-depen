package com.br.depen.api_depen;

import com.br.depen.api_depen.controller.RequerimentoInfoController;
import com.br.depen.api_depen.entities.RequerimentoInfo;
import com.br.depen.api_depen.services.RequerimentoInfoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest(RequerimentoInfoController.class)
class RequerimentoInfoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RequerimentoInfoService requerimentoInfoService;

    private RequerimentoInfo requerimentoInfo;

    @BeforeEach
    void setUp() {
        requerimentoInfo = new RequerimentoInfo();
        requerimentoInfo.setId(1L);
        requerimentoInfo.setNameVisited("João da Silva");
        requerimentoInfo.setCpfRne("12345678900");
        requerimentoInfo.setTypeVisitation("Familiar");
        requerimentoInfo.setCellphone("11987654321");
        requerimentoInfo.setState("SP");
        requerimentoInfo.setCity("São Paulo");
        requerimentoInfo.setDistrict("Centro");
        requerimentoInfo.setStreet("Rua Principal");
        requerimentoInfo.setNumberHouse("123");
    }


    @Test
    void testFindAll() throws Exception {
        Mockito.when(requerimentoInfoService.findAll()).thenReturn(Arrays.asList(requerimentoInfo));

        mockMvc.perform(get("/api/v1/req_camp")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name_visited").value("João da Silva"));
    }

    @Test
    void testFindById() throws Exception {
        Mockito.when(requerimentoInfoService.findById(anyLong())).thenReturn(Optional.of(requerimentoInfo));

        mockMvc.perform(get("/api/v1/req_camp/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name_visited").value("João da Silva"));
    }

    @Test
    void testCreate() throws Exception {
        Mockito.when(requerimentoInfoService.save(any(RequerimentoInfo.class))).thenReturn(requerimentoInfo);

        String json = "{ \"name_visited\": \"João da Silva\", \"cpf_rne\": \"12345678900\", \"type_visitation\": \"Familiar\", \"cellphone\": \"11987654321\", \"state\": \"SP\", \"city\": \"São Paulo\", \"district\": \"Centro\", \"street\": \"Rua Principal\", \"number_house\": \"123\" }";

        mockMvc.perform(post("/api/v1/req_camp")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name_visited").value("João da Silva"));
    }

    @Test
    void testUpdate() throws Exception {
        Mockito.when(requerimentoInfoService.update(anyLong(), any(RequerimentoInfo.class))).thenReturn(requerimentoInfo);

        String json = "{ \"name_visited\": \"João da Silva Atualizado\", \"cpf_rne\": \"12345678900\", \"type_visitation\": \"Familiar\", \"cellphone\": \"11987654321\", \"state\": \"SP\", \"city\": \"São Paulo\", \"district\": \"Centro\", \"street\": \"Rua Principal\", \"number_house\": \"123\" }";

        mockMvc.perform(put("/api/v1/req_camp/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name_visited").value("João da Silva Atualizado"));
    }

    @Test
    void testDelete() throws Exception {
        Mockito.doNothing().when(requerimentoInfoService).deleteById(anyLong());

        mockMvc.perform(delete("/api/v1/req_camp/1"))
                .andExpect(status().isOk());
    }

    @Test
    void testGenericErrorException() throws Exception {
        Mockito.when(requerimentoInfoService.findAll()).thenThrow(new RuntimeException("Erro genérico"));

        mockMvc.perform(get("/api/v1/req_camp")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}
