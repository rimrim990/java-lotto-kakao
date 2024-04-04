package domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoGame {

    private static final int LOTTO_PRICE = 1000;

    private final List<LottoTicket> lottoTickets;
    private final Map<LottoPrice, Integer> lottoResult;

    public LottoGame(WinningLotto winningLotto, List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
        this.lottoResult = calculateRank(winningLotto);
    }

    private Map<LottoPrice, Integer> calculateRank(WinningLotto winningLotto) {
        return lottoTickets.stream()
            .collect(Collectors.toMap(
                winningLotto::calculatePrize, lottoTicket -> 1, Integer::sum));
    }

    public Map<LottoPrice, Integer> getRank() {
        return Collections.unmodifiableMap(lottoResult);
    }

    public float calculateRevenue() {
        int income = calculateTotalIncome();
        int used = LOTTO_PRICE * lottoTickets.size();
        return (float) income / used;
    }

    private int calculateTotalIncome() {
        return lottoResult.entrySet()
            .stream()
            .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
            .sum();
    }
}
