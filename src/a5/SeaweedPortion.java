package a5;

public class SeaweedPortion  implements IngredientPortion {
	private double _amount; 
	private Ingredient seaw;
	
	public SeaweedPortion (double amount) {
		if (amount < 0 )
			throw new IllegalArgumentException("amount cannot be negative");
		else 
			_amount = amount; 
		seaw = new Seaweed();
			
	}
	public Ingredient getIngredient() {
		return seaw;
	}
	public double getAmount() {
		return _amount;
	}
	public String getName() {
		return seaw.getName();
	}
	public boolean getIsVegetarian() {
		return seaw.getIsVegetarian();
	}
	public boolean getIsRice() {
		return seaw.getIsRice();
	}
	public boolean getIsShellfish() {
		return seaw.getIsShellfish();
	}
	public double getCalories() {
		return seaw.getCaloriesPerOunce()*_amount;
	}
	public double getCost() {
		return seaw.getPricePerOunce()*_amount;
	}
	
	public IngredientPortion combine(IngredientPortion other) {
		if (other == null)
			return this;
		else if ( !other.getIngredient().equals(this.getIngredient()) )
			throw new IllegalArgumentException("Ingredients must be the same");
		else {
			double namount = _amount + other.getAmount();
			return new SeaweedPortion(namount);
		}
	}
}

