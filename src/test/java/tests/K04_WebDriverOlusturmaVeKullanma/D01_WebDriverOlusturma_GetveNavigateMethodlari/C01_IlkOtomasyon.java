package tests.K04_WebDriverOlusturmaVeKullanma.D01_WebDriverOlusturma_GetveNavigateMethodlari;

import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

public class C01_IlkOtomasyon {

    public static void main(String[] args) throws InterruptedException {

        // Bir test class'i olusturuldugunda ilk yapilmasi gereken sey
        // WebDriver edinmektir
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*"); // Bağlantı reddini önler
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage"); // Bellek yetersizliği çökmelerini engeller
        options.addArguments("--disable-gpu");

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.testotomasyonu.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         /*
         istenen Url'e gider
         url yazarken www yazmasak da WebDriver objesi url'e gider
         ANCCAAAK https: yazmazsak kod calismaz
         */

        ////li[@class='has-sub']
        List<WebElement> abovemenu= new ArrayList<>();
        abovemenu=driver.findElements(By.xpath("//li[@class='has-sub']"));
        int lim=abovemenu.size();

        for (int i = 0; i < lim; i++) {
            abovemenu=driver.findElements(By.xpath("//li[@class='has-sub']"));
            abovemenu.get(i).click();
            Thread.sleep(1000);
        }

        Thread.sleep(3000);
        WebElement catmenur=driver.findElement(By.xpath("(//span[contains(text(),'Select Category')])[1]"));
        catmenur.click();
        Thread.sleep(3000);
        WebElement cat=driver.findElement(By.xpath("(//a[text()='Electronics'])[1]"));
        cat.click();
        Thread.sleep(3000);


        WebElement searchBox=driver.findElement(By.xpath("(//input[@placeholder='Search Product,Category...'])[1]"));
        searchBox.sendKeys("iphone"+ Keys.ENTER);
        Thread.sleep(3000);

        List<WebElement> products_price= new ArrayList<>();
        List<WebElement> products_name= new ArrayList<>();

        products_price=driver.findElements(By.xpath("//div[@class='price']"));
        products_name= driver.findElements(By.xpath("//a[@class='prod-title mb-3 ']"));
        TreeMap<Integer,String > productsMap=new TreeMap<>();


        for (int i = 0; i < products_price.size(); i++) {

            String price=products_price.get(i).getText();
            String newPrice=price.replaceAll("\\D","");
            Integer netPrice=Integer.parseInt(newPrice)/100;
            productsMap.put(netPrice,products_name.get(i).getText());
        }

        String productNumberStr=driver.findElement(By.xpath("//span[contains (text(),'Products Found')]")).getText();
        String dummy= productNumberStr.replaceAll("\\D","");




        Integer number=Integer.parseInt(dummy);


        if(!products_price.isEmpty()) System.out.println(number+ " ürün bulundu");
        else System.out.println("ürün bulunamadı");

        System.out.println("En ucuz ürün: "+ productsMap.firstEntry());
        System.out.println("En ucuz ürün: "+ productsMap);


        Thread.sleep(3000);
        driver.quit();

    }
}
