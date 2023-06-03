package pl.ebookstore.app.model.dtos;

import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDto {
    private EbookDto ebookDto;
    private int quantity;
    private BigDecimal totalCost;
}
