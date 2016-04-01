package proxy;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonServiceImpl ps = new PersonServiceImpl();
		ProxyFactoryBean pfb = new ProxyFactoryBean();
		pfb.setTarget(ps);
		PersonService pproxy = (PersonService)pfb.getProxy();
		pproxy.update();

	}

}
