package linkedinpostimageautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.awt.Robot;
import java.awt.event.InputEvent;



public class TestCases {

     public void endTest(WebDriver driver)
    {
        System.out.println("End Test: TestCases");
        driver.quit();

    }

    
    public  void testCase01(WebDriver driver) throws InterruptedException{

       
       try {

       System.out.println("Start Test case: testCase01");
      

       driver.get("https://www.linkedin.com");
       Thread.sleep(3000);
       Actions actions = new Actions(driver);
       
       //username
       WebElement username = driver.findElement(By.id("session_key"));
       actions.sendKeys(username,"abc@gmail.com").perform();
       Thread.sleep(1000);

       //password
       driver.findElement(By.id("session_password")).sendKeys("abc123");
       Thread.sleep(1000);

       //click on Sign in
       driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();
       Thread.sleep(2000);

       

       //click on Start a post
       driver.findElement(By.xpath("//div[contains(@class,'share-box-feed-entry__top-bar')]/button")).click();
       Thread.sleep(2000);

       //Make with Connections only
       driver.findElement(By.xpath("//h2[contains(@id,'share-to-linkedin-modal__header')]/button")).click();
       Thread.sleep(2000);
       driver.findElement(By.xpath("//button[@id='CONNECTIONS_ONLY']")).click();
       Thread.sleep(2000);

       //click on Done
       driver.findElement(By.xpath("//div[@class='share-box-footer__main-actions']/button[2]")).click();
       Thread.sleep(2000);
       
      
       //send message 
       WebElement message = driver.findElement(By.xpath("//div[@aria-placeholder='What do you want to talk about?']"));
       actions.sendKeys(message, "I am posting a photo to my connections!!").perform();
       Thread.sleep(3000);
       

       //Click on Add a photo
       WebElement addPhoto = driver.findElement(By.xpath("//li[@class='artdeco-carousel__item ember-view share-creation-state__promoted-detour-button-item'][1]//button"));
       
       addPhoto.click();
       Thread.sleep(3000);
       
       Robot robot = new Robot();

       robot.mouseMove(621, 261);
       robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
       robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

       robot.mouseMove(754, 237);
       robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
       robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

       Thread.sleep(2000);

       robot.mouseMove(1298, 575);
       robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
       robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
 
       Thread.sleep(3000);

       //Click on done button
       driver.findElement(By.xpath("//div[@class='share-box-footer__main-actions']/button[2]")).click();
       Thread.sleep(2000);

       if(driver.findElement(By.xpath("//div[@class='share-box_actions']/button")).isDisplayed()){
        
       //Click on Post button
       driver.findElement(By.xpath("//div[@class='share-box_actions']/button")).click();
       Thread.sleep(3000);
       System.out.println("Successfully posted!!");

       }
       else{
         System.out.println("Not Successfully posted!!");
       }

       
      

       //confirm if it gets posted
       driver.findElement(By.xpath("//p[@class='artdeco-toast-item__message']")).isDisplayed();

       

      
       
       System.out.println("end Test case: testCase01");
        
       } catch (Exception e) {
          e.printStackTrace();
       }
       
        

    }
    
}
