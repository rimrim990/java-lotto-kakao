package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoStore {

    private static final int LOTTO_PRICE = 1000;

    private final int lottoCount;

    public LottoStore(Money money) {
        this.lottoCount = (int) money.divide(LOTTO_PRICE);
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public List<LottoTicket> getLottoTickets(NumberGenerator numberGenerator) {
        return IntStream.range(0, lottoCount)
            .mapToObj(number -> new LottoTicket(numberGenerator.generateNumbers()))
            .collect(Collectors.toList());
    }
}
