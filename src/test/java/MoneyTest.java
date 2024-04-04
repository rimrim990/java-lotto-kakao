import static org.junit.jupiter.api.Assertions.assertThrows;

import domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Money 단위 테스트")
public class MoneyTest {

    @Test
    void 금액은_0이상() {
        assertThrows(IllegalArgumentException.class, () -> new Money(-12));
    }
}
