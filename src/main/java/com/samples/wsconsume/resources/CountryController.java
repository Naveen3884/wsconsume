package com.samples.wsconsume.resources;

import com.samples.wsconsume.classes.CountryClient;
import countries.wsdl.GetCountryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private CountryClient countryClient;
    @GetMapping("/{country}")
    public GetCountryResponse getCountryResponse(@PathVariable("country") String country){

        return countryClient.getCountry(country);
    }
}
