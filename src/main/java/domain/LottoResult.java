package domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {

    private final Map<LottoPrice, Integer> lottoResult;

    public LottoResult(List<LottoTicket> lottoTickets, WinningLotto winningLotto) {
        this(lottoTickets.stream()
            .collect(
                Collectors.toMap(winningLotto::calculatePrize, lottoTicket -> 1, Integer::sum)));
    }

    private LottoResult(Map<LottoPrice, Integer> lottoResult) {
        this.lottoResult = lottoResult;
    }

    public int calculateTotalLottoPrice() {
        return lottoResult.entrySet()
            .stream()
            .mapToInt(entry -> entry.getKey().getPrice() * entry.getValue())
            .sum();
    }

    public Map<LottoPrice, Integer> getLottoResult() {
        return Collections.unmodifiableMap(lottoResult);
    }
}
