package com.br.depen.api_depen;

import com.br.depen.api_depen.entities.Protocols;
import com.br.depen.api_depen.repository.ProtocoloRepository;
import com.br.depen.api_depen.services.ProtocoloServiceImpl;

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

class ProtocoloServiceImplTest {

    @Mock
    private ProtocoloRepository protocoloRepository;

    @InjectMocks
    private ProtocoloServiceImpl protocoloServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSave() {
        Protocols protocols = new Protocols();
        when(protocoloRepository.save(protocols)).thenReturn(protocols);

        Protocols savedProtocols = protocoloServiceImpl.save(protocols);

        assertNotNull(savedProtocols);
        verify(protocoloRepository, times(1)).save(protocols);
    }

    @Test
    void testSave_ThrowsException() {
        Protocols protocols = new Protocols();
        when(protocoloRepository.save(protocols)).thenThrow(new RuntimeException("Generic save error"));

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            protocoloServiceImpl.save(protocols);
        });

        assertEquals("Generic save error", exception.getMessage());
        verify(protocoloRepository, times(1)).save(protocols);
    }

    @Test
    void testFindAll() {
        List<Protocols> protocolsList = Arrays.asList(new Protocols(), new Protocols());
        when(protocoloRepository.findAll()).thenReturn(protocolsList);

        List<Protocols> result = protocoloServiceImpl.findAll();

        assertEquals(2, result.size());
        verify(protocoloRepository, times(1)).findAll();
    }

    @Test
    void testFindById_Found() {
        Long id = 1L;
        Protocols protocols = new Protocols();
        when(protocoloRepository.findById(id)).thenReturn(Optional.of(protocols));

        Optional<Protocols> foundProtocols = protocoloServiceImpl.findById(id);

        assertTrue(foundProtocols.isPresent());
        assertEquals(protocols, foundProtocols.get());
        verify(protocoloRepository, times(1)).findById(id);
    }

    @Test
    void testFindById_NotFound() {
        Long id = 1L;
        when(protocoloRepository.findById(id)).thenReturn(Optional.empty());

        Optional<Protocols> foundProtocols = protocoloServiceImpl.findById(id);

        assertFalse(foundProtocols.isPresent());
        verify(protocoloRepository, times(1)).findById(id);
    }

    @Test
    void testUpdate() {
        Protocols protocols = new Protocols();
        when(protocoloRepository.save(protocols)).thenReturn(protocols);

        Protocols updatedProtocols = protocoloServiceImpl.update(protocols);

        assertNotNull(updatedProtocols);
        verify(protocoloRepository, times(1)).save(protocols);
    }

    @Test
    void testDeleteById() {
        Long id = 1L;

        protocoloServiceImpl.deleteById(id);

        verify(protocoloRepository, times(1)).deleteById(id);
    }

    @Test
    void testDeleteById_ThrowsException() {
        Long id = 1L;
        doThrow(new RuntimeException("Generic delete error")).when(protocoloRepository).deleteById(id);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            protocoloServiceImpl.deleteById(id);
        });

        assertEquals("Generic delete error", exception.getMessage());
        verify(protocoloRepository, times(1)).deleteById(id);
    }
}
