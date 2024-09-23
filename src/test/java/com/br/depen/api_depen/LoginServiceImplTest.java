package com.br.depen.api_depen;

import com.br.depen.api_depen.entities.Login;
import com.br.depen.api_depen.repository.LoginRepository;
import com.br.depen.api_depen.services.LoginServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LoginServiceImplTest {

    @Mock
    private LoginRepository loginRepository;

    @InjectMocks
    private LoginServiceImpl loginServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSave() {
        Login login = new Login();
        when(loginRepository.save(login)).thenReturn(login);

        Login savedLogin = loginServiceImpl.save(login);

        assertNotNull(savedLogin);
        verify(loginRepository, times(1)).save(login);
    }

    @Test
    void testFindAll() {
        List<Login> loginList = Arrays.asList(new Login(), new Login());
        when(loginRepository.findAll()).thenReturn(loginList);

        List<Login> result = loginServiceImpl.findAll();

        assertEquals(2, result.size());
        verify(loginRepository, times(1)).findAll();
    }

    @Test
    void testFindById_Found() {
        Long id = 1L;
        Login login = new Login();
        when(loginRepository.findById(id)).thenReturn(Optional.of(login));

        Optional<Login> foundLogin = loginServiceImpl.findById(id);

        assertTrue(foundLogin.isPresent());
        assertEquals(login, foundLogin.get());
        verify(loginRepository, times(1)).findById(id);
    }

    @Test
    void testFindById_NotFound() {
        Long id = 1L;
        when(loginRepository.findById(id)).thenReturn(Optional.empty());

        Optional<Login> foundLogin = loginServiceImpl.findById(id);

        assertFalse(foundLogin.isPresent());
        verify(loginRepository, times(1)).findById(id);
    }

    @Test
    void testUpdate() {
        Login login = new Login();
        when(loginRepository.save(login)).thenReturn(login);

        Login updatedLogin = loginServiceImpl.update(login);

        assertNotNull(updatedLogin);
        verify(loginRepository, times(1)).save(login);
    }

    @Test
    void testDeleteById() {
        Long id = 1L;

        loginServiceImpl.deleteById(id);

        verify(loginRepository, times(1)).deleteById(id);
    }

    @Test
    void testLoadUserByUsername_Found() {
        String username = "user1";
        Login login = new Login();
        login.setNome(username);
        when(loginRepository.findByNome(username)).thenReturn(login);

        assertDoesNotThrow(() -> {
            loginServiceImpl.loadUserByUsername(username);
        });

        verify(loginRepository, times(1)).findByNome(username);
    }

    @Test
    void testLoadUserByUsername_NotFound() {
        String username = "nonexistentuser";
        when(loginRepository.findByNome(username)).thenReturn(null);

        assertThrows(UsernameNotFoundException.class, () -> {
            loginServiceImpl.loadUserByUsername(username);
        });

        verify(loginRepository, times(1)).findByNome(username);
    }
}
