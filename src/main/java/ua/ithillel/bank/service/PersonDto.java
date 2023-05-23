package ua.ithillel.bank.service;

import lombok.Builder;

@Builder
public record PersonDto(
        String id,
        String name,
        String email
) {
}
