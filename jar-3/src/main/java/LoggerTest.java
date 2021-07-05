import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerTest {
    private static final Logger logger = LoggerFactory.getLogger(LoggerTest.class);
    public static void main(String[] args) {
        logger.info("info 3");
        logger.warn("warn 3");
        logger.error("error 3");
    }

    public static void fun(){
        logger.info("info 3");
        logger.warn("warn 3");
        logger.error("error 3");
    }
}
