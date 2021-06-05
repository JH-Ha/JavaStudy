package object.ch2;

public class SequenceCondition implements DiscountCondition {
	private int sequence;

	public SequenceCondition(int sequence) {
		this.sequence = sequence;
	}

	@Override
	public boolean isSatisfiedBy(Screening screening) {
		// TODO Auto-generated method stub
		return screening.isSequence(sequence);
	}

}
