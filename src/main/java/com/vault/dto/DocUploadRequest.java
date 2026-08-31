package com.vault.dto;

import jakarta.validation.constraints.NotBlank;

public record DocUploadRequest(

    @NotBlank String title,
    @NotBlank String department

) {}

