package a5;

public class Roll {

	private String name;
	private IngredientPortion[] ingredients;
	private double [] portionOunces;
	
	public Roll(String name, IngredientPortion[] roll_ingredients) {
		
		portionOunces = new double[8];
		
		if (name == null)
			throw new IllegalArgumentException("must have name");
		else
			this.name = name;
		if (roll_ingredients == null) 
			throw new IllegalArgumentException("ingredient list can't be null");
		else {
			for (int i = 0; i < roll_ingredients.length; i++) {
				if (roll_ingredients[i] == null)
					throw new IllegalArgumentException("Ingredient cannot be null");
				
			}
		}
		int size = 0;
		for (int i = 0; i < roll_ingredients.length;i++) {
			if (roll_ingredients[i].getName().contentEquals("avocado")) {
				portionOunces[0] += roll_ingredients[i].getAmount();
			}
			else if (roll_ingredients[i].getName().contentEquals("crab")) {
				portionOunces[1] += roll_ingredients[i].getAmount();
			}
			else if (roll_ingredients[i].getName().contentEquals("eel")) {
				portionOunces[2] += roll_ingredients[i].getAmount();
			}
			else if (roll_ingredients[i].getName().contentEquals("rice")) {
				portionOunces[3] += roll_ingredients[i].getAmount();
			}
			else if (roll_ingredients[i].getName().contentEquals("seaweed")) {
				portionOunces[4] += roll_ingredients[i].getAmount();
			}
			else if (roll_ingredients[i].getName().contentEquals("shrimp")) {
				portionOunces[5] += roll_ingredients[i].getAmount();
			}
			else if (roll_ingredients[i].getName().contentEquals("tuna")) {
				portionOunces[6] += roll_ingredients[i].getAmount();
			}
			else if (roll_ingredients[i].getName().contentEquals("yellowtail")) {
				portionOunces[7] += roll_ingredients[i].getAmount();
			}
		}
	
		for (int i = 0; i< 8;i++) {
			if (portionOunces[i] > 0)
				size++;
		}
		if (portionOunces[4] == 0) {
			size++;
			portionOunces[4] = 0.1;
		}
		else if (portionOunces[4] < 0.1){
			portionOunces[4] = 0.1;
		}
			
		ingredients = new IngredientPortion[size];
		
		int index = 0;
		if (portionOunces[0] != 0) {
			ingredients[index] = new AvocadoPortion(portionOunces[0]);
			index++;
		}
		if (portionOunces[1] != 0) {
			ingredients[index] = new CrabPortion(portionOunces[1]);
			index++;
		}
		if (portionOunces[2] != 0) {
			ingredients[index] = new EelPortion(portionOunces[2]);
			index++;
		}
		if (portionOunces[3] != 0) {
			ingredients[index] = new RicePortion(portionOunces[3]);
			index++;
		}
		if (portionOunces[4] != 0) {
			ingredients[index] = new SeaweedPortion(portionOunces[4]);
			index++;
		}
		if (portionOunces[5] != 0) {
			ingredients[index] = new ShrimpPortion(portionOunces[5]);
			index++;
		}
		if (portionOunces[6] != 0) {
			ingredients[index] = new TunaPortion(portionOunces[6]);
			index++;
		}
		if (portionOunces[7] != 0) {
			ingredients[index] = new YellowtailPortion(portionOunces[7]);
			index++;
		}
		
	}
	public String getName() {
		return name;
	}

	public IngredientPortion[] getIngredients() {
		return ingredients.clone();
	}
	public int getCalories() {
		int cal = 0;
		for (int i = 0; i< ingredients.length;i++) {
			cal += (int)(Math.round(ingredients[i].getCalories()));
		}
		return cal;
	}
	public double getCost() {
		double cost = 0;
		for (int i = 0; i < ingredients.length;i++) {
			cost+= ingredients[i].getCost();
		}
		return cost;
	}
	public boolean getHasRice() {
		for (int i = 0; i < ingredients.length;i++) {
			if (ingredients[i].getIsRice())
				return true;
		}
		return false;
	}
	public boolean getHasShellfish() {
		for (int i = 0; i < ingredients.length;i++) {
			if (ingredients[i].getIsShellfish())
				return true;
		}
		return false;
	}
	public boolean getIsVegetarian() {
		for (int i = 0; i < ingredients.length;i++) {
			if (ingredients[i].getIsVegetarian())
				return true;
		}
		return false;
	}
}
