package com.tutorial.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.List;

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
    public String all() {
        return "";
    }

    @RequestMapping(value="/new", method=RequestMethod.POST)
    public ResponseEntity createProduct(@RequestBody String product) {
        String productsString = "";

        products.add(product);

        productsString = products.stream()
                .reduce((x, y) -> x + "\n" + y)
                .toString();

        return new ResponseEntity("Products: " + productsString, HttpStatus.CREATED);
    }

    @RequestMapping(value="/delete", method=RequestMethod.DELETE)
    public ResponseEntity deleteProduct(@RequestBody String product) {
        String productsString = "";

        products.remove(product);

        productsString = products.stream()
                .reduce((x, y) -> x + "\n" + y)
                .toString();

        return new ResponseEntity("Products: " + productsString, HttpStatus.CREATED);
    }
}


