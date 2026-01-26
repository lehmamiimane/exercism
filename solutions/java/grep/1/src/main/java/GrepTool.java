import java.util.*;
import java.util.regex.*;
import java.nio.file.*;
import java.io.IOException;
class GrepTool {

    String grep(String pattern, List<String> flags, List<String> files) {
        boolean showLineNumbers = flags.contains("-n");
        boolean onlyFilenames = flags.contains("-l");
        boolean ignoreCase = flags.contains("-i");
        boolean invertMatch = flags.contains("-v");
        boolean matchEntireLine = flags.contains("-x");
        boolean multipleFiles = files.size() > 1;

        // Build regex flags
        int regexFlags = Pattern.MULTILINE;
        if (ignoreCase) {
            regexFlags |= Pattern.CASE_INSENSITIVE;
        }

        // Adjust pattern for full line match
        if (matchEntireLine) {
            pattern = "^" + pattern + "$";
        }

        Pattern regex = Pattern.compile(pattern, regexFlags);
        List<String> results = new ArrayList<>();

        for (String file : files) {
            List<String> lines;
            try {
                lines = Files.readAllLines(Path.of(file));
            } catch (IOException e) {
                throw new RuntimeException("Failed to read file: " + file, e);
            }

            boolean fileMatched = false;

            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);
                Matcher matcher = regex.matcher(line);
                boolean matched = matcher.find();
                if (invertMatch) matched = !matched;

                if (matched) {
                    fileMatched = true;
                    if (onlyFilenames) break;

                    StringBuilder resultLine = new StringBuilder();
                    if (multipleFiles) resultLine.append(file).append(":");
                    if (showLineNumbers) resultLine.append(i + 1).append(":");
                    resultLine.append(line);

                    results.add(resultLine.toString());
                }
            }

            if (onlyFilenames && fileMatched) {
                results.add(file);
            }
        }

        return String.join("\n", results);
    }

}