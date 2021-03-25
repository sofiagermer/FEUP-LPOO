public class StringCaseChanger implements StringTransformer{
    @Override
    public void execute(StringDrink drink) {
        String str = drink.getText();
        String newString = "";
        for(int i = 0; i < str.length() ; i++){
            if(Character.isLowerCase(str.charAt(i))){
                newString += Character.toUpperCase(str.charAt(i));
            }
            else{
                newString += Character.toLowerCase(str.charAt(i));
            }
        }
        drink.setText(newString);
    }
}
