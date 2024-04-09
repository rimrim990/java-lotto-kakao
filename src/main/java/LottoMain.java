import domain.LottoGame;
import domain.LottoPair;
import domain.LottoStore;
import domain.LottoTicket;
import domain.Money;
import domain.Quantity;
import domain.WinningLotto;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import view.InputView;
import view.OutputView;

public class LottoMain {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static void main(String[] args) {
        LottoPair lottoTickets = buyLottos();
        outputView.printUserLottos(
            lottoTickets.getLottoTickets().stream()
                .map(LottoTicket::getLottoNumbers)
                .collect(Collectors.toList())
        );

        outputView.printWinningNumbersGuide();
        String winningNumbers = inputView.inputString();
        outputView.printBonusBallGuide();
        int bonusBall = inputView.inputInt();

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusBall);
        noticeResult(winningLotto, lottoTickets);
    }

    private static LottoPair buyLottos() {
        outputView.printGameGuide();
        Money money = new Money(inputView.inputInt());
        inputView.inputString();

        LottoStore lottoStore = new LottoStore(money);
        LottoPair lottoPair = new LottoPair(buyManualLottos(lottoStore), lottoStore.buyAutoLottos(new LottoNumberGenerator()));
        outputView.printLottoCount(lottoPair.getManualLottoSize(), lottoPair.getAutoLottoSize());

        return lottoPair;
    }

    private static List<LottoTicket> buyManualLottos(LottoStore lottoStore) {
        outputView.printManualLottoCount();
        Quantity manualLottoCount = new Quantity(inputView.inputInt());
        inputView.inputString();

        outputView.printManualLottoNumbers();
        List<String> manualLottoNumbers = LongStream.range(0, manualLottoCount.getValue())
            .mapToObj(value -> inputView.inputString())
            .collect(Collectors.toList());

        return lottoStore.buyManualLottos(manualLottoNumbers);
    }

    private static void noticeResult(WinningLotto winningLotto, LottoPair lottoPair) {
        LottoGame lottoGame = new LottoGame(winningLotto, lottoPair);
        outputView.printStatistics(lottoGame.getRank());
        outputView.printRevenue(lottoGame.calculateRevenue());
    }
}
