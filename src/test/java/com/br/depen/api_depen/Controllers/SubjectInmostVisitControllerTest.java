package com.br.depen.api_depen.Controllers;

import com.br.depen.api_depen.controller.SubInMostVisitController;
import com.br.depen.api_depen.entities.SubjectInmostVisit;
import com.br.depen.api_depen.repository.SubInMostVisitRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class SubjectInmostVisitControllerTest {
    @Autowired
    SubInMostVisitController subInMostVisitController;

    @MockBean
    SubInMostVisitRepository subInMostVisitRepository;

    SubjectInmostVisit subjectInmostVisit = new SubjectInmostVisit();

    @BeforeEach
    void setup(){

    }

    @Test
    void saveSubjectInmostVisit(){
        ResponseEntity<SubjectInmostVisit> retorno = subInMostVisitController.create(subjectInmostVisit);

        assertEquals(HttpStatus.CREATED, retorno.getStatusCode());
    }

    @Test
    void saveSubInMostVisitError() {
        SubjectInmostVisit subjectInmostVisitFailed = new SubjectInmostVisit();


        assertThrows(Exception.class, ()-> {
            ResponseEntity<SubjectInmostVisit> message = subInMostVisitController.create(subjectInmostVisitFailed);
        });
    }

}
