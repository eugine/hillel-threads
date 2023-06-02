package ua.ithillel.bank.credit.score;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DummyCreditScoreService implements CreditScoreService{
    @Override
    public int getScore(String personId) {
        log.info("Getting score from dummy");
        return 0;
    }
}
