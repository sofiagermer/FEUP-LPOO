import java.util.List;

public class StringTransformerGroup implements StringTransformer {
    private final List<StringTransformer> listStringTransformer;
    public StringTransformerGroup(List<StringTransformer> listStringTransformer) {
        this.listStringTransformer = listStringTransformer;
    }
    public void execute(StringDrink drink) {
        for(StringTransformer transformatiom : listStringTransformer){
            transformatiom.execute(drink);
        }
    }
}
