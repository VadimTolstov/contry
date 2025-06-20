package ru.tolstov.contry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.tolstov.contry.domain.Country;
import ru.tolstov.contry.service.CountryService;

import java.util.List;

@RestController
@RequestMapping("api/country")
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Country> all() {
        return countryService.allCountry();
    }


    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Country add(@RequestBody Country country) {
        if (country == null) {
        }
        return countryService.addCountry(country);
    }


    @PatchMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Country update(@RequestBody Country country) {
        return countryService.updateCountryName(country);
    }
}
