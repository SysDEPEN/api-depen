package com.br.depen.api_depen.Services;

import com.br.depen.api_depen.entities.Documents;
import com.br.depen.api_depen.repository.DocumentRepository;
import com.br.depen.api_depen.services.DocumentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class DocumentServiceImplTest {

    @Mock
    private DocumentRepository documentRepository;

    @InjectMocks
    private DocumentServiceImpl documentService;

    private Documents document;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        document = new Documents();
        document.setId(1L);
        document.setName("Test Document");
    }

    @Test
    void testSaveDocument_Success() {
        when(documentRepository.save(any(Documents.class))).thenReturn(document);

        Documents savedDocument = documentService.save(document);

        assertNotNull(savedDocument);
        assertEquals(1L, savedDocument.getId());
        verify(documentRepository, times(1)).save(any(Documents.class));
    }

    @Test
    void testSaveDocument_Failure() {
        when(documentRepository.save(any(Documents.class))).thenThrow(new RuntimeException("document not saved"));

        Exception exception = assertThrows(RuntimeException.class, () -> {
            documentService.save(document);
        });

        assertEquals("document not saved", exception.getMessage());
        verify(documentRepository, times(1)).save(any(Documents.class));
    }

    @Test
    void testFindAllDocuments() {
        when(documentRepository.findAll()).thenReturn(List.of(document));

        List<Documents> documentsList = documentService.findAll();

        assertNotNull(documentsList);
        assertEquals(1, documentsList.size());
        verify(documentRepository, times(1)).findAll();
    }


    @Test
    void testFindDocumentById_NotFound() {
        when(documentRepository.findById(1L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            documentService.findById(1L);
        });

        assertEquals("document not found with id 1", exception.getMessage());
        verify(documentRepository, times(1)).findById(1L);
    }

    @Test
    void testUpdateDocument_NotImplemented() {
        assertNull(documentService.update(document));
    }

    @Test
    void testDeleteDocumentById_NotImplemented() {
        documentService.deleteById(1L);
        verify(documentRepository, times(0)).deleteById(anyLong());
    }
}