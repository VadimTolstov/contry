package ru.tolstov.contry.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public record Country(
        UUID id,
        String name,
        String code
) {
}
