package ua.ithillel.hausaufgabe.socket.server.hero;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Hero {
    Integer id;
    String name;
    String gender;
    String eyeColor;
    String race;
    String hairColor;
    int height;
    String publisher;
    String skinColor;
    String alignment;
    int weight;
}
