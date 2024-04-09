package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("LottoGame 단위 테스트")
class LottoGameTest {

    private final LottoTicket winningLottoTicket = new LottoTicket(List.of(1, 2, 3, 4, 5, 6));
    private final LottoNumber bonusNumber = new LottoNumber(7);
    private final WinningLotto winningLotto = new WinningLotto(winningLottoTicket, bonusNumber);
    private final List<LottoTicket> manualLottos =  List.of(new LottoTicket(List.of(1, 2, 3, 7, 9, 8)));
    private final List<LottoTicket> autoLottos = List.of(new LottoTicket(List.of(11, 12, 13, 14, 15, 16)));

    @Test
    void 로또번호_당첨_개수() {
        LottoGame lottoGame = new LottoGame(winningLotto, new LottoPair(manualLottos, autoLottos));
        Map<LottoPrice, Integer> result = lottoGame.getRank();

        assertThat(result).containsEntry(LottoPrice.NOTHING, 1);
        assertThat(result).containsEntry(LottoPrice.FIFTH, 1);
    }

    @Test
    void 로또번호_수익률() {
        LottoGame lottoGame = new LottoGame(winningLotto, new LottoPair(manualLottos, autoLottos));
        float result = lottoGame.calculateRevenue();

        assertThat(result).isCloseTo(2.5f, within(0.5f));
    }
}
