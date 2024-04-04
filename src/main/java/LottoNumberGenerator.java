import domain.NumberGenerator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberGenerator implements NumberGenerator {

    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;
    private static final int NUMBER_SIZE = 6;

    private final List<Integer> lottoNumbers;

    public LottoNumberGenerator() {
        lottoNumbers = IntStream.rangeClosed(MIN_VALUE, MAX_VALUE)
            .boxed()
            .collect(Collectors.toList());
    }

    @Override
    public List<Integer> generateNumbers() {
        Collections.shuffle(lottoNumbers);
        return new ArrayList<>(lottoNumbers.subList(0, NUMBER_SIZE));
    }
}
