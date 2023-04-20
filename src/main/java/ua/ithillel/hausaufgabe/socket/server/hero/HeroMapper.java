package ua.ithillel.hausaufgabe.socket.server.hero;

import ua.ithillel.hausaufgabe.socket.model.HeroDto;

class HeroMapper {

    protected HeroDto toDto(Hero hero) {
        return HeroDto.builder()
                .name(hero.getName())
                .gender(hero.getGender())
                .publisher(hero.getPublisher())
                .race(hero.getRace())
                .alignment(hero.getAlignment())
                .skinColor(hero.getSkinColor())
                .race(hero.getRace())
                .build();
    }

    public Hero fromDto(HeroDto hero) {
        return Hero.builder()
                .name(hero.getName())
                .alignment(hero.getAlignment())
                .skinColor(hero.getSkinColor())
                .gender(hero.getGender())
                .publisher(hero.getPublisher())
                .race(hero.getRace())
                .build();
    }
}
