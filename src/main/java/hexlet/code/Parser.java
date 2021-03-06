package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Parser {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final ObjectMapper YAML_MAPPER = new ObjectMapper(new YAMLFactory());

    private static final String YAML = "yml";
    private static final String JSON = "json";

    public static ObjectMapper getMapper(String path) {
        ObjectMapper mapper = null;
        if (path.endsWith(JSON)) {
            mapper = MAPPER;
        }
        if (path.endsWith(YAML)) {
            mapper = YAML_MAPPER;
        }
        return mapper;
    }

    public static Map<String, Object> parseFileToMap(File file) throws IOException {
        return getMapper(file.getPath()).readValue(file, Map.class);
    }

}
