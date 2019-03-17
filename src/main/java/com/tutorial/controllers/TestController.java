package com.tutorial.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TestController {

    @Value("${spring.application.name}")
    private String testText;

    private List<String> products;

    public TestController() {
        products = new ArrayList<>();
    }

    @RequestMapping("/")
    public String root() {
        return this.testText;
    }

    @RequestMapping("/all")
    public ResponseEntity all() {
        return new ResponseEntity("Products: " + StringListFrom(products), HttpStatus.CREATED);
    }

    @RequestMapping(value="/new", method=RequestMethod.POST)
    public ResponseEntity createProduct(@RequestBody String product) {
        product = formattedInputOf(product);
        products.add(product);
        return new ResponseEntity("Products: " + StringListFrom(products), HttpStatus.CREATED);
    }

    @RequestMapping(value="/delete", method=RequestMethod.DELETE)
    public ResponseEntity deleteProduct(@RequestBody String product) {
        product = formattedInputOf(product);
        products.remove(product);
        return new ResponseEntity("Products: " + StringListFrom(products), HttpStatus.CREATED);
    }

    private String StringListFrom(List<String> products) {
        return products.stream()
            .collect(Collectors.joining(" "));
    }

    private String formattedInputOf(@RequestBody String product) {
        return product.replaceAll("[=]", "");
    }
}


