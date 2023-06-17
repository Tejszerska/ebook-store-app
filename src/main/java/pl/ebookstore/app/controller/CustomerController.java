package pl.ebookstore.app.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.ebookstore.app.model.dtos.CustomerDto;

import pl.ebookstore.app.model.dtos.CustomerPurchaseDto;
import pl.ebookstore.app.service.CustomerService;



@Controller
@RequestMapping("/customer")
@Slf4j
@RequiredArgsConstructor
public class CustomerController {
private final CustomerService customerService;


    @GetMapping
    @RequestMapping("/register")
    public String getAddCustomerView(Model model){
        model.addAttribute("newCustomer", new CustomerDto());
        return "registration";
    }


    @PostMapping
    @RequestMapping("/register/add")
    public String addCustomer(CustomerDto customerDto){
        customerService.addCustomer(customerDto);
        return "redirect:/cart";
    }



}
