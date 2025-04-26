import java.awt.Font;
import java.util.TreeMap;

public class FontLibrary {
    public static TreeMap<String, Font> uploadFonts() {
        return new TreeMap<String, Font>() {{
            put("baseFont", new Font("Courier New", Font.PLAIN, 20));
            put("titleFont", new Font("Courier New", Font.PLAIN, 65));
            put("subtitleFont", new Font("Courier New", Font.ITALIC, 30));
            put("buttonFont", new Font("Courier New", Font.BOLD, 25));
        }};
    }
}
