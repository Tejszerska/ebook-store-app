package pl.ebookstore.app.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.ebookstore.app.entities.Author;
import pl.ebookstore.app.entities.Ebook;

import pl.ebookstore.app.model.Format;
import pl.ebookstore.app.model.Genre;
import pl.ebookstore.app.model.Language;
import pl.ebookstore.app.service.EbookService;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class EbookController {
    private final EbookService ebookService;

@GetMapping("/ebooks")
    public String ebook(Model model){
    // tu dobrać się do bazy danych @TODO Rafał pokaze na zajęciach 25.05
    model.addAttribute("ebooks", ebooks);
    model.addAttribute("newEbook", new Ebook());
}

}
