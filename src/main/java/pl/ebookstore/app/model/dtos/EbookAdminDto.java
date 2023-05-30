package pl.ebookstore.app.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EbookAdminDto extends  EbookDto {
    private String publisher;
    private Float purchaseCost;
}
