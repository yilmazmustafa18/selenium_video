package tests.K13_actionsClass.D01_mouseBaseActions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;


public class C01_Actions_ContextClick extends TestBase_Each {

    @Test
    public void test01(){

        //1- https://testotomasyonu.com/click sitesine gidin
        driver.get("https://testotomasyonu.com/click");

        //2- “DGI Drones” uzerinde sag click yapin
       WebElement  dgi= driver.findElement(By.xpath("//img[@id='pic2_thumb']"));
       ReusableMethods.bekle(1);

       Actions act= new Actions(driver);

       act.contextClick(dgi);



        //3- Alert’te cikan yazinin “Tebrikler!... Sağ click yaptınız.” oldugunu test edin.
        String expVal="Tebrikler!... Sağ click yaptınız.";
        Assertions.assertEquals(expVal, driver.switchTo().alert().getText());

        driver.switchTo().alert().accept();

        //4- Tamam diyerek alert’i kapatin




    }

}
