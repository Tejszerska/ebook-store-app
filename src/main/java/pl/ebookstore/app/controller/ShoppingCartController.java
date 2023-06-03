package pl.ebookstore.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.ebookstore.app.ShoppingCart;
import pl.ebookstore.app.model.dtos.EbookDto;
import pl.ebookstore.app.service.EbookService;

@Controller
@RequestMapping("cart")
@RequiredArgsConstructor
public class ShoppingCartController {
    private final EbookService ebookService;
    private final ShoppingCart shoppingCart;

    @PostMapping("/add")
    public String add(@RequestParam(name = "ebookId") Long ebookId) {
        EbookDto ebookDto = ebookService.getEbookById(ebookId);
        shoppingCart.addToCart(ebookDto);
        return "redirect:/ebooks";
    }

    @GetMapping
    public String showCart(Model model){
        model.addAttribute("cartItems", shoppingCart.getCartItems());
        model.addAttribute("totalCost", shoppingCart.getTotalCost() != null ? shoppingCart.getTotalCost().toString() : "0");
    int cartSize = shoppingCart.getCartSize();
    model.addAttribute("cartSize", cartSize);

    return "cart";

    }

}
