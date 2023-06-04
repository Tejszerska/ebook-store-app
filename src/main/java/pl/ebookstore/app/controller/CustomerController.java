package pl.ebookstore.app.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pl.ebookstore.app.model.dtos.CustomerDto;
import pl.ebookstore.app.model.enums.Format;
import pl.ebookstore.app.model.enums.Genre;
import pl.ebookstore.app.model.enums.Language;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/customer")
@Slf4j
@RequiredArgsConstructor
public class CustomerController {



    @GetMapping
    @RequestMapping("/register")
    public String getAddCustomerView(Model model){
        model.addAttribute("newCustomer", new CustomerDto());
//        List<String> genreList = Arrays.stream(Genre.values()).map(Enum::name).toList();
//        model.addAttribute("genres", genreList);
//        List<String> formatList = Arrays.stream(Format.values()).map(Enum::name).toList();
//        model.addAttribute("formats", formatList);
//        List<String> languageList = Arrays.stream(Language.values()).map(Enum::name).toList();
//        model.addAttribute("languages", languageList);
        return "registration";
    }


    @PostMapping
    @RequestMapping("/register/add")
    public String addCustomer(CustomerDto customerDto, @RequestParam("cover") MultipartFile file){
//        customerDto.setCoverUrl(file.getOriginalFilename());
//        ebookService.addEbook(ebookDto, file);
        return "redirect:/cart";
    }
}
