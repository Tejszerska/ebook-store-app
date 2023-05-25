package pl.ebookstore.app.entities;

import lombok.*;
import pl.ebookstore.app.model.Format;
import pl.ebookstore.app.model.Genre;
import pl.ebookstore.app.model.Language;

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
    @ManyToMany (mappedBy = "publishedEbooks")
    private List<Author> authors;
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
}
