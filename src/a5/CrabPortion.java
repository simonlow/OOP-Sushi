package a5;

public class CrabPortion implements IngredientPortion {
	private double _amount; 
	private Ingredient cra;
	
	public CrabPortion (double amount) {
		if (amount < 0 )
			throw new IllegalArgumentException("amount cannot be negative");
		else 
			_amount = amount; 
		cra = new Crab();
			
	}
	public Ingredient getIngredient() {
		return cra;
	}
	public double getAmount() {
		return _amount;
	}
	public String getName() {
		return cra.getName();
	}
	public boolean getIsVegetarian() {
		return cra.getIsVegetarian();
	}
	public boolean getIsRice() {
		return cra.getIsRice();
	}
	public boolean getIsShellfish() {
		return cra.getIsShellfish();
	}
	public double getCalories() {
		return cra.getCaloriesPerOunce()*_amount;
	}
	public double getCost() {
		return cra.getPricePerOunce()*_amount;
	}
	
	public IngredientPortion combine(IngredientPortion other) {
		if (other == null)
			return this;
		else if ( !other.getIngredient().equals(this.getIngredient()) )
			throw new IllegalArgumentException("Ingredients must be the same");
		else {
			double namount = _amount + other.getAmount();
			return new CrabPortion(namount);
		}
	}
}
