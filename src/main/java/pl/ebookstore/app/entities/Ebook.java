package pl.ebookstore.app.entities;

import lombok.*;
import pl.ebookstore.app.model.enums.Format;
import pl.ebookstore.app.model.enums.Genre;
import pl.ebookstore.app.model.enums.Language;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Ebook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String authors;
    private String publisher;
    private String coverUrl;
    private String description;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    private Float sellingPrice;
    private Float purchaseCost;
    @Enumerated(EnumType.STRING)
    private Format format;
    @Enumerated(EnumType.STRING)
    private Language language;



    public Ebook(String title) {
        this.title = title;
    }

    public Ebook(Long id, String title, String authors, String publisher, String coverUrl, String description, Genre genre, Float sellingPrice, Format format, Language language) {
    }
}
