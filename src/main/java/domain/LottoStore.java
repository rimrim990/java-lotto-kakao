package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class LottoStore {

    private static final Money LOTTO_PRICE = new Money(1000);

    private final Quantity lottoCount;

    public LottoStore(Money money) {
        this.lottoCount = money.calculatePurchaseQuantity(LOTTO_PRICE);
    }

    public long getLottoCount() {
        return lottoCount.getValue();
    }

    public List<LottoTicket> generateAutoLottos(NumberGenerator numberGenerator) {
        return LongStream.range(0, lottoCount.getValue())
            .mapToObj(number -> new LottoTicket(numberGenerator.generateNumbers()))
            .collect(Collectors.toList());
    }
}
