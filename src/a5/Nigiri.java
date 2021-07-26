package a5;



public class Nigiri {
	
	public enum NigiriType {TUNA, YELLOWTAIL, EEL, CRAB, SHRIMP};
	private NigiriType ntype;
	private IngredientPortion[] ingpor;
	
	public Nigiri(NigiriType type) {
		if (type == null)
			throw new IllegalArgumentException("Type can't be null");
		ntype = type; 
		if (ntype == NigiriType.TUNA) {
			IngredientPortion t = new TunaPortion(0.75);
			ingpor = new IngredientPortion[2];
			ingpor[0] = t;
		}
		else if (ntype == NigiriType.YELLOWTAIL) {
			IngredientPortion y = new YellowtailPortion(0.75);
			ingpor = new IngredientPortion[2];
			ingpor[0] = y;
		}
		else if (ntype == NigiriType.EEL) {
			IngredientPortion e = new EelPortion(0.75);
			ingpor = new IngredientPortion[2];
			ingpor[0] = e;
		}
		else if (ntype == NigiriType.CRAB) {
			IngredientPortion c = new CrabPortion(0.75);
			ingpor = new IngredientPortion[2];
			ingpor[0] = c;
		}
		else if (ntype == NigiriType.SHRIMP) {
			IngredientPortion s = new ShrimpPortion(0.75);
			ingpor = new IngredientPortion[2];
			ingpor[0] = s;
		}
		ingpor[1] = new RicePortion(0.5);
		
	}
	
	public String getName() {
		return ingpor[0].getName() + " nigiri";
	}

	public IngredientPortion[] getIngredients() {
		return ingpor.clone();
	}
	public int getCalories() {
		return (int)(Math.round(ingpor[0].getCalories())) +(int)(Math.round(ingpor[1].getCalories()));
	}
	public double getCost() {
		return ingpor[0].getCost()+ingpor[1].getCost();
	}
	public boolean getHasRice() {
		return true;
	}
	public boolean getHasShellfish() {
		return ingpor[0].getIsShellfish();
	}
	public boolean getIsVegetarian() {
		return ingpor[0].getIsVegetarian();
	}
}
