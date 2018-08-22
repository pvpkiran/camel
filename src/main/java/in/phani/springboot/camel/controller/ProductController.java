package in.phani.springboot.camel.controller;

import in.phani.springboot.camel.pojo.Product;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @PostMapping(value="/add",consumes="application/json")
    public Product addBank(@RequestBody @Valid Product product) {
       return product;
    }
}