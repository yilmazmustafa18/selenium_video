package tests.K13_actionsClass.D01_mouseBaseActions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase_Each;


public class C03_Actions_MoveToElement extends TestBase_Each {

    @Test
    public void test01(){
        //1- https://www.testotomasyonu.com/ adresine gidin
        driver.get("https://www.testotomasyonu.com/");

        //2- “Kids Wear” menusunun acilmasi icin mouse’u bu menunun ustune getirin
        WebElement upMenu=driver.findElement(By.xpath("(//a[.='Kids Wear'])[3]"));
        ReusableMethods.bekle(1);
        Actions act=new Actions(driver);
        act.moveToElement(upMenu);



        //3- “Boys” linkine basin
         driver.findElement(By.xpath("//a[.='Boys'])")).click();


        //4- Acilan sayfadaki ilk urunu tiklayin
        driver.findElements(By.xpath("//a[@class='prod-img']")).get(0).click();

        //5- Acilan sayfada urun isminin “Boys Shirt White Color” oldugunu test edin
        String expVal="Boys Shirt White Color";
        Assertions.assertEquals(expVal,driver.findElement(By.xpath("//div[@class=' heading-sm mb-4']")).getText());




    }

}
