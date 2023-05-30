package pl.ebookstore.app.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.ebookstore.app.entities.Author;
import pl.ebookstore.app.entities.Ebook;

import pl.ebookstore.app.model.dtos.EbookDto;
import pl.ebookstore.app.service.EbookService;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/ebooks")
public class EbookController {
    private final EbookService ebookService;

@GetMapping
    public String ebook(Model model){

    List<EbookDto> ebooksFromDb = ebookService.getEbooks();

    model.addAttribute("ebooks", ebooksFromDb);
    model.addAttribute("newEbook", new Ebook());
    return "ebooks";
}

}
