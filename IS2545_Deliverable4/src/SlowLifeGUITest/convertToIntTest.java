package SlowLifeGUITest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import static org.junit.Assert.*;
import org.junit.Test;

import SlowLifeGUI.MainPanel;

public class convertToIntTest {
	
	//Since the convertToInt() method is private, reflection is needed here to do the test.
	//This test creates a 15*15 world.
	//This test assumes that the input x is 6.
	//The return values of the original method and modified method should be the same.
	@Test
	public void convertToIntTest1() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException{
		MainPanel mp = new MainPanel(15);
		Method con1 = MainPanel.class.getDeclaredMethod("convertToInt", int.class);
		con1.setAccessible(true);
		int original = (int)con1.invoke(mp, 6);
		Method con2 = MainPanel.class.getDeclaredMethod("convertToIntModified", int.class);
		con2.setAccessible(true);
		int modified = (int)con2.invoke(mp, 6);
		assertEquals(original, modified);
	}
	
	//This test creates a 10*10 world.
	//Since the modified method returns the input value
	//Return values of the two mwthods should be different if they have different input value
	//This test assumes that the two methods have different input
	//The return values of the two methods should not be the same.
	@Test
	public void convertToIntTest2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException{
		MainPanel mp = new MainPanel(10);
		Method con1 = MainPanel.class.getDeclaredMethod("convertToInt", int.class);
		con1.setAccessible(true);
		int original = (int)con1.invoke(mp, 6);
		Method con2 = MainPanel.class.getDeclaredMethod("convertToIntModified", int.class);
		con2.setAccessible(true);
		int modified = (int)con2.invoke(mp, 7);
		assertNotSame(original, modified);
	}
	
	//Since method getNumNeighbors() calls the method convertToInt()
	//We have to test getNumNeighbors() as well.
	//This test assumes that the input x is 5 and input y is 7.
	//The return value should be the same.
	@Test
	public void convertToIntTest3() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException{
		MainPanel mp = new MainPanel(15);
		Method getNum1 = MainPanel.class.getDeclaredMethod("getNumNeighbors", int.class, int.class);
		getNum1.setAccessible(true);		
		int original = (int)getNum1.invoke(mp, 5, 7);
		Method getNum2 = MainPanel.class.getDeclaredMethod("getNumNeighbors", int.class, int.class);
		getNum2.setAccessible(true);
		int modified = (int)getNum1.invoke(mp, 5, 7);
		assertEquals(original, modified);	
	}
		
}
