import java.util.ArrayList;
import java.util.List;

public class SmartStrategy implements OrderingStrategy{
    private List<StringDrink> drinkList = new ArrayList<>();
    private List<StringRecipe> recipeList = new ArrayList<>();
    @Override
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {
        if(bar.isHappyHour()) {
            if(drinkList.isEmpty()) { bar.order(drink, recipe);}
            else happyHourStarted(bar);
        }
        else {
            drinkList.add(drink);
            recipeList.add(recipe);
        }
    }

    @Override
    public void happyHourStarted(StringBar bar) {
        bar.order(drinkList.get(drinkList.size()-1), recipeList.get(recipeList.size()-1));
        drinkList.remove(drinkList.size()-1);
        drinkList.remove(recipeList.get(recipeList.size()-1));
    }

    @Override
    public void happyHourEnded(StringBar bar) {

    }
}
