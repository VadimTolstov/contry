package ru.tolstov.contry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.tolstov.contry.domain.Country;
import ru.tolstov.contry.service.CountryService;

import java.util.List;
import java.util.UUID;

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
    public Slice<Country> all(Pageable pageable) {
        return countryService.allCountry(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Country countryById(@PathVariable("id") UUID id) {
        return countryService.countryById(id);
    }


    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Country add(@RequestBody Country country) {
        return countryService.addCountry(country);
    }

    @PatchMapping("/update/{countryCode}")
    @ResponseStatus(HttpStatus.OK)
    public Country update(@PathVariable("countryCode") String countryCode, @RequestBody Country country) {
        return countryService.updateCountryName(country);
    }
}
