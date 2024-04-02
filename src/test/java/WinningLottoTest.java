import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    @Test
    void 보너스번호_로또번호_중복불가() {
        LottoTicket winningLottoTicket = new LottoTicket(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = new LottoNumber(6);

        assertThrows(IllegalArgumentException.class,
            () -> new WinningLotto(winningLottoTicket, bonusNumber));
    }

    @Test
    void 일치하는_로또번호_계산() {
        LottoTicket winningLottoTicket = new LottoTicket(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = new LottoNumber(7);
        WinningLotto winningLotto = new WinningLotto(winningLottoTicket, bonusNumber);

        long prize = winningLotto.calculatePrize(new LottoTicket(List.of(1, 2, 3, 11, 12, 13)));
        assertThat(prize).isEqualTo(3);
    }
}