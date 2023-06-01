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
import pl.ebookstore.app.service.EbookService;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor

public class AdminController {
    private final EbookService ebookService;

    @GetMapping
    @RequestMapping("/panel")
    public String getAddEbookView(Model model){
        model.addAttribute("newEbook", new EbookDto());
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
