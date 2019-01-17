public class AdderTest{
	public static void main(String[] args) {
		Adder a = new Adder();
		a.add(1);
		a.add(10);
		a.add(5);
		System.out.println(a.getVal());
		a.add(2);
		a.add(20);
		System.out.println(a.getVal());
		a.reset();
		System.out.println(a.getVal());
	}
}