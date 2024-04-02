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
}
