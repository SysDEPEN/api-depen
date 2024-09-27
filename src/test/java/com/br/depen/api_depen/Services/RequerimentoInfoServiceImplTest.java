package com.br.depen.api_depen.Services;

import com.br.depen.api_depen.entities.RequerimentoInfo;
import com.br.depen.api_depen.repository.RequerimentosInfoRepository;
import com.br.depen.api_depen.services.RequerimentosInfoServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class RequerimentoInfoServiceImplTest {
    @Mock
    private RequerimentosInfoRepository requerimentosInfoRepository;

    @InjectMocks
    private RequerimentosInfoServiceImpl requerimentosInfoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSave() {
        RequerimentoInfo requerimentoInfo = new RequerimentoInfo();
        when(requerimentosInfoRepository.save(requerimentoInfo)).thenReturn(requerimentoInfo);

        RequerimentoInfo savedReq = requerimentosInfoService.save(requerimentoInfo);

        assertNotNull(savedReq);
        verify(requerimentosInfoRepository, times(1)).save(requerimentoInfo);
    }

    @Test
    void testSave_ThrowsException() {
        RequerimentoInfo requerimentoInfo = new RequerimentoInfo();
        when(requerimentosInfoRepository.save(requerimentoInfo)).thenThrow(new RuntimeException("Generic save error"));

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            requerimentosInfoService.save(requerimentoInfo);
        });

        assertEquals("Generic save error", exception.getMessage());
        verify(requerimentosInfoRepository, times(1)).save(requerimentoInfo);
    }

    @Test
    void testFindAll() {
        List<RequerimentoInfo> reqList = Arrays.asList(new RequerimentoInfo(), new RequerimentoInfo());
        when(requerimentosInfoRepository.findAll()).thenReturn(reqList);

        List<RequerimentoInfo> result = requerimentosInfoService.findAll();

        assertEquals(2, result.size());
        verify(requerimentosInfoRepository, times(1)).findAll();
    }

    @Test
    void testFindById_Found() {
        Long id = 1L;
        RequerimentoInfo requerimentoInfo = new RequerimentoInfo();
        when(requerimentosInfoRepository.findById(id)).thenReturn(Optional.of(requerimentoInfo));

        Optional<RequerimentoInfo> foundReq = requerimentosInfoService.findById(id);

        assertTrue(foundReq.isPresent());
        assertEquals(requerimentoInfo, foundReq.get());
        verify(requerimentosInfoRepository, times(1)).findById(id);
    }

    @Test
    void testFindById_NotFound() {
        Long id = 1L;
        when(requerimentosInfoRepository.findById(id)).thenReturn(Optional.empty());

        Optional<RequerimentoInfo> foundReq = requerimentosInfoService.findById(id);

        assertFalse(foundReq.isPresent());
        verify(requerimentosInfoRepository, times(1)).findById(id);
    }

    @Test
    void testUpdate_Success() {
        Long id = 1L;
        RequerimentoInfo existingReq = new RequerimentoInfo();
        RequerimentoInfo updatedReq = new RequerimentoInfo();
        updatedReq.setName_visited("New Name");

        when(requerimentosInfoRepository.findById(id)).thenReturn(Optional.of(existingReq));
        when(requerimentosInfoRepository.save(any(RequerimentoInfo.class))).thenReturn(existingReq);

        RequerimentoInfo result = requerimentosInfoService.update(id, updatedReq);

        assertNotNull(result);
        assertEquals("New Name", result.getName_visited());
        verify(requerimentosInfoRepository, times(1)).findById(id);
        verify(requerimentosInfoRepository, times(1)).save(existingReq);
    }

    @Test
    void testUpdate_ThrowsException() {
        Long id = 1L;
        RequerimentoInfo updatedReq = new RequerimentoInfo();
        when(requerimentosInfoRepository.findById(id)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            requerimentosInfoService.update(id, updatedReq);
        });

        assertEquals("Req not found with id " + id, exception.getMessage());
        verify(requerimentosInfoRepository, times(1)).findById(id);
        verify(requerimentosInfoRepository, never()).save(any());
    }

    @Test
    void testDeleteById() {
        Long id = 1L;

        requerimentosInfoService.deleteById(id);

        verify(requerimentosInfoRepository, times(1)).deleteById(id);
    }

    @Test
    void testDeleteById_ThrowsException() {
        Long id = 1L;
        doThrow(new RuntimeException("Generic delete error")).when(requerimentosInfoRepository).deleteById(id);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            requerimentosInfoService.deleteById(id);
        });

        assertEquals("Generic delete error", exception.getMessage());
        verify(requerimentosInfoRepository, times(1)).deleteById(id);
    }
}
