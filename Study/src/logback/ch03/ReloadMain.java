package logback.ch03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReloadMain {
	public static void main(String[] args) throws InterruptedException {
		Logger logger = LoggerFactory.getLogger(ReloadMain.class);
		int i = 0;
		while (i++ < 1000) {
			logger.debug("debug message");
			logger.info("info message");
			Thread.sleep(1000);
		}
	}
}
