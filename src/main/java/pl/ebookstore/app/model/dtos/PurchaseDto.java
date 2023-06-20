package pl.ebookstore.app.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.ebookstore.app.entities.Customer;
import pl.ebookstore.app.model.Address;
import pl.ebookstore.app.model.enums.DeliveryType;

import java.math.BigDecimal;
import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseDto {
    private Long id;
    private Customer customer;
    private BigDecimal totalCost;
    private LocalDate orderDate;
    private String deliveryType;
    private String role;

    public PurchaseDto(Long id, Customer customer, BigDecimal totalCost, LocalDate orderDate, String deliveryType) {
        this.id = id;
        this.customer = customer;
        this.totalCost = totalCost;
        this.orderDate = orderDate;
        this.deliveryType = deliveryType;
    }
}
