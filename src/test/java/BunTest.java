
import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {

    private final String expectedName = "OG_Buda";
    private final float expectedPrice = 420;


    @Test
    public void getNameTest(){
        Bun bun = new Bun("OG_Buda", 420);
        String getBunName = bun.getName();
        Assert.assertEquals(expectedName, getBunName);
    }

    @Test
    public void getPriceTest(){
        Bun bun = new Bun("OG_Buda", 420);
        float getBunPrice = bun.getPrice();
        Assert.assertEquals(expectedPrice, getBunPrice,0);
    }
}
