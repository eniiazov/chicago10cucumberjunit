package test;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import utilities.Config;

import java.io.File;
import java.io.FileInputStream;

public class ExcelRead {

    public static void main(String[] args) throws Exception {


        File file = new File("src/SampleData.xlsx");

        System.out.println(file.exists());

        //Opening reading file
        FileInputStream inputStream = new FileInputStream(file);


        //Loading into the class
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

        //Passing worksheet & name
        XSSFSheet worksheet = workbook.getSheet("Employees");

        System.out.println(worksheet.getRow(2).getCell(1));

        System.out.println(worksheet.getRow(5).getCell(0));

        //TO get the physical number of rows used
        //
        int usedRows = worksheet.getPhysicalNumberOfRows();
        System.out.println("PhsyicalNumberOfRows: " + usedRows);

        int lastUsedRow = worksheet.getLastRowNum();
        System.out.println("LastUsedRow: " + lastUsedRow);

        //TODO: PRINT OUT NANCY'S JOB_ID DYNAMICALLY

        for(int rowNum=0; rowNum<=usedRows; rowNum++){

            if(worksheet.getRow(rowNum).getCell(0).toString().equals("Nancy")){

                System.out.println("Nancy's Job: " + worksheet.getRow(rowNum).getCell(2));
                break;

            }

        }

        //TODO: IF LAST NAME IS MATCHING "HAAN", PRINT OUT ALL THE INFORMATION FOR THAT PERSON :
        //TODO: FIRSTNAME, LASTNAME, JOB_ID
        //GET THE LAST NAME FROM CONFIG


        String lastName = Config.getProperty("lastname");

        for(int i=0; i<=usedRows; i++){

            if(worksheet.getRow(i).getCell(1).toString().equals(lastName)){

                System.out.println("Information for employee- " + lastName + " FirstName ==>"+

                    worksheet.getRow(i).getCell(0) + "," + worksheet.getRow(i).getCell(2)

                );


                break;
            }




        }




        workbook.close();
        inputStream.close();

    }
}
