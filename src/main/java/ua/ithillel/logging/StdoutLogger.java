package ua.ithillel.logging;

public class StdoutLogger extends AbstractLogger {

    protected StdoutLogger(LogLevel level) {
        super(level);
    }

    @Override
    protected void log(String formattedMessage) {
        System.out.println(formattedMessage);
    }

    public static void main(String[] args) {
        new StdoutLogger(LogLevel.DEBUG).debug("output");
    }
}
