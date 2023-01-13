import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseClass {

    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        FileInputStream filePath = new FileInputStream("resources\\config.properties");
        prop.load(filePath);
        System.out.println("User dir" + prop.getProperty("dir.user"));
    }
}
