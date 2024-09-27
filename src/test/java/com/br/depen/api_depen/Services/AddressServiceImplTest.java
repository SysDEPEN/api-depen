package com.br.depen.api_depen.Services;

import com.br.depen.api_depen.entities.Address;
import com.br.depen.api_depen.repository.AddressRepository;
import com.br.depen.api_depen.services.AdressServiceImpl;
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

public class AddressServiceImplTest {

    @InjectMocks
    private AdressServiceImpl addressService;

    @Mock
    private AddressRepository addressRepository;

    private Address address;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        address = new Address();
        address.setId(1L);
        address.setStreet("Main Street");
        address.setCity("Cityville");
    }

    @Test
    void saveAddress_ShouldReturnSavedAddress() {
        when(addressRepository.save(address)).thenReturn(address);

        Address savedAddress = addressService.save(address);

        assertNotNull(savedAddress);
        assertEquals("Main Street", savedAddress.getStreet());
        verify(addressRepository, times(1)).save(address);
    }

    @Test
    void findAll_ShouldReturnListOfAddresses() {
        List<Address> addresses = Arrays.asList(address);
        when(addressRepository.findAll()).thenReturn(addresses);

        List<Address> result = addressService.findAll();

        assertNotNull(result);
        assertEquals(1, result.size());
        verify(addressRepository, times(1)).findAll();
    }

    @Test
    void findById_ShouldReturnAddress_WhenIdExists() {
        when(addressRepository.findById(1L)).thenReturn(Optional.of(address));

        Optional<Address> foundAddress = addressService.findById(1L);

        assertTrue(foundAddress.isPresent());
        assertEquals("Main Street", foundAddress.get().getStreet());
        verify(addressRepository, times(1)).findById(1L);
    }

    @Test
    void findById_ShouldReturnEmpty_WhenIdDoesNotExist() {
        when(addressRepository.findById(1L)).thenReturn(Optional.empty());

        Optional<Address> foundAddress = addressService.findById(1L);

        assertFalse(foundAddress.isPresent());
        verify(addressRepository, times(1)).findById(1L);
    }

    @Test
    void updateAddress_ShouldReturnUpdatedAddress() {
        when(addressRepository.save(address)).thenReturn(address);

        Address updatedAddress = addressService.update(address);

        assertNotNull(updatedAddress);
        assertEquals("Main Street", updatedAddress.getStreet());
        verify(addressRepository, times(1)).save(address);
    }

    @Test
    void deleteById_ShouldCallDeleteOnRepository() {
        doNothing().when(addressRepository).deleteById(1L);

        addressService.deleteById(1L);

        verify(addressRepository, times(1)).deleteById(1L);
    }
}
