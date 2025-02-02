package ru.tolstov.contry.service;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import ru.tolstov.contry.domain.Country;

import java.util.UUID;

public interface CountryService {

    Slice<Country> allCountry(Pageable pageable);

    Country addCountry(Country country);

    Country countryById(UUID id);

    Country updateCountryName(String countryCode, String countryName);
}
