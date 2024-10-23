import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class adProduct {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        // This method will be executed before each test case.
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test // Bu annotation metodun bir test metodu oldugunu gosterir,junit bu metodu avtomatik taniyir ve isledir
    public void testN1Senario() throws InterruptedException {
        driver.get("https://www.n11.com/");

        WebElement mehsulAxtar = driver.findElement(By.id("searchData"));
        mehsulAxtar.sendKeys("iphone 13", Keys.ENTER);
        String axtarisNeticeleri = driver.findElement(By.className("resultText")).getText();
        String expectedResult = "Iphone 13 Cep Telefonu\niçin 7 sonuç bulundu.";
        assertEquals(expectedResult, axtarisNeticeleri);
        Thread.sleep(2000);
        driver.navigate().back();// onceki sehifeye qayidir
        Thread.sleep(2000); // 2 saniye cekmek ucun
        driver.navigate().forward(); //novbeti sehifeye gedir
    }

    @AfterEach
    public void tearDown() {
        // This method will be executed after each test case.
        driver.quit();
    }
}
