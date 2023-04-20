package ua.ithillel.hausaufgabe.socket.server.hero;

import lombok.RequiredArgsConstructor;
import ua.ithillel.hausaufgabe.socket.model.HeroDto;

import java.util.Optional;

@RequiredArgsConstructor
public class HeroService {
    private final HeroDao heroDao;
    private final HeroMapper heroMapper;

    public Optional<HeroDto> findByName(String name) {
        return heroDao.findByName(name).stream()
                .findFirst()
                .map(heroMapper::toDto);
    }

    public void create(HeroDto hero) {
        heroDao.create(heroMapper.fromDto(hero));
    }
}
