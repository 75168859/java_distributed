package thread;

import java.util.Properties;

public class ServiceFactory {
	private static Properties prop = new Properties();
	static{
		try {
			prop.load(ServiceFactory.class.getResourceAsStream("/thread/aa.properties"));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static Service getInstance(){
		//return new ServiceImp();
		//return new ServiceProxy();
		try {
			return (Service)Class.forName(prop.getProperty("service")).newInstance();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
}
