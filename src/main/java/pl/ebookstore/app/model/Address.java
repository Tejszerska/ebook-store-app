package pl.ebookstore.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String name;
    private String surname;
    private String country;
    private String city;
    private String street;
    private String zipCode;


    @Override
    public String toString() {
        return  "First name: " + name +
                " , surname: " + surname +
                " , country: " + country +
                " , city: " + city +
                " , street: " + street +
                " , zipCode: " + zipCode ;
    }
}
