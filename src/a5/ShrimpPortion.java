package a5;

public class ShrimpPortion  implements IngredientPortion {
	private double _amount; 
	private Ingredient shrim;
	
	public ShrimpPortion (double amount) {
		if (amount < 0 )
			throw new IllegalArgumentException("amount cannot be negative");
		else 
			_amount = amount; 
		shrim = new Shrimp();
			
	}
	public Ingredient getIngredient() {
		return shrim;
	}
	public double getAmount() {
		return _amount;
	}
	public String getName() {
		return shrim.getName();
	}
	public boolean getIsVegetarian() {
		return shrim.getIsVegetarian();
	}
	public boolean getIsRice() {
		return shrim.getIsRice();
	}
	public boolean getIsShellfish() {
		return shrim.getIsShellfish();
	}
	public double getCalories() {
		return shrim.getCaloriesPerOunce()*_amount;
	}
	public double getCost() {
		return shrim.getPricePerOunce()*_amount;
	}
	
	public IngredientPortion combine(IngredientPortion other) {
		if (other == null)
			return this;
		else if ( !other.getIngredient().equals(this.getIngredient()) )
			throw new IllegalArgumentException("Ingredients must be the same");
		else {
			double namount = _amount + other.getAmount();
			return new ShrimpPortion(namount);
		}
	}

}
