package a5;

public class EelPortion implements IngredientPortion {
	
	private double _amount; 
	private Ingredient eel;
	
	public EelPortion (double amount) {
		if (amount < 0 )
			throw new IllegalArgumentException("amount cannot be negative");
		else 
			_amount = amount; 
		eel = new Eel();
			
	}
	public Ingredient getIngredient() {
		return eel;
	}
	public double getAmount() {
		return _amount;
	}
	public String getName() {
		return eel.getName();
	}
	public boolean getIsVegetarian() {
		return eel.getIsVegetarian();
	}
	public boolean getIsRice() {
		return eel.getIsRice();
	}
	public boolean getIsShellfish() {
		return eel.getIsShellfish();
	}
	public double getCalories() {
		return eel.getCaloriesPerOunce()*_amount;
	}
	public double getCost() {
		return eel.getPricePerOunce()*_amount;
	}
	
	public IngredientPortion combine(IngredientPortion other) {
		if (other == null)
			return this;
		else if ( !other.getIngredient().equals(this.getIngredient()) )
			throw new IllegalArgumentException("Ingredients must be the same");
		else {
			double namount = _amount + other.getAmount();
			return new EelPortion(namount);
		}
	}
}
