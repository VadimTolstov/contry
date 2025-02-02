package ru.tolstov.contry.service;

import jakarta.annotation.Nonnull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Component;
import ru.tolstov.contry.data.CountryEntity;
import ru.tolstov.contry.data.CountryRepository;
import ru.tolstov.contry.domain.Country;
import ru.tolstov.contry.ex.CountryNotFoundException;

import java.util.UUID;

@Component
public class DbCountryService implements CountryService {

    private final CountryRepository countryRepository;

    @Autowired
    public DbCountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public @Nonnull Slice<Country> allCountry(Pageable pageable) {
        return countryRepository.findAll(pageable)
                .map(ce -> new Country(
                        ce.getId(),
                        ce.getName(),
                        ce.getCode()
                ));
    }

    @Override
    public Country addCountry(@Nonnull Country country) {
        if (country.name() == null || country.code() == null) {
            throw new IllegalArgumentException("Name and code must not be null");
        }
        CountryEntity countryEntity = new CountryEntity()
                .setName(country.name())
                .setCode(country.code());
        countryEntity = countryRepository.save(countryEntity);
        return new Country(countryEntity.getId(), countryEntity.getName(), countryEntity.getCode());
    }

    @Override
    public Country countryById(UUID id) {
        return countryRepository.findById(id)
                .map(co -> new Country(
                        co.getId(),
                        co.getName(),
                        co.getCode()
                )).orElseThrow();
    }

    @Override
    public Country updateCountryName(@Nonnull Country country) {
        CountryEntity countryEntity = countryRepository.findByCode(country.code())
                .orElseThrow(() -> new CountryNotFoundException("Country not found with code: " + country.code()));
        countryEntity.setName(country.name());
        countryEntity = countryRepository.save(countryEntity);
        return new Country(countryEntity.getId(), countryEntity.getName(), countryEntity.getCode());
    }
}
