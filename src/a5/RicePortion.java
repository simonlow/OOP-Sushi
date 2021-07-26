package a5;

public class RicePortion implements IngredientPortion {
	private double _amount; 
	private Ingredient ric;
	
	public RicePortion (double amount) {
		if (amount < 0 )
			throw new IllegalArgumentException("amount cannot be negative");
		else 
			_amount = amount; 
		ric = new Rice();
			
	}
	public Ingredient getIngredient() {
		return ric;
	}
	public double getAmount() {
		return _amount;
	}
	public String getName() {
		return ric.getName();
	}
	public boolean getIsVegetarian() {
		return ric.getIsVegetarian();
	}
	public boolean getIsRice() {
		return ric.getIsRice();
	}
	public boolean getIsShellfish() {
		return ric.getIsShellfish();
	}
	public double getCalories() {
		return ric.getCaloriesPerOunce()*_amount;
	}
	public double getCost() {
		return ric.getPricePerOunce()*_amount;
	}
	
	public IngredientPortion combine(IngredientPortion other) {
		if (other == null)
			return this;
		else if ( !other.getIngredient().equals(this.getIngredient()) )
			throw new IllegalArgumentException("Ingredients must be the same");
		else {
			double namount = _amount + other.getAmount();
			return new RicePortion(namount);
		}
	}
}
