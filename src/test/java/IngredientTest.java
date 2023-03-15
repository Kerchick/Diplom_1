import org.junit.Assert;
import org.junit.Test;
import praktikum.IngredientType;
import praktikum.Ingredient;


import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest {
    private final float getPrice = 420;
    private final String getName  = "traditional galactic sauce";


    @Test
    public void getPriceTest(){
        Ingredient ingredient = new Ingredient(FILLING, "traditional galactic sauce", 420);
        float getIngredientPrice = ingredient.getPrice();
        Assert.assertEquals(getPrice, getIngredientPrice, 0);
    }
    @Test
    public void getNameTest(){
        Ingredient ingredient = new Ingredient(FILLING, "traditional galactic sauce", 420);
        String getIngredientName = ingredient.getName();
        Assert.assertEquals(getName, getIngredientName);

    }

    @Test
    public void getIngredientFillingTypeTest(){
        Ingredient ingredient = new Ingredient(FILLING, "traditional galactic sauce", 420);
        IngredientType ingredientType = ingredient.getType();
        Assert.assertEquals(FILLING, ingredientType);
    }
    @Test
    public void getIngredientSauceTypeTest(){
        Ingredient ingredient = new Ingredient(SAUCE, "traditional galactic sauce", 420);
        IngredientType ingredientType = ingredient.getType();
        Assert.assertEquals(SAUCE, ingredientType);
    }
}
