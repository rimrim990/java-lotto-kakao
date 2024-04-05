package domain;

import java.util.Objects;

public class Money {

    private final long value;

    public Money(long value) {
        validateRange(value);
        this.value = value;
    }

    private void validateRange(long value) {
        if (value < 0) {
            throw new IllegalArgumentException("금액은 0 이상이어야 합니다.");
        }
    }

    public Money divide(int divisor) {
        validateDivisor(divisor);
        return new Money( this.value / divisor);
    }

    private void validateDivisor(int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
    }

    public long getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money money = (Money) o;
        return value == money.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
