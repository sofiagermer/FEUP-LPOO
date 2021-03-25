import java.util.List;

public class StringRecipe {
    private final List<StringTransformer> listStringTransformer;
    public StringRecipe(List<StringTransformer> listStringTransformer) {
        this.listStringTransformer = listStringTransformer;
    }
    public void mix(StringDrink drink){
        for(StringTransformer transformatiom : listStringTransformer){
            transformatiom.execute(drink);
        }
    }
}
