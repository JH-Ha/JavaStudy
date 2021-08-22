package logback.ch05;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EncoderTest {
	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger("logback.ch05");
		logger.info("test");
	}
}
