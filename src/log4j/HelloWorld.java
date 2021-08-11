package log4j;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class HelloWorld {
	static Logger logger = Logger.getLogger("hello");

	public static void main(String[] args) {
		BasicConfigurator.configure();
		for (int i = 0; i < 100; i++) {
			logger.debug("hello world");
		}
	}
}
