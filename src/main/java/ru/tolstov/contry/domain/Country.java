package ru.tolstov.contry.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Country(
        String name,
        String code
) {
}
