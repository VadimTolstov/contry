package ru.tolstov.contry.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record Country(
        @NotBlank(message = "Country code is required")
        @Size(min = 2, max = 5, message = "Code must be between 2 and 5 characters")
        String name,

        @NotBlank(message = "Country name is required")
        @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
        String code
) {
}
