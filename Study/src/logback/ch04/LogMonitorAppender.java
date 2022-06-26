package logback.ch04;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;

public class LogMonitorAppender extends AppenderBase<ILoggingEvent> {

	@Override
	protected void append(ILoggingEvent event) {
		if (event != null && event.getMessage() != null && Level.ERROR.equals(event.getLevel())) {
			// ���⼭ �����ڿ��� ������ �����ų� Ư�� ó���ϴ� �ڵ带 �ۼ�
			System.out.println("error!!!");
			System.out.println(event.getMessage());
		}
	}

}
