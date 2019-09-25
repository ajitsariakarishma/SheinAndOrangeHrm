package New_Project_Practice.project1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class LoadProperty {

    static Properties props;
    static FileInputStream input;

    public String getProperty(String key) {
        props = new Properties();
        try {
            input = new FileInputStream("C:\\dev\\Practice\\src\\main\\java\\Resources\\Browser\\testDataConfig.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            props.load(input);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return props.getProperty(key);
    }
}
