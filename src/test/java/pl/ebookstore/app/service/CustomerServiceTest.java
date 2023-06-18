package pl.ebookstore.app.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.ebookstore.app.entities.Customer;
import pl.ebookstore.app.entities.Purchase;
import pl.ebookstore.app.model.dtos.CustomerDto;
import pl.ebookstore.app.model.enums.Role;
import pl.ebookstore.app.repository.CustomerRepository;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {
    @Mock
    private CustomerRepository customerRepository;
    private static final CustomerDto CUSTOMER_DTO = new CustomerDto
            (1L, "test@gmail.com", "password", "John", "Smith",
                    "UK", "London", "Baker Street 2117", "00000", List.of(new Purchase()), Role.USER.toString());

    @Test
    void shouldAddCustomerToRepositoryTest() {
        //given
        Customer customer = new Customer();
        customer.setId(CUSTOMER_DTO.getId());
        customer.setEmail(CUSTOMER_DTO.getEmail());
        //... itp itd

        //when
        when(customerRepository.save(customer)).thenReturn(customer);

        //then
        Assertions.assertEquals("test@gmail.com", customer.getEmail());
        Assertions.assertEquals(customerRepository.save(customer), customer);
    }

}