package pl.ebookstore.app.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.ebookstore.app.ShoppingCart;
import pl.ebookstore.app.entities.Ebook;

import pl.ebookstore.app.model.dtos.CustomerDto;
import pl.ebookstore.app.model.dtos.EbookDto;
import pl.ebookstore.app.model.enums.Format;
import pl.ebookstore.app.model.enums.Genre;
import pl.ebookstore.app.model.enums.Language;
import pl.ebookstore.app.service.EbookService;

import java.util.Arrays;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/ebooks")
public class EbookController {
    private final EbookService ebookService;
    private final ShoppingCart shoppingCart;

@GetMapping
    public String ebook(Model model){
    List<EbookDto> ebooksFromDb = ebookService.getEbooks();
    model.addAttribute("ebooks", ebooksFromDb);
    model.addAttribute("newEbook", new Ebook());
    int cartSize = shoppingCart.getCartSize();
    model.addAttribute("cartSize", cartSize);
    return "ebooks";
}

@GetMapping
    @RequestMapping("/details/{ebookId}")
    public String ebookDetails (Model model, @PathVariable Long ebookId){
    EbookDto ebookById = ebookService.getEbookById(ebookId);
    model.addAttribute("ebookById", ebookById);
    int cartSize = shoppingCart.getCartSize();
    model.addAttribute("cartSize", cartSize);
    return "ebook-details";
}


}
