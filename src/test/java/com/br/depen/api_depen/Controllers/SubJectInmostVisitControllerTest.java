package com.br.depen.api_depen.Controllers;

import com.br.depen.api_depen.controller.AddressController;
import com.br.depen.api_depen.controller.SubInMostVisitController;
import com.br.depen.api_depen.controller.UserController;
import com.br.depen.api_depen.entities.Address;
import com.br.depen.api_depen.entities.SubjectInmostVisit;
import com.br.depen.api_depen.repository.AddressRepository;
import com.br.depen.api_depen.repository.SubInMostVisitRepository;
import com.br.depen.api_depen.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class SubJectInmostVisitControllerTest {

    @Autowired
    SubInMostVisitController subInMostVisitController;

    @MockBean
    SubInMostVisitRepository subInMostVisitRepository;

    SubjectInmostVisit subject = new SubjectInmostVisit();

    @BeforeEach
    void setup(){
        subject.setId(1L);
        subject.setAccomplice("sim");
        subject.setVictim(false);
        subject.setPregnancy(true);
        subject.setTime_pregnancy("4");
    }

    @Test
    void saveSubject() {
        ResponseEntity<SubjectInmostVisit> retorno = subInMostVisitController.create(subject);

        assertEquals(HttpStatus.CREATED, retorno.getStatusCode());
    }

    @Test
    @DisplayName("SUBJECT ESTÁ COM ACCOMPLICE INVÁLIDO")
    void saveAccompliceErr() {
        SubjectInmostVisit subjectFail = new SubjectInmostVisit();
        Short pregnancy = 4;
        subjectFail.setId(1L);
        subjectFail.setAccomplice("aah");
        subjectFail.setVictim(false);
        subjectFail.setPregnancy(true);
        subjectFail.setTime_pregnancy("2");


        assertThrows(Exception.class, ()-> {
            ResponseEntity<SubjectInmostVisit> message = subInMostVisitController.create(subjectFail);
        });
    }

    @Test
    @DisplayName("SUBJECT ESTÁ COM PREGNANCY INVÁLIDO")
    void savePregnancyErr() {
        SubjectInmostVisit subjectFail = new SubjectInmostVisit();
        Short pregnancy = 4;
        subjectFail.setId(1L);
        subjectFail.setAccomplice("sim");
        subjectFail.setVictim(false);
        subjectFail.setPregnancy(true);
        subjectFail.setTime_pregnancy("asdasd");


        assertThrows(Exception.class, ()-> {
            ResponseEntity<SubjectInmostVisit> message = subInMostVisitController.create(subjectFail);
        });
    }


    @Test
    @DisplayName("NADA ENCONTRADO NO SUBJECT: BAD REQUEST")
    void notFoundAddress() {
        SubjectInmostVisit subf = null;

        ResponseEntity<SubjectInmostVisit> retorno = subInMostVisitController.create(subf);
        assertEquals(HttpStatus.BAD_REQUEST, retorno.getStatusCode());
    }
}