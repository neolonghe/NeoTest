package adapter;
/**
 * 适配器（对象适配器方式，使用了组合的方式跟被适配对象整合）
 * @author 83960
 *
 */
public class Adapter2 implements Target{
	private Adaptee ap;
	
	public Adapter2(Adaptee ap) {
		this.ap = ap;
	}
	
	@Override
	public void handReq() {
		ap.request();
	}
	
}
