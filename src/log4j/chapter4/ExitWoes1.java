package log4j.chapter4;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.WriterAppender;

public class ExitWoes1 {
	public static void main(String argv[]) throws Exception {
		WriterAppender writerAppender = new WriterAppender();
		writerAppender.setLayout(new SimpleLayout());
		OutputStream os = new FileOutputStream("exitWoes1.log");
		writerAppender.setWriter(new OutputStreamWriter(os));
		writerAppender.setImmediateFlush(false);
		writerAppender.activateOptions();
		Logger logger = Logger.getLogger(ExitWoes1.class);
		logger.addAppender(writerAppender);
		logger.debug("Hello world.");

		LogManager.getLoggerRepository().shutdown();
	}
}
