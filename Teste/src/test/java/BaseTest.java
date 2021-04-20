import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.testng.annotations.BeforeSuite;

public class BaseTest {

	protected String url = "http://localhost:3000/api/v1/";

	public BaseTest() {
		super();
	}

	@BeforeSuite
	public void init() {
		
		String value = System.getProperty("env");
		if (value == null) {
			value = "local";
		}
		
		
		InputStream stream = this.getClass().getClassLoader().getResourceAsStream("config-" + value + ".properties");
		
		try (stream) {
	
	        Properties prop = new Properties();
	        prop.load(stream);
	
	        url = prop.getProperty("url", "localhost");
	
	        System.out.println(prop);
	
	    } catch (IOException io) {
	        io.printStackTrace();
	    }
	}

}