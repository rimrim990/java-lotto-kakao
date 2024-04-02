import static org.assertj.core.api.Assertions.assertThat;

import domain.LottoGame;
import domain.LottoNumber;
import domain.LottoPrice;
import domain.LottoTicket;
import domain.WinningLotto;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("LottoGame 단위 테스트")
class LottoGameTest {

    private final LottoTicket winningLottoTicket = new LottoTicket(List.of(1, 2, 3, 4, 5, 6));
    private final LottoNumber bonusNumber = new LottoNumber(7);
    private final WinningLotto winningLotto = new WinningLotto(winningLottoTicket, bonusNumber);

    @Test
    void 로또번호_당첨_개수() {
        List<LottoTicket> lottoTickets = List.of(
            new LottoTicket(List.of(11, 12, 13, 14, 15, 16)),
            new LottoTicket(List.of(1, 2, 3, 4, 7, 8))
        );

        LottoGame lottoGame = new LottoGame(winningLotto, lottoTickets);
        Map<LottoPrice, Integer> result = lottoGame.calculateRank();

        assertThat(result).containsEntry(LottoPrice.NOTHING, 1);
        assertThat(result).containsEntry(LottoPrice.FOURTH, 1);
    }
}
