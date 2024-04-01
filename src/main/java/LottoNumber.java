public class LottoNumber {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;

    private final int number;

    public LottoNumber(int number) {
        validateNumberRange(number);
        this.number = number;
    }

    private void validateNumberRange(int number) {
        if (number < MIN_VALUE || number > MAX_VALUE) {
            throw new IllegalArgumentException("로또 번호는 1 이상 45 이하이어야 합니다.");
        }
    }
}
