package pl.ebookstore.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.ebookstore.app.entities.Ebook;
import pl.ebookstore.app.model.dtos.CustomerPurchaseDto;
import pl.ebookstore.app.model.dtos.EbookDto;
import pl.ebookstore.app.model.dtos.PurchaseDto;
import pl.ebookstore.app.model.enums.Format;
import pl.ebookstore.app.model.enums.Genre;
import pl.ebookstore.app.model.enums.Language;
import pl.ebookstore.app.service.EbookService;
import pl.ebookstore.app.service.PurchaseService;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor

public class AdminController {
    private final EbookService ebookService;
    private final PurchaseService purchaseService;


@GetMapping
@RequestMapping("/purchases/{purchaseId}")
public String purchaseDetails(Model model, @PathVariable Long purchaseId){
    PurchaseDto purchaseById = purchaseService.getPurchaseById(purchaseId);
    model.addAttribute("purchaseById", purchaseById);
   List<Ebook> purchasedEbooks = purchaseService.getEbooksFromPastPurchases(purchaseById.getId());
   model.addAttribute("purchasedEbooks", purchasedEbooks);
    return "admin-purchase-details";
    }

    @GetMapping
    @RequestMapping("/purchases")
    public String getPurchaseList(Model model) {
        List<PurchaseDto> purchases = purchaseService.getPurchases();
        model.addAttribute("purchases", purchases);
        return "admin-purchases";
    }

    @GetMapping
    @RequestMapping("/ebookslist")
    public String getEbooksList(Model model) {
        List<EbookDto> ebooksFromDb = ebookService.getEbooks();
        model.addAttribute("ebooks", ebooksFromDb);
        return "admin-ebooks";
    }

    @PostMapping
    @RequestMapping("/add")
    public String addEbook(EbookDto ebookDto, @RequestParam("cover") MultipartFile file) {
        ebookDto.setCoverUrl(file.getOriginalFilename());
        ebookService.addEbook(ebookDto, file);
        return "redirect:/admin/add-view";
    }

    @GetMapping
    @RequestMapping("/add-view")
    public String getAddEbookView(Model model) {
        model.addAttribute("newEbook", new EbookDto());
        List<String> genreList = Arrays.stream(Genre.values()).map(Enum::name).toList();
        model.addAttribute("genres", genreList);
        List<String> formatList = Arrays.stream(Format.values()).map(Enum::name).toList();
        model.addAttribute("formats", formatList);
        List<String> languageList = Arrays.stream(Language.values()).map(Enum::name).toList();
        model.addAttribute("languages", languageList);
        return "add-ebook";
    }

    @GetMapping
    public String getMainPanelView() {
        return "admin";
    }
}
