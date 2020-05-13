package adapter;

/**
 * 适配器（继承方式适配,即类适配器方式）
 * @author 83960
 *
 */
public class Adapter extends Adaptee implements Target{

	@Override
	public void handReq() {
		super.request(); // 具有父类方法，直接调用
	}
	
}
