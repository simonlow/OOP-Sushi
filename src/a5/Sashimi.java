package a5;

public class Sashimi implements Sushi {
	
	public enum SashimiType {TUNA, YELLOWTAIL, EEL, CRAB, SHRIMP};
	private SashimiType stype;
	private IngredientPortion[] ingpor;
	
	public Sashimi(SashimiType type) {
		if (type == null)
			throw new IllegalArgumentException("Type can't be null");
		stype = type; 
		if (stype == SashimiType.TUNA) {
			IngredientPortion t = new TunaPortion(0.75);
			ingpor = new IngredientPortion[1];
			ingpor[0] = t;
		}
		else if (stype == SashimiType.YELLOWTAIL) {
			IngredientPortion y = new YellowtailPortion(0.75);
			ingpor = new IngredientPortion[1];
			ingpor[0] = y;
		}
		else if (stype == SashimiType.EEL) {
			IngredientPortion e = new EelPortion(0.75);
			ingpor = new IngredientPortion[1];
			ingpor[0] = e;
		}
		else if (stype == SashimiType.CRAB) {
			IngredientPortion c = new CrabPortion(0.75);
			ingpor = new IngredientPortion[1];
			ingpor[0] = c;
		}
		else if (stype == SashimiType.SHRIMP) {
			IngredientPortion s = new ShrimpPortion(0.75);
			ingpor = new IngredientPortion[1];
			ingpor[0] = s;
		}
			
		
	}
	public String getName() {
		return ingpor[0].getName() + " sashimi";
	}

	public IngredientPortion[] getIngredients() {
		return ingpor.clone();
	}
	public int getCalories() {
		return (int)(Math.round(ingpor[0].getCalories()));
	}
	public double getCost() {
		return ingpor[0].getCost();
	}
	public boolean getHasRice() {
		return ingpor[0].getIsRice();
	}
	public boolean getHasShellfish() {
		return ingpor[0].getIsShellfish();
	}
	public boolean getIsVegetarian() {
		return ingpor[0].getIsVegetarian();
	}
}
