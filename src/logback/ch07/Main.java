package logback.ch07;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger("STDOUT");
		logger.debug("test");
		logger.debug("sample");
		logger.info("sample info");
		logger.trace("sample trace");
	}
}
