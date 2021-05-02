package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {

    private static final String DIFF_RESULT = "{\n" +
            "  - follow: false\n" +
            "    host: hexlet.io\n" +
            "  - proxy: 123.234.53.22\n" +
            "  - timeout: 50\n" +
            "  + timeout: 20\n" +
            "  + verbose: true\n" +
            "}";

    @Test
    void diffJson() throws IOException {

        String path1 = "src/test/resources/json1.json";
        String path2 = "src/test/resources/json2.json";

        assertEquals(DIFF_RESULT, Differ.generate(path1, path2));
    }

    @Test
    void diffYaml() throws IOException {

        String path1 = "src/test/resources/yml1.yml";
        String path2 = "src/test/resources/yml2.yml";

        assertEquals(DIFF_RESULT, Differ.generate(path1, path2));
    }
}