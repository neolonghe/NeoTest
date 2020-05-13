package proxy.staticProxy;

public class ProxyStar implements Star {
	private Star star;
	
	public ProxyStar(Star star) {
		super();
		this.star = star;
	}
	
	@Override
	public void confer() {
		System.out.println("ProxyStar.confer()");
	}

	@Override
	public void signContract() {
		System.out.println("ProxyStar.signContract()");
	}

	@Override
	public void bookTickets() {
		System.out.println("ProxyStar.bookTickets()");
	}

	@Override
	public void sing() {
		star.sing();
	}

	@Override
	public void collect() {
		System.out.println("ProxyStar.collect()");
	}

}
