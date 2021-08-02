package modernJavaInAction.ch17;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class TempSubscription implements Subscription {

	private final Subscriber<? super TempInfo> subscriber;
	private final String town;
	private static final ExecutorService executor = Executors.newSingleThreadExecutor();

	public TempSubscription(Subscriber<? super TempInfo> subscriber, String town) {
		super();
		this.subscriber = subscriber;
		this.town = town;
	}

	@Override
	public void request(long n) {
		// avoid stack overflow by using another thread
		executor.submit(() -> {
			for (long i = 0L; i < n; i++) {

				try {
					subscriber.onNext(TempInfo.fetch(town));
				} catch (Exception e) {
					subscriber.onError(e);
					break;
				}
			}
		});
	}

	@Override
	public void cancel() {
		// TODO Auto-generated method stub
		subscriber.onComplete();

	}

}
