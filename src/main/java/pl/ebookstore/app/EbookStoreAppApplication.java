package pl.ebookstore.app;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.ebookstore.app.entities.Author;
import pl.ebookstore.app.entities.Customer;
import pl.ebookstore.app.entities.Ebook;
import pl.ebookstore.app.entities.Purchase;
import pl.ebookstore.app.model.*;
import pl.ebookstore.app.repository.AuthorRepository;
import pl.ebookstore.app.repository.CustomerRepository;
import pl.ebookstore.app.repository.EbookRepository;
import pl.ebookstore.app.repository.PurchaseRepository;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class EbookStoreAppApplication {
private final EbookRepository ebookRepository;
private final AuthorRepository authorRepository;
private final CustomerRepository customerRepository;
private final PurchaseRepository purchaseRepository;
    public static void main(String[] args) {
        SpringApplication.run(EbookStoreAppApplication.class, args);
    }
    @PostConstruct
    public void init() {

        Ebook ebook1 = new Ebook(null, "Dzieci z Bullerbyn",null, "Argon", "images/img1.jpg", "Lektura obowiązkowa, ale przyjemna", Genre.FICTION, 35.00F, 20.00F, Format.EPUB, Language.POLISH);
        Ebook ebook2 = new Ebook(null, "Karol Lwie Serce", null, "Hel", "images/img2.jpg", "Fantastyczna przygoda w zaświatach", Genre.FANTASY, 40.00F, 25.00F, Format.MOBI, Language.POLISH);
        Ebook ebook3 = new Ebook(null, "Ronya Córka Rozbójnika", null, "Ozon", "images/default.jpg", "Przygody dorastającej dziewczynki", Genre.ADVENTURE, 25.00F, 10.00F, Format.PDF, Language.POLISH);

        ebookRepository.save(ebook1);
        ebookRepository.save(ebook2);
        ebookRepository.save(ebook3);

        Author author1 = new Author(null, "Astrid", "Lindgren", List.of(ebook1));
        Author author2 = new Author(null, "J.K.", "Rowling", List.of(ebook2, ebook1));
        Author author3 = new Author(null, "Andrzej", "Sapkowski", List.of(ebook3));

        authorRepository.save(author1);
        authorRepository.save(author2);
        authorRepository.save(author3);

        Customer customer1 = new Customer(null, "kotek@gmail.com", "masło", new Address("Jan", "Kowalski", "Polska", "Warszawa", "Gołdapska", "01-500"), Role.USER, DeliveryType.EMAIL, null);
        Customer customer2 = new Customer(null, "piesek@gmail.com", "adfsasfd", new Address("Karolina", "Makowiecka", "Polska", "Olecko", "Stadionowa", "19-400"), Role.USER, DeliveryType.SMS, null);
        Customer customer3 = new Customer(null, "kotpyrymykyryek@gmail.com", "ma1234SAsło", new Address("Edyta", "Kowal", "Polska", "Ełk", "Sportowa", "19-300"), Role.USER, DeliveryType.EMAIL, null);
        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);

        Purchase purchase1 = new Purchase(null, customer1, BigDecimal.valueOf(15000), LocalDate.now());
        Purchase purchase2 = new Purchase(null, customer2, BigDecimal.valueOf(200), LocalDate.now());
        Purchase purchase3 = new Purchase(null, customer3, BigDecimal.valueOf(100), LocalDate.now());


        purchaseRepository.save(purchase1);
        purchaseRepository.save(purchase2);
        purchaseRepository.save(purchase3);
    }

}
