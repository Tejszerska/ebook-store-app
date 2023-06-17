package pl.ebookstore.app.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.ebookstore.app.ShoppingCart;
import pl.ebookstore.app.entities.Customer;
import pl.ebookstore.app.entities.Purchase;
import pl.ebookstore.app.model.Address;
import pl.ebookstore.app.model.dtos.CustomerPurchaseDto;
import pl.ebookstore.app.model.dtos.PurchaseDto;
import pl.ebookstore.app.model.enums.DeliveryType;
import pl.ebookstore.app.model.enums.Role;
import pl.ebookstore.app.repository.CustomerRepository;
import pl.ebookstore.app.repository.PurchaseRepository;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PurchaseService {
    private final CustomerRepository customerRepository;
    private final PurchaseRepository purchaseRepository;
    private final ShoppingCart shoppingCart;

    public void addPurchase(PurchaseDto purchaseDto) {
        // zakup z logowaniem
        Purchase purchase = new Purchase();
        purchase.setCustomer(purchaseDto.getCustomer());

//        purchase.setTotalCost(purchase.getTotalCost());
        purchase.setDeliveryType(DeliveryType.valueOf(purchaseDto.getDeliveryType()));

        purchase.setOrderDate(LocalDate.now());
    }

    public void addPurchase(CustomerPurchaseDto customerPurchaseDto) {
    //  zakup bez logowania
        Customer customer = new Customer();
        customer.setEmail(customerPurchaseDto.getEmail());
        customer.setRole(Role.UNLOGGED);

        customer.setAddress(new Address(customerPurchaseDto.getName(), customerPurchaseDto.getSurname(),
                customerPurchaseDto.getCountry(), customerPurchaseDto.getCity(),
                customerPurchaseDto.getStreet(), customerPurchaseDto.getZipCode())
        );
        customerRepository.save(customer);

    Purchase purchase = new Purchase();
    purchase.setCustomer(customer);
    purchase.setTotalCost(shoppingCart.getTotalCost());
    purchase.setOrderDate(LocalDate.now());
    purchase.setDeliveryType(DeliveryType.valueOf(customerPurchaseDto.getDeliveryType()));
    purchaseRepository.save(purchase);
    }

}
