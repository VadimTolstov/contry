package ru.tolstov.contry.service;

import ru.tolstov.contry.domain.Country;

import java.util.List;

public interface CountryService {

    List<Country> allCountry();

    Country addCountry(Country country);

    Country updateCountryName(String countryCode, String countryName);
}
