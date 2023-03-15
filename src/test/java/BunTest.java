
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;
@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }


    @Parameterized.Parameters()
    public static Object[][]
    bunTestData() {
        return new Object[][]{
                {"", 1},
                {null, 100},
                {"red bun", 1000},
                {"veryveryveryveryveryveryveryveryveryveryveryveryveryveryveryveryveryveryveryveryveryveryveryveryLONG bun", 10},
                {"Specialsymbol !@#$%^&*( bun", 100},
                // Тест упадет при значении null в price {"red bun", null},
                {"red bun", 0},
                {"red bun", -100},
                {"red bun", 0.01f},
                {"red bun", 999999999}
        };
    }

    @Test
    public void getNameTest() {
        Bun bun = new Bun(name, price);
        assertEquals(name, bun.getName());
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun(name, price);
        assertEquals(price, bun.getPrice(), 0);
    }
}