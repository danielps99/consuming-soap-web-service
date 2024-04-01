package com.example.consumingwebservice.controller;

import com.example.consumingwebservice.client.CountryClient;
import com.example.consumingwebservice.wsdl.Country;
import com.example.consumingwebservice.wsdl.GetCountryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "home")
public class HomeController {

    @Autowired
    CountryClient countryClient;
    @GetMapping("/")
    public ResponseEntity<Country> getCountry(@RequestParam(value = "name", defaultValue = "Brazil") String name) {
        GetCountryResponse response = countryClient.getCountry(name);
        return ResponseEntity.ok(response.getCountry());
    }
}
