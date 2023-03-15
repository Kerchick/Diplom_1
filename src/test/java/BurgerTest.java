import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import java.util.List;

import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private final String bunName = "Bulka";
    private final int expectedTwo = 2;
    private final int expectedZero = 0;
    private final float expectedPrice = 420;
    private final String expectedRecipe = "(==== Sweet bun ====)" + "\n"
            + "= sauce carolina ripper sauce =" + "\n"
            +"= filling Steak ="+ "\n"
            + "(==== Sweet bun ====)" + "\n\n"
            + "Price: 1680,000000" + "\n";


    Burger burger = new Burger();
    @Mock
    Bun bun;
    @Mock
    Database database = new Database();
    private final List<Bun> newBun = List.of(new Bun("Sweet bun", 740));
    private final Ingredient steakFilling = new Ingredient(IngredientType.FILLING,"Steak", 100);
    private final Ingredient carolinaRipperSauce = new Ingredient(IngredientType.SAUCE,"carolina ripper sauce", 100);




    @Test
    public void setBunsTest(){
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn("Bulka");
        String setBunsName = bun.getName();
        Assert.assertEquals(bunName,setBunsName);
    }

    @Test
    public void addIngredientTest(){
        burger.addIngredient(steakFilling);
        burger.addIngredient(carolinaRipperSauce);
        int actualBurgerSizeResult = burger.ingredients.size();
        assertEquals(expectedTwo, actualBurgerSizeResult);

    }
    @Test
    public void removeIngredientTest(){
        burger.addIngredient(carolinaRipperSauce);
        burger.removeIngredient(0);
        int actualBurgerSize = burger.ingredients.size();
        assertEquals(expectedZero, actualBurgerSize);

    }
    @Test
    public void moveIngredientTest(){
        burger.addIngredient(carolinaRipperSauce);
        burger.addIngredient(steakFilling);
        burger.moveIngredient(0,1);
        assertEquals(steakFilling, burger.ingredients.get(0));
    }
    @Test
    public void getPriceTest(){
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(420F);
        float burgerPrice = bun.getPrice();
        assertEquals(expectedPrice, burgerPrice, 0);


    }
    @Test
    public void getRecipeTest(){
        Mockito.when(database.availableBuns()).thenReturn(newBun);
        burger.setBuns(database.availableBuns().get(0));
        burger.addIngredient(carolinaRipperSauce);
        burger.addIngredient(steakFilling);
        assertEquals(expectedRecipe, burger.getReceipt());

    }
}

