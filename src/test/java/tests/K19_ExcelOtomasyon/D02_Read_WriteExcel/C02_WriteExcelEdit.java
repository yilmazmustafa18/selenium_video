package tests.K19_ExcelOtomasyon.D02_Read_WriteExcel;

import org.apache.poi.ss.usermodel.*;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_WriteExcelEdit {

    @Test
    public void writeExcelTesti() throws IOException {


        //3) Adimlari takip ederek Sayfa1’e kadar gidelim
        String excelDosyaYolu = "src/test/java/tests/K19_ExcelOtomasyon/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(excelDosyaYolu);
        Workbook workbook = WorkbookFactory.create(fileInputStream);


        //workbook.createSheet("FenerbahceKadro");
        Sheet FenerbahceKadro= workbook.getSheet("Sayfa1");




        System.out.println(FenerbahceKadro.getLastRowNum()+1);

        for (int i = 0; i <= FenerbahceKadro.getLastRowNum(); i++) {
            if(FenerbahceKadro.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase("Netherlands")){
                System.out.println(FenerbahceKadro.getRow(i).getCell(1).getStringCellValue());
                break;
            }

        }

        FileOutputStream fs=new FileOutputStream(excelDosyaYolu);
        workbook.write(fs);

        fileInputStream.close();
        fs.close();

        workbook.close();


    }


}
