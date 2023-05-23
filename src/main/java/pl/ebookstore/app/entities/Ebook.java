package pl.ebookstore.app.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.ebookstore.app.model.Format;
import pl.ebookstore.app.model.Genre;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Ebook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    @ManyToMany (mappedBy = "publishedEbooks")
    private List<Author> authors;
    private String publisher;
    private String coverUrl; //@TODO zapytać R.
    private String description;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    private Float sellingPrice;
    private Float purchaseCost;
    @Enumerated(EnumType.STRING)
    private Format format;
//    private List <Language>



}
