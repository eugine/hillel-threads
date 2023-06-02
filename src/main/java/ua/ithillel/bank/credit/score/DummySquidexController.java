package ua.ithillel.bank.credit.score;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/squidex")
@RequiredArgsConstructor
public class DummySquidexController {

    private final CreditScoreService creditScoreService;

    @GetMapping("/score")
    public Integer getScore() {
        return creditScoreService.getScore("any");
    }
}
