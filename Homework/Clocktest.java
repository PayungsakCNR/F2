public class Clocktest{
	public static void main(String args[]){
		Clock c = new Clock(12,35);

		c.pressCenter(true);
		c.pressUp(); //(13,35)
		c.pressCenter(false);
		c.pressUp(); //(13,36)
		c.pressUp(); //(13,37)
		c.pressUp(); //(13,38)
		c.pressUp(); //(13,39)
		c.pressUp(); //(13,40)
		c.pressCenter(true);
	}
}