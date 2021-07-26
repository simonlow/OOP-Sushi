package a5;

public class Tuna  implements Ingredient{
	String name; 
	double price;
	int calories;
	boolean veg;
	boolean rice;
	boolean shellfish;
	
	public Tuna() {
		name = "tuna";
		price = 1.67;
		calories = 42;
		veg = false;
		rice = false;
		shellfish = false; 
	}
	public String getName() {
		return name;
	}
	public double getCaloriesPerDollar() {
		return (double)calories* (1.0/price);
	}
	public int getCaloriesPerOunce() {
		return calories;
	}
	public double getPricePerOunce() {
		return price;
	}
	public boolean getIsVegetarian() {
		return veg;
	}
	public boolean getIsRice() {
		return rice;
	}
	public boolean getIsShellfish() {
		return shellfish;
	}
	public boolean equals(Ingredient other) {
		if (other == null) 
			throw new IllegalArgumentException("ingredient cannot be null");
		else if (!name.contentEquals(other.getName()))
			return false;
		else if (calories != other.getCaloriesPerOunce())
			return false;
		else if ( Math.abs(price - other.getPricePerOunce()) > 1)
			return false;
		else if (veg != other.getIsVegetarian() || rice != other.getIsRice() || shellfish != other.getIsShellfish()) 
			return false;
		else 
			return true;
		
	}

}
