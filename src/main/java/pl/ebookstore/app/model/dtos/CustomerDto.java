package pl.ebookstore.app.model.dtos;
import lombok.*;
import pl.ebookstore.app.entities.Purchase;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    private Long id;
    private String email;
    private String password;
    private String name;
    private String surname;
    private String country;
    private String city;
    private String street;
    private String zipCode;
    private List<Purchase> pastPurchases;
    private String role;
}
