package domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoGame {

    private final WinningLotto winningLotto;
    private final List<LottoTicket> lottoTickets;

    public LottoGame(WinningLotto winningLotto, List<LottoTicket> lottoTickets) {
        this.winningLotto = winningLotto;
        this.lottoTickets = lottoTickets;
    }

    public Map<LottoPrice, Integer> calculateRank() {
        return lottoTickets.stream()
            .collect(Collectors.toMap(
                winningLotto::calculatePrize, lottoTicket -> 1, Integer::sum));
    }
}
