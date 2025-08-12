public class LogLevels {
    
    public static String message(String logLine) {
        return logLine.split(": ", 2)[1].trim();
    }

    public static String logLevel(String logLine) {
        int start = logLine.indexOf('[') +1;
        int end = logLine.indexOf(']');
        String level = logLine.substring(start, end);
        return level.toLowerCase();
    }

    public static String reformat(String logLine) {
        String message = message(logLine);
        String capitalizedMessage = message.substring(0, 1).toUpperCase() + message.substring(1);
        String level = logLevel(logLine);
        return capitalizedMessage + " (" + level + ")";
    }
}
