package a5;

public class YellowtailPortion  implements IngredientPortion {
	private double _amount; 
	private Ingredient yel;
	
	public YellowtailPortion (double amount) {
		if (amount < 0 )
			throw new IllegalArgumentException("amount cannot be negative");
		else 
			_amount = amount; 
		yel = new Yellowtail();
			
	}
	public Ingredient getIngredient() {
		return yel;
	}
	public double getAmount() {
		return _amount;
	}
	public String getName() {
		return yel.getName();
	}
	public boolean getIsVegetarian() {
		return yel.getIsVegetarian();
	}
	public boolean getIsRice() {
		return yel.getIsRice();
	}
	public boolean getIsShellfish() {
		return yel.getIsShellfish();
	}
	public double getCalories() {
		return yel.getCaloriesPerOunce()*_amount;
	}
	public double getCost() {
		return yel.getPricePerOunce()*_amount;
	}
	
	public IngredientPortion combine(IngredientPortion other) {
		if (other == null)
			return this;
		else if ( !other.getIngredient().equals(this.getIngredient()) )
			throw new IllegalArgumentException("Ingredients must be the same");
		else {
			double namount = _amount + other.getAmount();
			return new YellowtailPortion(namount);
		}
	}

}
