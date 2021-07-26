package a5;

public class TunaPortion  implements IngredientPortion {
	private double _amount; 
	private Ingredient tun;
	
	public TunaPortion (double amount) {
		if (amount < 0 )
			throw new IllegalArgumentException("amount cannot be negative");
		else 
			_amount = amount; 
		tun = new Tuna();
			
	}
	public Ingredient getIngredient() {
		return tun;
	}
	public double getAmount() {
		return _amount;
	}
	public String getName() {
		return tun.getName();
	}
	public boolean getIsVegetarian() {
		return tun.getIsVegetarian();
	}
	public boolean getIsRice() {
		return tun.getIsRice();
	}
	public boolean getIsShellfish() {
		return tun.getIsShellfish();
	}
	public double getCalories() {
		return tun.getCaloriesPerOunce()*_amount;
	}
	public double getCost() {
		return tun.getPricePerOunce()*_amount;
	}
	
	public IngredientPortion combine(IngredientPortion other) {
		if (other == null)
			return this;
		else if ( !other.getIngredient().equals(this.getIngredient()) )
			throw new IllegalArgumentException("Ingredients must be the same");
		else {
			double namount = _amount + other.getAmount();
			return new TunaPortion(namount);
		}
	}

}
