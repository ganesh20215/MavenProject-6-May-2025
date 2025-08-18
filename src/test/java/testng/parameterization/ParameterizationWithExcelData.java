package testng.parameterization;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ParameterizationWithExcelData {

    @DataProvider(name = "test-data")
    public Object[][] dataProFun() throws IOException {
        Object[][] arrayObject = getExcelData("D:\\classes\\TestNGDemoForMorningBatch.xlsx", "TestCases");

        return arrayObject;
    }

    public static Object[][] getExcelData(String pathName, String sheetName) throws IOException {
        FileInputStream f = new FileInputStream(pathName);
        Workbook wb = new XSSFWorkbook(f);
        Sheet sh = wb.getSheet(sheetName);

        int rows = sh.getPhysicalNumberOfRows();
        int cols = sh.getRow(0).getLastCellNum();

        Object[][] data = new Object[rows - 1][cols];

        for (int i = 1; i < rows; i++) {
            Row r = sh.getRow(i);
            for (int j = 0; j < cols; j++) {
                Cell c = r.getCell(j);
                data[i - 1][j] = c.toString();
            }
        }
        return data;

    }


    @Test(dataProvider = "test-data")
    public void verifyNeedOfParameterization(String userName, String password) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys(userName);
        Thread.sleep(2000);
        driver.findElement(By.id("password")).sendKeys(password);
        Thread.sleep(2000);
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);

        driver.close();
    }
}
