package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class LottoStore {

    private static final Money LOTTO_PRICE = new Money(1000);

    private Money availableMoney;
    private final List<LottoTicket> manualLottos = new ArrayList<>();
    private final List<LottoTicket> autoLottos = new ArrayList<>();

    public LottoStore(Money money) {
        this.availableMoney = money;
    }

    public int getManualLottoCount() {
        return manualLottos.size();
    }

    public int getAutoLottoCount() {
        return autoLottos.size();
    }

    public List<LottoTicket> buyAutoLottos(NumberGenerator numberGenerator) {
        Quantity availableAutoLottoCount = availableMoney.calculatePurchaseQuantity(LOTTO_PRICE);
        List<LottoTicket> autoLottos = LongStream.range(0, availableAutoLottoCount.getValue())
            .mapToObj(number -> new LottoTicket(numberGenerator.generateNumbers()))
            .collect(Collectors.toList());

        this.autoLottos.addAll(autoLottos);
        return new ArrayList<>(autoLottos);
    }

    public List<LottoTicket> buyManualLottos(List<String> manualLottoNumbers) {
        List<LottoTicket> manualLottos = manualLottoNumbers.stream()
            .map(LottoTicket::new)
            .collect(Collectors.toList());

        this.availableMoney = availableMoney.buy(LOTTO_PRICE, new Quantity(manualLottos.size()));
        this.manualLottos.addAll(manualLottos);
        return new ArrayList<>(manualLottos);
    }
}
