package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("LottoStore 단위 테스트")
public class LottoStoreTest {

    @Test
    void 자동로또_발권() {
        LottoStore lottoStore = new LottoStore(new Money(1_000));

        List<LottoTicket> autoLottos = lottoStore.buyAutoLottos(() -> List.of(1, 2, 3, 4, 5, 6));

        assertThat(autoLottos).hasSize(1);
        assertThat(autoLottos.get(0).getLottoNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    void 수동로또_발권() {
        LottoStore lottoStore = new LottoStore(new Money(2_000));

        List<LottoTicket> manualLottos = lottoStore.buyManualLottos(List.of("1, 2, 3, 4, 5, 6"));
        List<LottoTicket> autoLottos = lottoStore.buyAutoLottos(() -> List.of(1, 2, 3, 4, 5, 6));

        assertAll(
            () -> assertThat(manualLottos.get(0).getLottoNumbers()).containsExactly(1, 2, 3, 4, 5, 6),
            () -> assertThat(autoLottos.get(0).getLottoNumbers()).containsExactly(1, 2, 3, 4, 5, 6)
        );

    }
}
