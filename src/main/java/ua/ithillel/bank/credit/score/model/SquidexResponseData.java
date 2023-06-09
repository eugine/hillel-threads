package ua.ithillel.bank.credit.score.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SquidexResponseData {
    private IvString name;
    private IvInteger score;
}
