package nenad.dikic;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BerryLauncher {

	public static void main(String[] args) throws IOException {
		List<Berry> berries = ApiBerry.getAllBerries();
		System.out.println(getFinalResult(berries));
	}

	public static String getFinalResult(List<Berry> bList) {
		
		Collections.sort(bList, Comparator.comparing(Berry::getGrowthTime).reversed().thenComparing(Berry::getSize));
		Berry bBig = bList.get(bList.size() - 1);
		return "Biggest and fastest growing berry is:\n" + bBig.getName() + " (size: " + bBig.getSize()
					 + ", growth time: " + bBig.getGrowthTime() + ").";
	}
}
