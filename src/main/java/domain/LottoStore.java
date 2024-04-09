package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class LottoStore {

    private static final Money LOTTO_PRICE = new Money(1000);

    private Money availableMoney;

    public LottoStore(Money money) {
        this.availableMoney = money;
    }

    public List<LottoTicket> buyAutoLottos(NumberGenerator numberGenerator) {
        Quantity availableAutoLottoCount = availableMoney.calculatePurchaseQuantity(LOTTO_PRICE);
        return LongStream.range(0, availableAutoLottoCount.getValue())
            .mapToObj(number -> new LottoTicket(numberGenerator.generateNumbers()))
            .collect(Collectors.toList());
    }

    public List<LottoTicket> buyManualLottos(List<String> manualLottoNumbers) {
        validateMoney(LOTTO_PRICE.multiply(manualLottoNumbers.size()));

        this.availableMoney = availableMoney.buy(LOTTO_PRICE, new Quantity(manualLottoNumbers.size()));
        return manualLottoNumbers.stream()
            .map(LottoTicket::new)
            .collect(Collectors.toList());
    }

    private void validateMoney(Money need) {
        if (this.availableMoney.isLessThan(need)) {
            throw new IllegalArgumentException("남은 금액이 부족합니다.");
        }
    }
}
