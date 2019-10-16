package nenad.dikic;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import nenad.dikic.ApiBerry;
import nenad.dikic.Berry;
import nenad.dikic.BerryLauncher;

public class BerryTest {

	@Test
	public void testGetFinalResult() throws IOException {
		ArrayList<Berry> bList = new ArrayList<Berry>();
		bList.add(new Berry("b1", 88, 4));
		bList.add(new Berry("b2", 55, 6));
		bList.add(new Berry("b3", 16, 4));

		assertEquals(true, BerryLauncher.getFinalResult(bList).contains("b1"));
	}

	@Test
	public void testCorrectResult() throws IOException {
		assertEquals(64, ApiBerry.getBerriesCount());
	}

	@Test
	public void testSize() throws IOException {
		assertEquals(ApiBerry.getBerriesCount(), ApiBerry.getAllBerries().size());
	}

	@Test
	public void testName() throws IOException {
		assertEquals(true, ApiBerry.getAllBerriesLink().get(1).toString().contains("chesto"));

	}
	
}