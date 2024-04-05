package view;

import domain.LottoPrice;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    public void printGameGuide() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printLottoCount(long count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public void printUserLottos(List<List<Integer>> userLottos) {
        userLottos.forEach(this::printLottoNumbers);
        System.out.println();
    }

    private void printLottoNumbers(List<Integer> lottoNumbers) {
        String lottoNumberString = lottoNumbers.stream()
            .map(String::valueOf)
            .collect(Collectors.joining(", "));

        System.out.println("[" + lottoNumberString + "]");
    }

    public void printWinningNumbersGuide() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public void printBonusBallGuide() {
        System.out.println("보너스 볼을 입력해 주세요.");
    }

    public void printStatistics(Map<LottoPrice, Integer> lottoPriceCount) {
        System.out.println("당첨 통계");
        System.out.println("---------");

        Arrays.stream(LottoPrice.values())
            .filter(lottoPrice -> lottoPrice.isGreaterThan(0))
            .sorted(Comparator.comparingInt(LottoPrice::getPrice))
            .forEach(lottoPrice -> printStatic(lottoPriceCount, lottoPrice));
    }

    private void printStatic(Map<LottoPrice, Integer> lottoPriceCount, LottoPrice lottoPrice) {
        StringBuilder sb = new StringBuilder(lottoPrice.getCount() + "개 일치");

        if (lottoPrice.equals(LottoPrice.SECOND)) {
            sb.append(", 보너스 볼 일치");
        }

        sb.append("(").append(lottoPrice.getPrice()).append("원) - ")
            .append(lottoPriceCount.getOrDefault(lottoPrice, 0)).append("개");

        System.out.println(sb);
    }

    public void printRevenue(float revenue) {
        System.out.println("총 수익률은 " + revenue + "입니다.");
    }
}
