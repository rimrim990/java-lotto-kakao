public class LottoMain {

    public static void main(String[] args) {
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

        LottoTicket lottoTicket = new LottoTicket(lottoNumberGenerator.generateNumbers());
    }
}
