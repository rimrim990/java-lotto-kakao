package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoPair {

    private final List<LottoTicket> manualLottos;
    private final List<LottoTicket> autoLottos;

    public LottoPair(List<LottoTicket> manualLottos, List<LottoTicket> autoLottos) {
        this.manualLottos = manualLottos;
        this.autoLottos = autoLottos;
    }

    public int getAutoLottoSize() {
        return autoLottos.size();
    }

    public int getManualLottoSize() {
        return manualLottos.size();
    }

    public int getTotalSize() {
        return manualLottos.size() + autoLottos.size();
    }

    public List<LottoTicket> getLottoTickets() {
        List<LottoTicket> result = new ArrayList<>(manualLottos);
        result.addAll(new ArrayList<>(autoLottos));
        return result;
    }
}
