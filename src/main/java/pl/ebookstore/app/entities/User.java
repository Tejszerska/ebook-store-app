package pl.ebookstore.app.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.ebookstore.app.model.Address;
import pl.ebookstore.app.model.NewsMessagePreference;
import pl.ebookstore.app.model.Role;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String password; //@TODO zapytać R.
    @Embedded
    private Address address;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Enumerated(EnumType.STRING)
    private NewsMessagePreference newsMessagePreference;
    @OneToMany (mappedBy = "user")
    private List <Order> pastOrders;



}
