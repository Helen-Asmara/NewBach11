package h.com;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;



import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAccount {
    public static void main(String[] args) throws InterruptedException {
        // Set up ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();
        //Intialized implictywait
        
        driver.manage().timeouts().implicitlyWait(280, TimeUnit.SECONDS);
        //casting driver object to java script
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
      
        
     

        
            // Navigate to the Harris Teeter website
            driver.get("https://www.harristeeter.com/");
            //get actual title
            String   actualTitle=driver.getTitle();
            System.out.println(actualTitle);
            //maximax window
            driver.manage().window().maximize();

            //intialized explcity wait
            WebDriverWait wait = new WebDriverWait(driver, 20); 
            
           WebElement signIn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Sign In']")));
           
           js.executeScript("arguments[0].click();", signIn);

           
         //   WebElement arrowIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[local-name()='svg' and contains(@class ,'WelcomeWrapper')]")));
           // arrowIcon.click();
          //  js.executeScript("arguments[0].click();", arrowIcon);

            
          WebElement createAccountButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Create Account']")));
          createAccountButton.click();
          
        
          
          WebElement firstName = driver.findElement(By.xpath("//*[@name='firstName']"));
         
          js.executeScript("arguments[0].value = arguments[1];", firstName, "Eden");
          
          WebElement lastName =driver.findElement(By.xpath("//*[@name='lastName']"));
          //lastName.sendKeys("kelt");
          js.executeScript("arguments[0].value = arguments[1];", lastName, "Almu");
          
          WebElement emailAdress=driver.findElement(By.xpath("//*[@name='email']"));
          //emailAdress.sendKeys("ttbhel@gmail.com");
          js.executeScript("arguments[0].value = arguments[1];", emailAdress, "helentsegezab15@gmail.com");
          
          WebElement password= driver.findElement(By.xpath("//*[@name='password']"));
         // password.sendKeys("123456");
          js.executeScript("arguments[0].value = arguments[1];", password, "ABCD123456!");
          
          WebElement phoneNumber= driver.findElement(By.xpath("//*[@name='phoneNumber']"));
         // phoneNumber.sendKeys("123456");
          js.executeScript("arguments[0].value = arguments[1];", phoneNumber, "5712444099");
          
          
   
          
          WebElement StreetAdress=  driver.findElement(By.xpath("//*[@name='line1']"));
         // StreetAdress.sendKeys("123456");
          js.executeScript("arguments[0].value = arguments[1];", StreetAdress, "colmbia pike");
          
          WebElement Apt=  driver.findElement(By.xpath("//*[@name='line2']"));
         // Apt.sendKeys("123456");
          js.executeScript("arguments[0].value = arguments[1];", Apt, "99");
          
          WebElement city=  driver.findElement(By.xpath("//*[@name='city']"));
          // Apt.sendKeys("123456");
           js.executeScript("arguments[0].value = arguments[1];", city, "Arlington");
          
        
          WebElement state=  driver.findElement(By.xpath("//select[@name=\"stateCode\"]"));
          state.click();
        
          
        Select select =new Select(state);
        select.getFirstSelectedOption();
        
        
        select.selectByVisibleText("Virginia");
        WebElement PostaCode= driver.findElement(By.xpath("//input[@name='zip']"));
        
        js.executeScript("arguments[0].value = arguments[1];", PostaCode, "22204");
        
        
        WebElement agree=  driver.findElement(By.xpath("//input[@value='NO']"));
        agree.click();
       // js.executeScript("arguments[0].value = arguments[1];", lastName, "Tek");
        Thread.sleep(3000);
        WebElement joinVIC=  driver.findElement(By.xpath("//input[@name='promotionalEmailOptIn']"));
        joinVIC.click();
        boolean joinVIC2 = joinVIC.isSelected();
        System.out.println("Checkbox is initially checked: " + joinVIC);

        // If checkbox is not checked, click to check it
        if (!joinVIC2) {
        	joinVIC.click();
            System.out.println("Checkbox has been checked.");
        } else {
            System.out.println("Checkbox is already checked.");
        }
        
        
       // js.executeScript("arguments[0].value = arguments[1];", lastName, "Tek");
        WebElement Purhistory=  driver.findElement(By.xpath("//input[@name='AccountCreate-termsAndConditionsCheckbox']"));
        Purhistory.click();
        Thread.sleep(3000);
        
        WebElement termsCondtion=  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='AccountCreate-termsAndConditionsCheckbox']")));
        termsCondtion.click();
        //Thread.sleep(3000);
        boolean termsCondtion2 = termsCondtion.isSelected();
        System.out.println("Checkbox is initially checked: " + termsCondtion);

        // If checkbox is not checked, click to check it
        if (!termsCondtion2) {
        	termsCondtion.click();
            System.out.println("Checkbox has been checked.");
        } else {
            System.out.println("Checkbox is already checked.");
        }
        
        WebElement creatAccount=  driver.findElement(By.xpath("//button[text()='Create Account']"));
        creatAccount.click();
        boolean creatAccount1 = creatAccount.isSelected();
        System.out.println("Checkbox is initially checked: " + creatAccount);

        // If checkbox is not checked, click to check it
        if (!creatAccount1) {
        	creatAccount.click();
            System.out.println("Checkbox has been checked.");
        } else {
            System.out.println("Checkbox is already checked.");
        }
      //  Thread.sleep(3000);
     
      System.out.println(actualTitle);
      String  expectedlTitle=driver.getCurrentUrl();
      
        Assert.assertEquals(expectedlTitle,actualTitle);
       
                driver.quit();
            }
        }
    
