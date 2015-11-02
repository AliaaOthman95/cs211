package eg.edu.alexu.csd.oop.calculator;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class test {

	@Test
	public void test() {
		Engine n =  Engine.getInstance();
	/*try {
			n.load();
			Assert.fail("");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("sucsses");
		
		}*/
		n.input("1+2");
		Assert.assertEquals("3.0", n.getResult());
		n.input("5-1");
		Assert.assertEquals("4.0", n.getResult());
		n.input("9*8");
		Assert.assertEquals("72.0", n.getResult());
		n.input("8/4");
		Assert.assertEquals("8/4", n.current());
		Assert.assertEquals("9*8", n.prev());
		Assert.assertEquals("9*8", n.current());
	//	Assert.assertEquals("8/4", n.next());
	Assert.assertEquals("72.0", n.getResult());
		Assert.assertEquals("8/4", n.next());
		Assert.assertEquals("9*8", n.prev());
		Assert.assertEquals("5-1", n.prev());
		Assert.assertEquals("1+2", n.prev());
		Assert.assertEquals(null, n.prev());
		Assert.assertEquals("1+2", n.current());
		Assert.assertEquals("5-1", n.next());
		Assert.assertEquals("9*8", n.next());
		Assert.assertEquals("8/4", n.next());
		Assert.assertEquals(null, n.next());
		n.save();
		n.input("9*4");
		n.input("8-3");
		n.input("5-6");
		n.input("3*2");
		 
		Assert.assertEquals("3*2", n.current());
		Assert.assertEquals("5-6", n.prev());
		Assert.assertEquals("8-3", n.prev());
		Assert.assertEquals("9*4", n.prev());
		Assert.assertEquals("8/4", n.prev());
		 
		Assert.assertEquals(null, n.prev());
		n.load();
		Assert.assertEquals(null, n.next());
		Assert.assertEquals("8/4", n.current());
		Assert.assertEquals("9*8", n.prev());
		Assert.assertEquals("5-1", n.prev());
		Assert.assertEquals("1+2", n.prev());
		Assert.assertEquals(null, n.prev());
		try {
			n.input("9/0");
			n.getResult();
			Assert.fail("");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("sucsses");
		
		}
	
		
	 
	}
	@Test
	public void test2() {
		Engine n =  Engine.getInstance();
		n.input("1+2");
		n.input("5-1");
		n.input("9*8");
		n.input("8/4");
		n.input("5+3");
		n.input("4+2");
		Assert.assertEquals("5+3", n.prev());
		Assert.assertEquals("8/4", n.prev());
		Assert.assertEquals("9*8", n.prev());
		Assert.assertEquals("5-1", n.prev());
		//Assert.assertEquals("1+2", n.prev());
		Assert.assertEquals(null, n.prev());
		//Assert.assertEquals("1+2", n.prev());
		
	
	}
	@Test
	public void test3() {
		Engine n =  Engine.getInstance();
		n.input("1+2");
		n.input("5-1");
		n.input("9*8");
		n.input("8/4");
		n.input("5+3");
		n.input("4+2");
		n.save();
		n.load();
		Assert.assertEquals("4+2", n.current());
		Assert.assertEquals("5+3", n.prev());
		Assert.assertEquals("8/4", n.prev());
		Assert.assertEquals("9*8", n.prev());
		Assert.assertEquals("9*8", n.current());
		Assert.assertEquals("5-1", n.prev());
		Assert.assertEquals(null, n.prev());
		Assert.assertEquals("5-1", n.current());
		//Assert.assertEquals("1+2", n.prev());
		
	
	}
	@Test
	public void test4() {
		Engine n =  Engine.getInstance();
	 n.input("1+1");
	    n.input("2+2");
	    n.input("3+3");
	    n.input("4+4");
	    n.input("5+5");
	    n.input("6+6");
	    n.save();
	    n.load();
	    Assert.assertEquals("6+6", n.current());
	    Assert.assertEquals("5+5", n.prev());
	    Assert.assertEquals("4+4", n.prev());
	    Assert.assertEquals("3+3", n.prev());
	    Assert.assertEquals("2+2", n.prev());
	    Assert.assertEquals(null, n.prev());
	    Assert.assertEquals("2+2", n.current());
	    Assert.assertEquals("3+3", n.next());
	    Assert.assertEquals("4+4", n.next());
	    Assert.assertEquals("5+5", n.next());
	    Assert.assertEquals("6+6", n.next());
	    Assert.assertEquals(null, n.next());
	    Assert.assertEquals("6+6", n.current());  
	    Assert.assertEquals("5+5", n.prev());
	    Assert.assertEquals("4+4", n.prev());
	    Assert.assertEquals("3+3", n.prev());
	    Assert.assertEquals("2+2", n.prev());
         Assert.assertEquals(null, n.prev());
	    n.save();
	    n.load();
	    Assert.assertEquals("2+2", n.current());
	    Assert.assertEquals(null, n.prev());
	    n.input("7+7");
	    n.input("8+8");
	    Assert.assertEquals("8+8", n.current());
	    Assert.assertEquals("7+7", n.prev());
	    Assert.assertEquals(null, n.prev());
	}
	@Before
	public void initialize() {
        Engine.destoryInstance();
}

}
