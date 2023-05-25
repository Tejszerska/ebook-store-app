package pl.ebookstore.app.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.ebookstore.app.entities.Author;
import pl.ebookstore.app.model.Format;
import pl.ebookstore.app.model.Genre;
import pl.ebookstore.app.model.Language;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EbookDto {
    private Long id;
    private String title;
    private List<Author> authors;
    private String coverUrl;
    private String description;
    private Genre genre;
    private Float sellingPrice;
    private Format format;
    private Language language;

}
