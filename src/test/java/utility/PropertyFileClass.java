package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileClass {
	public Properties properties;
	public PropertyFileClass()
	{
		properties=new Properties();
		File file=new File(System.getProperty("user.dir")+"\\TestData\\config-credentials.properties");
		try {
			FileInputStream fileInputStream=new FileInputStream(file);
			properties.load(fileInputStream);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public String readData(String key)
	{
		return properties.getProperty(key);
	}

}
