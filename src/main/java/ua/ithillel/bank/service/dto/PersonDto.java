package ua.ithillel.bank.service.dto;

import lombok.Builder;

@Builder
public record PersonDto(String name, String email) {
}
