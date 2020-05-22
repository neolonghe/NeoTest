package bridge;

/**
 * 品牌
 * @author 83960
 *
 */
public interface Brand {
	void sale();
}

class Lenovo implements Brand {
	@Override
	public void sale() {
		System.out.println("销售一台联想电脑。");
	}
}

class Dell implements Brand {
	@Override
	public void sale() {
		System.out.println("销售一台戴尔电脑。");
	}
}

// 需要新增电脑只需要在此添加即可
class ShenZhou implements Brand {
	@Override
	public void sale() {
		System.out.println("销售一台神州电脑。");
	}
}
