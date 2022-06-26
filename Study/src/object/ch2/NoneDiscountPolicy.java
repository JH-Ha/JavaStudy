package object.ch2;

public class NoneDiscountPolicy extends DiscountPolicy {

	@Override
	protected Money getDiscountAmount(Screening screening) {
		// TODO Auto-generated method stub
		return Money.ZERO;
	}

}
