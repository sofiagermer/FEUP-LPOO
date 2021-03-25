public class StringReplacer implements StringTransformer{
    private final char char1, char2;

    StringReplacer(char char1, char char2) {
        this.char1 = char1;
        this.char2 = char2;
    }
    @Override
    public void execute(StringDrink drink) {
        drink.setText(drink.getText().replace(char1,char2));
    }
}
