package ua.com.lits.automation.java.framework.utility;

import java.io.FileReader;
import java.io.InputStream;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.StatusPrinter;

public class LogFactory {
	private static LoggerContext factory = (LoggerContext) LoggerFactory
			.getILoggerFactory();
	private static Logger logger;
	
	static {
		try {
			init(FileReader.class.getResourceAsStream("/logback.xml"));			
		}catch(IllegalArgumentException e) {
			System.err.println("failed to load logging configuration from logback.xml");
			e.printStackTrace(System.err);
			throw new RuntimeException("no file logback in resurces foulder found", e);			
		}
	}
	
	public static void init (InputStream logParams){
		try {
			JoranConfigurator configurator = new JoranConfigurator();
			configurator.setContext(factory);
			if(logParams != null){
				factory.reset();
				configurator.doConfigure(logParams);
			}
			} catch(JoranException je){
				je.printStackTrace();
		}
		StatusPrinter.printIfErrorsOccured(factory);
		logger = getLogger(LogFactory.class);
		logger.info("-------------------------Initializing logger-------------------------");
		logger.info("Logging (re-)initalized");
		logger.info("JVM timezone: {}", TimeZone.getDefault().getID());		
	}
	public static  Logger getLogger(@SuppressWarnings("rawtypes") Class clazz) {
		return LoggerFactory.getLogger(clazz);
	}

}
