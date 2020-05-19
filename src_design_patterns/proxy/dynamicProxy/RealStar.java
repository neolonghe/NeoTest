package proxy.dynamicProxy;

public class RealStar implements Star {

	@Override
	public void confer() {
		System.out.println("RealStar.confer()");
	}

	@Override
	public void signContract() {
		System.out.println("RealStar.signContract()");
	}

	@Override
	public void bookTickets() {
		System.out.println("RealStar.bookTickets()");
	}

	@Override
	public void sing() {
		System.out.println("RealStar_周杰伦.sing()");
	}

	@Override
	public void collect() {
		System.out.println("RealStar.collect()");
	}

}
