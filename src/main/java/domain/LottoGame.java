package domain;

import java.util.Map;

public class LottoGame {

    private static final int LOTTO_PRICE = 1000;

    private final LottoPair lottoPair;
    private final LottoResult lottoResult;

    public LottoGame(WinningLotto winningLotto, LottoPair lottoPair) {
        this.lottoPair = lottoPair;
        this.lottoResult = new LottoResult(this.lottoPair.getLottoTickets(), winningLotto);
    }

    public Map<LottoPrice, Integer> getRank() {
        return lottoResult.getLottoResult();
    }

    public float calculateRevenue() {
        int income = calculateTotalIncome();
        int used = LOTTO_PRICE * lottoPair.getTotalSize();
        return (float) income / used;
    }

    private int calculateTotalIncome() {
        return lottoResult.calculateTotalLottoPrice();
    }
}
