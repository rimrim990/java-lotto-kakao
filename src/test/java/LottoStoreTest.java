import static org.assertj.core.api.Assertions.assertThat;

import domain.LottoStore;
import domain.LottoTicket;
import domain.Money;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("LottoStore 단위 테스트")
public class LottoStoreTest {

    @Test
    void 자동로또_발권() {
        LottoStore lottoStore = new LottoStore(new Money(1_000));

        lottoStore.buyAutoLottos(() -> List.of(1, 2, 3, 4, 5, 6));
        List<LottoTicket> lottoTickets = lottoStore.getLottos();

        assertThat(lottoTickets).hasSize(1);
        assertThat(lottoTickets.get(0).getLottoNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    void 수동로또_발권() {
        LottoStore lottoStore = new LottoStore(new Money(2_000));

        lottoStore.buyManualLottos(List.of("1, 2, 3, 4, 5, 6"));
        lottoStore.buyAutoLottos(() -> List.of(1, 2, 3, 4, 5, 6));
        List<LottoTicket> lottoTickets = lottoStore.getLottos();

        assertThat(lottoTickets).hasSize(2);
        assertThat(lottoTickets.get(0).getLottoNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(lottoTickets.get(1).getLottoNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }
}
