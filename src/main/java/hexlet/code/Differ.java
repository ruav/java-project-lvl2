package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Differ {

    private static final ObjectMapper MAPPER = new ObjectMapper();


    public static String generate(String filepath1, String filepath2) throws IOException {
        return generate(filepath1, filepath2, "stylish");
    }

    public static String generate(String filepath1, String filepath2, String format) throws IOException {
        Map<String, Object> file1 = Parser.parseFileToMap(new File(filepath1));
        Map<String, Object> file2 = Parser.parseFileToMap(new File(filepath2));

        List<String> keys = new ArrayList<>(new HashSet<>() {{
            addAll(file1.keySet());
            addAll(file2.keySet());
        }});
        keys.sort(String::compareTo);

        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (String key : keys) {
            String value1 = file1.containsKey(key) ? file1.get(key).toString() : null;
            String value2 = file2.containsKey(key) ? file2.get(key).toString() : null;
            checkAndWriteValues(sb, key, value1, value2);
        }
        sb.append("\n}");
        return sb.toString();
    }

    private static void checkAndWriteValues(StringBuilder sb, String key, String value1, String value2) {
        if (value1 != null && value1.equals(value2)) {
            addValue(sb, " ", key, value1);
        } else {
            if (value1 != null) {
                addValue(sb, "-", key, value1);
            }
            if (value2 != null) {
                addValue(sb, "+", key, value2);
            }
        }
    }

    private static void addValue(StringBuilder sb, String sign, String key, String value) {
        sb.append(String.format("\n  %s %s: %s", sign, key, value));
//        sb.append("\n\t").append(sign).append(" ").append(key).append(": ").append(value);
    }

}
