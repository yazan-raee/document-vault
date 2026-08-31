package com.vault.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotNull;

public record DocResponse(

    UUID id,
    String title,
    String department,
    String ownerUsername,
    @DateTimeFormat @NotNull LocalDateTime createdAt
) {
}
