package constants;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogImplementation {
    public static final Logger log = LogManager.getLogger(LogImplementation.class.getName());

    private LogImplementation() {

    }

    public static void info(String message) {

        log.info(message);

    }

    public static void warn(String message) {

        log.warn(message);

    }

    public static void error(String message) {

        log.error(message);

    }

    public static void fatal(String message) {

        log.fatal(message);

    }

    public static void debug(String message) {

        log.debug(message);

    }

}
