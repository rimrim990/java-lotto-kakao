package domain;

import java.util.List;
import java.util.Map;

public class LottoGame {

    private static final int LOTTO_PRICE = 1000;

    private final List<LottoTicket> lottoTickets;
    private final LottoResult lottoResult;

    public LottoGame(WinningLotto winningLotto, List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
        this.lottoResult = new LottoResult(lottoTickets, winningLotto);
    }

    public Map<LottoPrice, Integer> getRank() {
        return lottoResult.getLottoResult();
    }

    public float calculateRevenue() {
        int income = calculateTotalIncome();
        int used = LOTTO_PRICE * lottoTickets.size();
        return (float) income / used;
    }

    private int calculateTotalIncome() {
        return lottoResult.calculateTotalLottoPrice();
    }
}
