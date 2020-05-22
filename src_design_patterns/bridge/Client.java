package bridge;

public class Client {

	public static void main(String[] args) {
		//销售联想的笔记本电脑
		Computer1 c = new Laptop1(new Lenovo());
		c.sale();

		// 销售神舟的台式机
		Computer1 c2 = new Desktop1(new ShenZhou());
		c2.sale();

	}

}
