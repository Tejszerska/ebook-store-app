package pl.ebookstore.app.service;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.ebookstore.app.entities.Customer;
import pl.ebookstore.app.model.Address;
import pl.ebookstore.app.model.dtos.CustomerDto;
import pl.ebookstore.app.model.dtos.CustomerPurchaseDto;
import pl.ebookstore.app.model.enums.Role;
import pl.ebookstore.app.repository.CustomerRepository;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
@Slf4j

public class CustomerService {
    private final CustomerRepository customerRepository;
    public void addCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setEmail(customerDto.getEmail());

            customer.setPassword(customerDto.getPassword());
            customer.setRole(Role.USER);

        customer.setAddress(new Address(customerDto.getName(), customerDto.getSurname(),
                        customerDto.getCountry(), customerDto.getCity(),
                        customerDto.getStreet(), customerDto.getZipCode())
                );
        customer.setPastPurchases(new ArrayList<>());
        customerRepository.save(customer);
    }


}
