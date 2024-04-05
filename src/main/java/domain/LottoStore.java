package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class LottoStore {

    private static final int LOTTO_PRICE = 1000;

    private final long lottoCount;

    public LottoStore(Money money) {
        this.lottoCount = money.divide(LOTTO_PRICE).getValue();
    }

    public long getLottoCount() {
        return lottoCount;
    }

    public List<LottoTicket> getLottoTickets(NumberGenerator numberGenerator) {
        return LongStream.range(0, lottoCount)
            .mapToObj(number -> new LottoTicket(numberGenerator.generateNumbers()))
            .collect(Collectors.toList());
    }
}
