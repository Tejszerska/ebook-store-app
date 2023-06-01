package pl.ebookstore.app.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.ebookstore.app.model.enums.Format;
import pl.ebookstore.app.model.enums.Genre;
import pl.ebookstore.app.model.enums.Language;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EbookAdminDto extends  EbookDto {

    private Float purchaseCost;

    public EbookAdminDto(Long id, String title, String authors, String publisher, String coverUrl, String description, Genre genre, Float sellingPrice, Format format, Language language, Float purchaseCost) {
        super(id, title, authors, publisher, coverUrl, description, genre, sellingPrice, format, language);
        this.purchaseCost = purchaseCost;
    }
}
