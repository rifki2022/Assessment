package Resources;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utils{
	
	public static String getGlobalProperty(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\AD-078\\Downloads\\API_Assignment-main\\API_Assignment-main\\src\\resources");
		prop.load(file);
		return prop.getProperty(key);
	}

}
