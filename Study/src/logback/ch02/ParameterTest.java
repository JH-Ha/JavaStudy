package logback.ch02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterTest {
	public static void main(String[] args) {
		Logger logger = LoggerFactory.getLogger(ParameterTest.class);
		logger.debug("My number is {}", 10);
	}
}
