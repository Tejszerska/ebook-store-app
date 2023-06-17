package pl.ebookstore.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.ebookstore.app.ShoppingCart;
import pl.ebookstore.app.model.dtos.CustomerDto;
import pl.ebookstore.app.model.dtos.CustomerPurchaseDto;
import pl.ebookstore.app.model.dtos.EbookDto;
import pl.ebookstore.app.model.dtos.PurchaseDto;
import pl.ebookstore.app.model.enums.DeliveryType;
import pl.ebookstore.app.model.enums.Role;
import pl.ebookstore.app.service.CustomerService;
import pl.ebookstore.app.service.EbookService;
import pl.ebookstore.app.service.PurchaseService;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("cart")
@RequiredArgsConstructor
public class ShoppingCartController {
    private final EbookService ebookService;
    private final ShoppingCart shoppingCart;
    private final CustomerService customerService;
    private final PurchaseService purchaseService;

    @PostMapping("/add")
    public String add(@RequestParam(name = "ebookId") Long ebookId) {
        EbookDto ebookDto = ebookService.getEbookById(ebookId);
        shoppingCart.addToCart(ebookDto);
        return "redirect:/ebooks";
    }

    @GetMapping
    public String showCart(Model model) {
        model.addAttribute("newCustomerPurchase", new CustomerPurchaseDto());
        model.addAttribute("cartItems", shoppingCart.getCartItems());
        model.addAttribute("totalCost", shoppingCart.getTotalCost() != null ? shoppingCart.getTotalCost().toString() : "0");
        int cartSize = shoppingCart.getCartSize();
        model.addAttribute("cartSize", cartSize);
        model.addAttribute("newCustomer", new CustomerDto());
        List<String> deliveryList = Arrays.stream(DeliveryType.values()).map(Enum::name).toList();
        model.addAttribute("deliveries", deliveryList);
        return "cart";

    }

    @GetMapping
    @RequestMapping("/register")
    public String getUnloggedPurchaseView(Model model) {
//        model.addAttribute("newCustomerPurchase", new CustomerPurchaseDto());
//        List<String> roleList = Arrays.stream(Role.values()).map(Enum::name).toList();
//        model.addAttribute("roles", roleList);
//
        return "summary";
    }

    @PostMapping
    @RequestMapping("/unlogged/add")
    public String unloggedCustomer(CustomerPurchaseDto customerPurchaseDto) {
        purchaseService.addPurchase(customerPurchaseDto);
//        purchaseService.addPurchase(customerPurchaseDto);
        return "redirect:/cart";
    }

}
