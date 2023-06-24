package pl.ebookstore.app;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.ebookstore.app.entities.Customer;
import pl.ebookstore.app.entities.Ebook;
import pl.ebookstore.app.entities.Purchase;
import pl.ebookstore.app.model.*;
import pl.ebookstore.app.model.enums.*;
import pl.ebookstore.app.repository.CustomerRepository;
import pl.ebookstore.app.repository.EbookRepository;
import pl.ebookstore.app.repository.PurchaseRepository;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class EbookStoreAppApplication {
private final EbookRepository ebookRepository;

private final CustomerRepository customerRepository;
private final PurchaseRepository purchaseRepository;
    public static void main(String[] args) {
        SpringApplication.run(EbookStoreAppApplication.class, args);
    }
    @PostConstruct
    public void init() {

        Ebook ebook1 = new Ebook(null, "Dzieci z Bullerbyn","Astrid Lindgren", "Argon", "img1.jpg", "Lektura obowiązkowa, ale przyjemna", Genre.FICTION, 35.00F, 20.00F, Format.EPUB, Language.POLISH);
        Ebook ebook2 = new Ebook(null, "Karol Lwie Serce", "Astrid Lindgren", "Hel", "img2.jpg", "Fantastyczna przygoda w zaświatach", Genre.FANTASY, 40.00F, 25.00F, Format.MOBI, Language.POLISH);
        Ebook ebook3 = new Ebook(null, "Ronya Córka Rozbójnika", "Astrid Lindgren", "Ozon", "img3.jpg", "Przygody dorastającej dziewczynki", Genre.ADVENTURE, 25.00F, 10.00F, Format.PDF, Language.POLISH);

        ebookRepository.save(ebook1);
        ebookRepository.save(ebook2);
        ebookRepository.save(ebook3);


        Customer customer1 = new Customer(null, "kotek@gmail.com", "masło", new Address("Jan", "Kowalski", "Polska", "Warszawa", "Gołdapska", "01-500"), Role.USER,  null);
        Customer customer2 = new Customer(null, "piesek@gmail.com", "adfsasfd", new Address("Karolina", "Makowiecka", "Polska", "Olecko", "Stadionowa", "19-400"), Role.USER, null);
        Customer customer3 = new Customer(null, "kotpyrymykyryek@gmail.com", "ma1234SAsło", new Address("Edyta", "Kowal", "Polska", "Ełk", "Sportowa", "19-300"), Role.USER, null);
        Customer customerAdmin = new Customer(null, "admin@gmail.com", "$2a$12$PO6bTMreR.UXUHBDLk.SMuj7JQi0OJjmURL7WzQOTV38EYLTUgBrW", new Address("Edyta", "Kowal", "Polska", "Ełk", "Sportowa", "19-300"), Role.ADMIN, null);
        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);
        customerRepository.save(customerAdmin);

        List<Ebook> purchased1= new ArrayList<>();
        purchased1.add(ebook1);
        List<Ebook> purchased2= List.of(ebook3, ebook2);
//        List<Ebook> purchased3= List.of(ebook2);

        Purchase purchase1 = new Purchase(null, customer1, BigDecimal.valueOf(15000), LocalDate.now(), DeliveryType.EMAIL,purchased1);
        Purchase purchase2 = new Purchase(null, customer2, BigDecimal.valueOf(200), LocalDate.now(), DeliveryType.EMAIL, purchased2);
        Purchase purchase3 = new Purchase(null, customer3, BigDecimal.valueOf(100), LocalDate.now(), DeliveryType.SMS, null);


        purchaseRepository.save(purchase1);
        purchaseRepository.save(purchase2);
        purchaseRepository.save(purchase3);
    }

}
