package pl.ebookstore.app.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.ebookstore.app.entities.Customer;
import pl.ebookstore.app.model.Address;
import java.math.BigDecimal;
import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseDto {
    private Customer customer;
    private BigDecimal totalCost;
    private LocalDate orderDate;
    private Address address; // używamy gdy kupno bez logowania/rejestracji
    private String deliveryType;
    private String role;

    public PurchaseDto(Customer customer, BigDecimal totalCost, LocalDate orderDate, String deliveryType) {
        this.customer = customer;
        this.totalCost = totalCost;
        this.orderDate = LocalDate.now();
        this.deliveryType = deliveryType;
    }

    public PurchaseDto(BigDecimal totalCost, LocalDate orderDate, Address address, String deliveryType) {
        this.totalCost = totalCost;
        this.orderDate = LocalDate.now();
        this.address = address;
        this.deliveryType = deliveryType;
    }
}
