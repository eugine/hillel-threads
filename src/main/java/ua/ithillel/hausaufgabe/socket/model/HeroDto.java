package ua.ithillel.hausaufgabe.socket.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HeroDto {
    Integer id;
    String name;
    String gender;
    String race;
    String publisher;
    String skinColor;
    String alignment;
}
