package ua.ithillel.rest;


public record StudentCreationRequest(
        String name,
        String email
) {
}