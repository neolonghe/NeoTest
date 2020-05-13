package adapter;

/**
 * 客户端类
 * @author 83960
 *
 */
public class Client {
	public void test(Target t) {
		t.handReq();
	}
	
	public static void main(String[] args) {
		Client c = new Client();
		Target t = new Adapter();
		c.test(t);
		
		Adaptee at = new Adaptee();
		Target t2 = new Adapter2(at);
		c.test(t2);
		
		return;
	}
}
