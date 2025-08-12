public class LogLine {
   private final String message;

    public LogLine(String message) {
        this.message = message;
    }

    public LogLevel getLogLevel() {
        String code = message.substring(1, 4); // Extrait "TRC", "DBG", etc.
        return LogLevel.fromCode(code);
    }

    public String getOutputForShortLog() {
        LogLevel level = getLogLevel();
        String cleanMessage = message.substring(message.indexOf("]:") + 2).trim();
        return level.getEncodedValue() + ":" + cleanMessage;
    }
}
