package nenad.dikic;

import org.json.JSONObject;


public class Berry {

	private String name;
	private int size;
	private int growthTime;

	public Berry(String bName, int bSize, int bGrowthTime) {
		this.name = bName;
		this.size = bSize;
		this.growthTime = bGrowthTime;
	}

	public Berry(JSONObject object) {
		this(object.getString("name"), object.getInt("size"), object.getInt("growth_time"));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getGrowthTime() {
		return growthTime;
	}

	public void setGrowthTime(int growthTime) {
		this.growthTime = growthTime;
	}
}
