package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Amazon {

    public static void main(String[] args) throws AWTException {
        WebDriver driver = Driver.getDriver();
        driver.get("http://www.cybertekchicago.com");
        List<WebElement> phoneNums = driver.findElements(By.xpath("(//table)[1]/tbody/tr/td[6]"));
        for(WebElement phone: phoneNums){
            System.out.println(phone.getText());
        }
        Robot r = new Robot();

    }
}
