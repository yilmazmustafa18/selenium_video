package tests.K11_iFrames;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase_Each;


public class C02_IFrame extends TestBase_Each {

    // 1- https://testotomasyonu.com/discount adresine gidin
    // 2- Elektronics Products yazisinin gorunur olduğunu test edin
    // 3- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin
    // 4- Sale Up To 50% yazisinin gorunur oldugunu test edin
    // 5- Fashion bolumundeki ilk urunu tiklayin
    //    ve ilk urun isminde "Men Slim Fit" gectigini test edin

    @Test
    public void test01(){

        driver.get("https://testotomasyonu.com/discount");

        WebElement frame= driver.findElement(By.xpath("//iframe[@src='https://testotomasyonu.com/disproduct']"));
        driver.switchTo().frame(frame);

        Assertions.assertTrue(driver.findElement(By.xpath("//h2[text()='Electronics Products']")).isDisplayed());

        String actualLabel=driver.findElement(By.xpath("//img[@id='pic1_thumb']/../span")).getText();
        String expectedLabel="DELL Core I3 11th Gen";

        Assertions.assertEquals(expectedLabel,actualLabel);

        driver.switchTo().defaultContent();

        Assertions.assertTrue(driver.findElement(By.xpath("//h2[.='Sale Up To 50%']")).isDisplayed());

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='https://testotomasyonu.com/disproduct2']")));

        Assertions.assertTrue( driver.findElement(By.xpath("//img[@id='pic1_thumb']/../p")).getText().contains("Men Slim Fit"));

        ////img[@id='pic1_thumb']/../p

    }
}
