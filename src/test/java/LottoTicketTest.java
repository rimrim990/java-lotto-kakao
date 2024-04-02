import static org.assertj.core.api.Assertions.assertThatThrownBy;

import domain.LottoTicket;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("LottoTicket 단위 테스트")
public class LottoTicketTest {

    @Test
    void 로또티켓_번호중복() {
        assertThatThrownBy(() -> new LottoTicket(List.of(1, 1, 2, 3, 4, 5)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또티켓_번호_6개() {
        assertThatThrownBy(() -> new LottoTicket(List.of(1, 2, 3, 4, 5)))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
