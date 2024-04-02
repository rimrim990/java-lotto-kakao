public class WinningLotto {

    private LottoTicket winningLottoTicket;
    private LottoNumber bonusNumber;

    public WinningLotto(LottoTicket winningLottoTicket, LottoNumber bonusNumber) {
        validateNotDuplicated(winningLottoTicket, bonusNumber);

        this.winningLottoTicket = winningLottoTicket;
        this.bonusNumber = bonusNumber;
    }

    private void validateNotDuplicated(LottoTicket winningLottoTicket, LottoNumber bonusNumber) {
        if (winningLottoTicket.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 로또 번호와 중복될 수 없습니다.");
        }
    }

    public long calculatePrize(LottoTicket lottoTicket) {
        return winningLottoTicket.compare(lottoTicket);
    }
}
