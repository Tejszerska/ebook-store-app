package pl.ebookstore.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pl.ebookstore.app.model.dtos.EbookDto;
import pl.ebookstore.app.model.enums.Format;
import pl.ebookstore.app.model.enums.Genre;
import pl.ebookstore.app.model.enums.Language;
import pl.ebookstore.app.service.EbookService;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor

public class AdminController {
    private final EbookService ebookService;

    @GetMapping
    @RequestMapping("/panel")
    public String getAddEbookView(Model model){
        model.addAttribute("newEbook", new EbookDto());
        List<String> genreList = Arrays.stream(Genre.values()).map(Enum::name).toList();
        model.addAttribute("genres", genreList);
        List<String> formatList = Arrays.stream(Format.values()).map(Enum::name).toList();
        model.addAttribute("formats", formatList);
        List<String> languageList = Arrays.stream(Language.values()).map(Enum::name).toList();
        model.addAttribute("languages", languageList);
        return "add-ebook";
    }


    @PostMapping
    @RequestMapping("/panel/add")
    public String addEbook(EbookDto ebookDto, @RequestParam("cover") MultipartFile file){
        ebookDto.setCoverUrl(file.getOriginalFilename());
        ebookService.addEbook(ebookDto, file);
        return "redirect:/admin/panel";
    }

}
