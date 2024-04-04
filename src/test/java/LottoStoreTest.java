import static org.assertj.core.api.Assertions.assertThat;

import domain.LottoStore;
import domain.LottoTicket;
import domain.Money;
import domain.NumberGenerator;
import java.util.List;
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

    @Test
    void 자동로또_발권() {
        LottoStore lottoStore = new LottoStore(new Money(1_000));
        List<LottoTicket> lottoTickets = lottoStore.getLottoTickets(new MockNumberGeneratr());

        assertThat(lottoTickets).hasSize(1);
        assertThat(lottoTickets.get(0).getLottoNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    private static class MockNumberGeneratr implements NumberGenerator {

        @Override
        public List<Integer> generateNumbers() {
            return List.of(1, 2, 3, 4, 5, 6);
        }
    }
}
