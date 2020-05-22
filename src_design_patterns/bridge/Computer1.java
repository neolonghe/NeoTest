package bridge;
/**
 * 电脑类型维度
 * @author 83960
 *
 */
public class Computer1 {
	private Brand brand;

	public Computer1(Brand brand) {
		super();
		this.brand = brand;
	}
	
	public void sale() {
		this.brand.sale();
	}
}

class Desktop1 extends Computer1{
	public Desktop1(Brand brand) {
		super(brand);
	}
	
	@Override
	public void sale() {
		super.sale();
		System.out.println("销售一台台式机电脑。");
	}
}

class Laptop1 extends Computer1{
	public Laptop1(Brand brand) {
		super(brand);
	}
	
	@Override
	public void sale() {
		super.sale();
		System.out.println("销售一台笔记本脑。");
	}
}

// 需要增加电脑类型只需要在此实现
class Pad1 extends Computer1{
	public Pad1(Brand brand) {
		super(brand);
	}
	
	@Override
	public void sale() {
		super.sale();
		System.out.println("销售一台Pad。");
	}
}