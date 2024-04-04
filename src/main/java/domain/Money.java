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

    public double divide(int divisor) {
        return (double) this.value / divisor;
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
