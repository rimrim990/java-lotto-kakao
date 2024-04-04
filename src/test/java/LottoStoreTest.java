import static org.assertj.core.api.Assertions.assertThat;

import domain.LottoStore;
import domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("LottoStore 단위 테스트")
public class LottoStoreTest {

    @Test
    void 로또_발권() {
        LottoStore lottoStore = new LottoStore(new Money(14_000));

        assertThat(lottoStore.getLottoCount()).isEqualTo(14);
        assertThat(lottoStore.getLottoTickets(new LottoNumberGenerator())).hasSize(14);
    }
}
