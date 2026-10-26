package tests.K18_WebTables.D02_KlasikHtmlOlmayanTables;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase_Each;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C01_KlasikHtmlOlmayanTablo extends TestBase_Each {

    @Test
    public void test01(){
        //       //*[@role='trow'][4]/*[@role='tdata'][1]

        //  1. “https://testotomasyonu.com/webtables2” sayfasina gidin
        driver.get("https://testotomasyonu.com/webtables2");

        //  2. Headers da bulunan basliklari yazdirin
        //List<WebElement> baslikElementleriList = driver.findElements(By.xpath("//*[@role='hrow']/*[@role='hdata']"));
        List<WebElement> baslikElementleriList=driver.findElements(By.xpath("//div[@class='table-tr bg-light']/div[@class='table-td fw-bold']"));
        System.out.println("Basliklar : " + ReusableMethods.stringListeDondur(baslikElementleriList));

        //  3. istenilen sutunun basligini yazdirin
        System.out.println("3.sutun basligi : " + getColumnHeader(3) );

        getPricesInCategory("Electronics");
/*
        //  4. Tablodaki tum datalari yazdirin
        List<WebElement> tumDataListesi = driver.findElements(By.xpath("//div[@class='table-td' and @role='tdata']"));
        System.out.println("Tablodaki tum datalar : " +
                            ReusableMethods.stringListeDondur(tumDataListesi));


        //  5. Tabloda kac tane cell (data) oldugunu yazdirin
        System.out.println("Tablodaki data sayisi : " + tumDataListesi.size());

        //  6. Tablodaki satir sayisini yazdirin
        List<WebElement> satirElementleriList = driver.findElements(By.xpath("//*[@role='trow']"));

        System.out.println("Satir sayisi : " + satirElementleriList.size());

        //  7. Tablodaki sutun sayisini yazdirin
        //     WebTablo'da sutun yapisi yoktur
        //     Herhangi bir satirdaki data sayisina bakabiliriz
        //     Yukarda kaydettigimiz icin baslik sayisini alalim
        System.out.println("Tablodaki sutun sayisi : " + baslikElementleriList.size());

        //  8. Tablodaki 3.kolonu yazdirin
        //     WebTablo'da sutun yapisi yoktur
        //     3.sutun yerine, her satirdaki 3.datayi alabiliriz
        List<WebElement> ucuncuSutunElementleriList = driver.findElements(By.xpath("//*[@role='trow']/*[@role='tdata'][3]"));

        //10. Bir method olusturun,
        //    Test method'undan satir ve sutun verildiginde datayi dondursun
        System.out.println( getCellData(1,2) ); // Electronics

        System.out.println( getCellData(1,3) ); // $399.00

        System.out.println( getCellData(2,1) ); // Medium 25 L Laptop Backpack

        System.out.println( getCellData(3,4) ); // Go
        
        //  9. Tabloda "Category" si Furniture olan urunun fiyatini yazdirin
        //     satirlari tek tek dolasip, istenen bilgiyi kontrol etmeli
        //     ve sarti saglayanlar icin yazdirilmasi istenen bilgiyi yazdirmaliyiz
        System.out.println("=====Kategoriye gore element listesi======");

        for (int i = 1; i <= satirElementleriList.size() ; i++) {

            String satirdakiKategory = getCellData(i,2);

            if (satirdakiKategory.equalsIgnoreCase("Furniture")){

                System.out.println(   getCellData(i,3)  );

            }


        }

*/
    }

    public String getCellData(int satirNo , int sutunNo){

         //           //*[@role='trow'][    4     ]/*[@role='tdata'][   1   ]
        String dinamikXpath = "//*[@role='trow'][" + satirNo + "]/*[@role='tdata'][" + sutunNo + "]";

        WebElement istenenDataElementi = driver.findElement(By.xpath(dinamikXpath));

        return istenenDataElementi.getText();

    }

    public String getColumnHeader(int orderNo){
        String dynXPath="//div[@class='table-tr bg-light']/div[@class='table-td fw-bold']["+orderNo+ "]";
        WebElement colHeader=driver.findElement(By.xpath(dynXPath));
        return colHeader.getText();
    }

    public void  getPricesInCategory(String  category){
        List<String> prices= new ArrayList<>();
        String dynXPath="//div[@role='trow']/div[@role='tdata'][1]";
        String dynXPath1="//div[@role='trow']/div[@role='tdata'][2]";
        String dynXPath2="//div[@role='trow']/div[@role='tdata'][3]";


        List<WebElement> prod =driver.findElements(By.xpath(dynXPath));
        List<WebElement> cat =driver.findElements(By.xpath(dynXPath1));
        List<WebElement> prodPrices =driver.findElements(By.xpath(dynXPath2));

        Map<String,String> prodPrice=new HashMap<>();


        for (int i = 0; i < cat.size(); i++) {
            if(cat.get(i).getText().equalsIgnoreCase(category)){
                System.out.print(prodPrices.get(i).getText()+"--"+cat.get(i).getText()+"--"+prod.get(i).getText()+"\n");
            }
            prodPrice.put(prod.get(i).getText(),prodPrices.get(i).getText());

        }

        System.out.println(prodPrice);


    }


}
