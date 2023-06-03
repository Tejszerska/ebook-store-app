package pl.ebookstore.app;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.WebApplicationContext;
import pl.ebookstore.app.model.dtos.CartItemDto;
import pl.ebookstore.app.model.dtos.EbookDto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Data
@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShoppingCart {
    private List<CartItemDto> cartItems;
    private BigDecimal totalCost;

    public void addToCart(EbookDto ebookDto) {
        BigDecimal newEbookPrice = BigDecimal.valueOf(ebookDto.getSellingPrice());


        if (cartItems == null) {
        cartItems = new ArrayList<>();
        }

        Optional<CartItemDto> first = cartItems.stream().filter(c -> c.getEbookDto().getId().equals(ebookDto.getId())).findFirst();
if(first.isPresent()){
    first.get().setQuantity(first.get().getQuantity()+1);
    first.get().setTotalCost(first.get().getTotalCost().add(newEbookPrice));
} else {
    CartItemDto cartItemDto = new CartItemDto();
    cartItemDto.setEbookDto(ebookDto);
    cartItemDto.setQuantity(1);
    cartItemDto.setTotalCost(BigDecimal.valueOf(ebookDto.getSellingPrice()));
    cartItems.add(cartItemDto);
}

if (totalCost == null){
    totalCost = new BigDecimal(0);
}
        totalCost = totalCost.add(newEbookPrice);
    }

    public int getCartSize() {
        if(CollectionUtils.isEmpty(cartItems)){
            return 0;
        } else {
            int total = 0;
            for(CartItemDto cartItemDto : cartItems){
                total = total + cartItemDto.getQuantity();
            }
            return total;
        }

    }
}
