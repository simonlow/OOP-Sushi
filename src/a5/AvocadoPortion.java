package a5;

public class AvocadoPortion implements IngredientPortion {
	
	private double _amount; 
	private Ingredient av;
	
	public AvocadoPortion (double amount) {
		if (amount < 0 )
			throw new IllegalArgumentException("amount cannot be negative");
		else 
			_amount = amount; 
		av = new Avocado();
			
	}
	public Ingredient getIngredient() {
		return av;
	}
	public double getAmount() {
		return _amount;
	}
	public String getName() {
		return av.getName();
	}
	public boolean getIsVegetarian() {
		return av.getIsVegetarian();
	}
	public boolean getIsRice() {
		return av.getIsRice();
	}
	public boolean getIsShellfish() {
		return av.getIsShellfish();
	}
	public double getCalories() {
		return av.getCaloriesPerOunce()*_amount;
	}
	public double getCost() {
		return av.getPricePerOunce()*_amount;
	}
	
	public IngredientPortion combine(IngredientPortion other) {
		if (other == null)
			return this;
		else if ( !other.getIngredient().equals(this.getIngredient()) )
			throw new IllegalArgumentException("Ingredients must be the same");
		else {
			double namount = _amount + other.getAmount();
			return new AvocadoPortion(namount);
		}
	}
}
