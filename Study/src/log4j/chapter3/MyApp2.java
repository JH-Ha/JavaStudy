package log4j.chapter3;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class MyApp2 {
	final static Logger logger = Logger.getLogger(MyApp2.class);

	public static void main(String[] args) {

		PropertyConfigurator.configure("./src/log4j/chapter3/config.txt");
		logger.info("Entering application.");
		Foo foo = new Foo();
		foo.doIt();
		logger.info("Exiting application.");
	}
}
