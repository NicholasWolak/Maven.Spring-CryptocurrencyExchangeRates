package com.zipcoder.cryptonator_api.controller;

import com.zipcoder.cryptonator_api.domain.Foo;
import com.zipcoder.cryptonator_api.services.FooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by leon on 1/22/18.
 */

@RestController
@RequestMapping(value = "/crypto")
public class FooController {

    @Autowired
    private FooService service;

    private RestTemplate rest;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) {
        return args -> {
            this.sampleFetch(restTemplate);
        };
    }

    private void sampleFetch(RestTemplate restTemplate) {
        String uriString = "https://api.cryptonator.com/api/ticker/btc-usd";
        System.out.println("Fetching object from cryptonator.com");
        System.out.println("Attempting to retrieve object from URI...");
        System.out.println(uriString);
        Object jsonObject = restTemplate.getForObject(uriString, Object.class);
        System.out.println(jsonObject.toString());
    }

    // to fetch new crypto data
    //restTemp is always null?
    private Object goodFetch(RestTemplate restTemplate, String ticker, String target) {
        String uriString = "https://api.cryptonator.com/api/ticker/" +
                ticker + "-" + target;
        System.out.println("Fetching object from cryptonator.com");
        System.out.println("Attempting to retrieve object from URI...");
        System.out.println(uriString);
        Object jsonObject = restTemplate.getForObject(uriString, Object.class);
        System.out.println(jsonObject.toString());
        return jsonObject;
    }

    @PostMapping(value = "/{ticker}-{target}")
    public ResponseEntity<Foo> findCrypto(
            @PathVariable String ticker,
            @PathVariable String target ) {
        Object result = goodFetch(null, ticker, target);
        return new ResponseEntity<>(service.create((Foo) result), HttpStatus.CREATED);
    }

    @GetMapping(value = "/read/{ticker}")
    public ResponseEntity<Foo> readTicker(
            @PathVariable String ticker) {
        return new ResponseEntity<>(service.read(ticker), HttpStatus.OK);
    }

    @GetMapping(value = "/read")
    public ResponseEntity<List<Foo>> readAll() {
        return new ResponseEntity<>(service.readAll(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{ticker}")
    public ResponseEntity<Foo> delete(
            @PathVariable String ticker ) {
        return new ResponseEntity<>(service.delete(ticker), HttpStatus.OK);
    }
}
