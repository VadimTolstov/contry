package ru.tolstov.contry.service;

import jakarta.annotation.Nonnull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.tolstov.contry.data.CountryEntity;
import ru.tolstov.contry.data.CountryRepository;
import ru.tolstov.contry.domain.Country;
import ru.tolstov.contry.ex.CountryNotFoundException;

import java.util.List;

@Component
public class DbCountryService implements CountryService {

    private final CountryRepository countryRepository;

    @Autowired
    public DbCountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public @Nonnull List<Country> allCountry() {
        return countryRepository.findAll()
                .stream()
                .map(ce -> {
                    return new Country(
                            ce.getName(),
                            ce.getCode()
                    );
                }).toList();
    }

    @Override
    public Country addCountry(Country country) {
        if (country.name() == null || country.code() == null) {
            throw new IllegalArgumentException("Name and code must not be null");
        }
        CountryEntity countryEntity = new CountryEntity()
                .setName(country.name())
                .setCode(country.code());
        countryEntity = countryRepository.save(countryEntity);
        return new Country(countryEntity.getName(), countryEntity.getCode());
    }

    @Override
    public Country updateCountryName(String countryCode, String countryName) {
        CountryEntity countryEntity = countryRepository.findByCode(countryCode)
                .orElseThrow(() -> new CountryNotFoundException("Country not found with code: " + countryCode));
        countryEntity.setName(countryName);
        countryEntity = countryRepository.save(countryEntity);
        return new Country(countryEntity.getName(), countryEntity.getCode());
    }
}
