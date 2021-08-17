package logback.ch04;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppenderTest {
	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger("logback.ch04");

		// LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
		// StatusPrinter.print(lc);
		logger.debug("test");
		logger.error("error!!!!!!");
	}
}
