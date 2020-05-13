package proxy.staticProxy;
/**
 * 测试类
 * @author 83960
 *
 */
public class Client {
	public static void main(String[] args) {
		Star realStar = new RealStar();
		Star proxy = new ProxyStar(realStar);
		proxy.confer();
		proxy.signContract();
		proxy.bookTickets();
		proxy.sing();
		proxy.collect();
		return;
	}
}
