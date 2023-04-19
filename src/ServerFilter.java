import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;

public class ServerFilter extends Filter {

    @Override
    public int decide(LoggingEvent event) {
        if (event.getLoggerName().equals("Version")) {
            return Filter.DENY;
        }
        return Filter.NEUTRAL;
    }
}