package ru.tolstov.contry.domain.qraphql;

import java.util.UUID;

public record CountryGql(
        UUID id,
        String name,
        String code) {
}
