package SlowLifeGUITest;

import static org.junit.Assert.*;
import org.junit.Test;

import SlowLifeGUI.Cell;

public class toStringTest {
	
	//This test assume that a cell is alive.
	//The text should be "X"
	//The original method and the modified method should return the same value.
	@Test
	public void toStringTest1(){
		Cell cell = new Cell();
		cell.setAlive(true);
		String original = cell.toString();
		String modified = cell.toStringModified();
		assertEquals(original, modified);
		System.out.println(original + modified);
	}
	
	//This test assume that a cell is dead
	//The text of the cell should be "."
	//The original method and the modified method should return the same value.
	@Test
	public void toStringTest2(){
		Cell cell = new Cell();
		cell.setAlive(false);
		String original = cell.toString();
		String modified = cell.toStringModified();
		assertEquals(original, modified);
		System.out.println(original + modified);
	}
	
	//This test assume that one cell is alive while another cell is dead.
	//I use the original method to get the text of the alive cell.
	//The text of the alive cell should be "X".
	//I use the modified method to get the text of the dead cell.
	//The text of the dead cell should be ".".
	//Texts of the two cells should be different.
	@Test
	public void toStringTest3(){
		Cell cell1 = new Cell();
		Cell cell2 = new Cell();
		cell1.setAlive(true);
		cell2.setAlive(false);
		String original = cell1.toString();
		String modified = cell2.toStringModified();
		assertNotSame(original, modified);
	}
	
}
