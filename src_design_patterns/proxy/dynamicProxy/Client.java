package proxy.dynamicProxy;

import java.lang.reflect.Proxy;

public class Client {
	public static void main(String[] args) {
		Star realStar = new RealStar();
		StarHandler sh = new StarHandler(realStar);
		Star proxy = (Star) Proxy.newProxyInstance(
				ClassLoader.getSystemClassLoader(), new Class[] {Star.class}, sh);
		proxy.sing();
		
	}
}
