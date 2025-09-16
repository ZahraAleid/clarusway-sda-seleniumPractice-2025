package TestPackage.Week4;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;

public class C45_WriteExcel {
/*
    Create an object of File class to open xlsx file.
    Create an object of FileInputStream class to read Excel file.
    Creating workbook instance that refers to .xlsx file.
    Creating a Sheet object.
    Create a row object to retrieve row at index 3.
    Create a cell object to enter value in it using cell Index.
    Write the data in Excel using output stream.
*/

    private static final Path RESOURCES = Path.of(System.getProperty("user.dir"),"resources");
    @Test
    public void writeExcelTest() throws IOException {
        //Create an object of File class to open xlsx file.
        //Create an object of FileInputStream class to read Excel file.
        Workbook workBook;
        try (FileInputStream fis = new FileInputStream(RESOURCES.resolve("Countries.xlsx").toString())){
            workBook = WorkbookFactory.create(fis);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //Creating workbook instance that refers to Countries.xlsx file.

        //Creating a Sheet object.
        Sheet newSheet = workBook.createSheet("New Sheet");

        //Create a row object to retrieve row at index 3.
        Row newRow = newSheet.createRow(3);

        //Create a cell object to enter value in it using cell Index 1.
        newRow.createCell(1).setCellValue("Vision2030");
        //Write the data in Excel using output stream.
        try (FileOutputStream fos = new FileOutputStream(RESOURCES.resolve("Countries.xlsx").toString())){
            workBook.write(fos);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        workBook.close();

    }

    //Add Population column to the countries
    @Test
    public void addNewColumn() throws IOException {
        FileInputStream fis = new FileInputStream(RESOURCES.resolve("Countries.xlsx").toString());
        Workbook workbook = WorkbookFactory.create(fis);
        fis.close();

        Sheet sheet = workbook.getSheetAt(0);
        sheet.getRow(0).createCell(2).setCellValue("POPULATION");

        //add population values with random numbers

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            int extra = i*2+1;
            int extra2 = i+2;
            if (row != null) {
                row.createCell(2).setCellValue("1"+extra+"."+extra2+" M");
            }
        }


        FileOutputStream fos = new FileOutputStream(RESOURCES.resolve("Countries.xlsx").toString());
        workbook.write(fos);
        fos.close();
        workbook.close();



    }

    //HW: print populations of the countries

    @Test
    void printPopulation() throws IOException {
        FileInputStream fis = new FileInputStream(RESOURCES.resolve("Countries.xlsx").toString());
        Workbook workbook = WorkbookFactory.create(fis);
        fis.close();

        Sheet sheet = workbook.getSheetAt(0);

        int lastRowIndex = sheet.getLastRowNum();

        System.out.println("Population of each country:");
        for (int i = 1; i <= lastRowIndex; i++) {
            Row row = sheet.getRow(i);
            String country = row.getCell(0).toString();
            String population = row.getCell(2).toString();
            System.out.println(country + " -> " + population);
        }

        workbook.close();
    }



}
