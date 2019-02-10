package test;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.GasMileageCalculatorPage;
import utilities.Config;
import utilities.Driver;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class GasMileageCalculatorTest {
    GasMileageCalculatorPage gasObj;
    private WebDriver driver;

    XSSFWorkbook workbook;
    XSSFSheet worksheet;
    FileInputStream inputStream;
    FileOutputStream outputStream;

    @Before
    public void setUp() throws Exception{

        driver = Driver.getDriver();
        driver.get("https://www.calculator.net/gas-mileage-calculator.html");

        inputStream = new FileInputStream(Config.getProperty("gasmileage.testdata.path"));

        workbook = new XSSFWorkbook(inputStream);
        worksheet = workbook.getSheet("Sheet1");

   }

    @Test
    public void dataDrivenMileageCalculatorTest() throws Exception{

        gasObj = new GasMileageCalculatorPage();

        for(int rowNum=1; rowNum<worksheet.getPhysicalNumberOfRows(); rowNum++) {

            XSSFRow currentRow = worksheet.getRow(rowNum);

            if(!currentRow.getCell(0).toString().equalsIgnoreCase("Y")){

                if(currentRow.getCell(6) == null){

                    currentRow.createCell(6);

                }

                currentRow.getCell(6).setCellValue("Skip Requested!");
                continue;
            }

            //double currentOdo = 123000;
            double currentOdo = currentRow.getCell(1).getNumericCellValue();
            gasObj.currentOdometerReadingInput.clear();
            gasObj.currentOdometerReadingInput.sendKeys(String.valueOf(currentOdo));

            //double previousOdo = 122000;
            double previousOdo = currentRow.getCell(2).getNumericCellValue();
            gasObj.previousOdometerReadingInput.clear();
            gasObj.previousOdometerReadingInput.sendKeys(String.valueOf(previousOdo));

            //double gas = 70;
            double gas = currentRow.getCell(3).getNumericCellValue();
            gasObj.gasInput.clear();
            gasObj.gasInput.sendKeys(String.valueOf(gas));


            gasObj.calculateButton.click();

            double expectedResult = (currentOdo - previousOdo) / gas;
            System.out.println("Expected result: " + expectedResult);

            String[] actualResult = gasObj.resultInGallon.getText().split(" ");
            System.out.println("Actual result: " + actualResult[0].toString());

            DecimalFormat decimalFormat = new DecimalFormat("#0.00");

            System.out.println("Formulated result: " + decimalFormat.format(expectedResult));


            if(currentRow.getCell(4) == null){

                currentRow.createCell(4);

            }

            currentRow.getCell(4).setCellValue(decimalFormat.format(expectedResult));

            if(currentRow.getCell(5) == null){

                currentRow.createCell(5);

            }

            currentRow.getCell(5).setCellValue(actualResult[0]);



            if (String.valueOf(decimalFormat.format(expectedResult)).equals(actualResult[0])) {

                if(currentRow.getCell(6) == null){

                    currentRow.createCell(6);

                }

                currentRow.getCell(6).setCellValue("PASS!");

                System.out.println("PASS!");

            } else {

                if(currentRow.getCell(6) == null){

                    currentRow.createCell(6);

                }

                currentRow.getCell(6).setCellValue("FAIL!");
                System.out.println("FAIL");
            }

            if(currentRow.getCell(7) == null){

                currentRow.createCell(7);

            }

            currentRow.getCell(7).setCellValue(LocalDateTime.now().toString());

        }


        outputStream = new FileOutputStream(Config.getProperty("gasmileage.testdata.path"));
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
        inputStream.close();

    }

}
