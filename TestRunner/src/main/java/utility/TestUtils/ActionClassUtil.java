package utility.TestUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utility.WebDriverUtils;

public class ActionClassUtil {
    private ActionClassUtil(){}

    // for page object model
    public static void actionClassMoveOver(WebDriver driver, By locator ){
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,locator);
        WebElement element = driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public static void actionClassClick(WebDriver driver, By locator ){
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,locator);
        WebElement element = driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }
    public static void actionClassRightClick(WebDriver driver, By locator ){
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,locator);
        WebElement element = driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.contextClick(element).build().perform();
    }

    public static void actionClassClickAndHold(WebDriver driver, By sourceLocator,By targetLocator ){
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,sourceLocator);
        WebElement source = driver.findElement(sourceLocator);
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,targetLocator);
        WebElement target=driver.findElement(targetLocator);
        Actions actions = new Actions(driver);
        actions.clickAndHold(source).moveToElement(target).release().build().perform();

    }

    public static void actionClassDragAndDrop(WebDriver driver, By sourceLocator,By targetLocator ){
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,sourceLocator);
        WebElement source = driver.findElement(sourceLocator);
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,targetLocator);
        WebElement target=driver.findElement(targetLocator);
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source,target).build().perform();
    }
    public static void actionClassSlider(WebDriver driver, By locator,int from, int to){
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,locator);
        WebElement slider = driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(slider).dragAndDropBy(slider,from,to).build().perform();
    }

    public static void actionClassDoubleClick(WebDriver driver, By locator){
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,locator);
        WebElement element = driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();
    }


    // Select and the Current Address using CTRL + A
    public static void actionClassSelectClear(WebDriver driver, By locator) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,locator);
        Actions actions = new Actions(driver);
        driver.findElement(locator);
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        actions.sendKeys(Keys.BACK_SPACE).build().perform();
    }


    // Copy the Current String using CTRL + C and paste using CTRL+V

    public static void actionClassCopyAndPaste(WebDriver driver, By sourceElement,By targetElement) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,sourceElement);
        WebElement sourceLocator=driver.findElement(sourceElement);
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,targetElement);
        WebElement targetLocator=driver.findElement(sourceElement);
        Actions actions = new Actions(driver);
        driver.findElement(sourceElement);
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,targetElement);
        driver.findElement(targetElement);
        actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();
    }

    //Press the TAB Key to Switch Focus to new element

    public static void actionClassShift(WebDriver driver, By locator) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver, locator);
        Actions actions = new Actions(driver);
        driver.findElement(locator);
        actions.sendKeys(Keys.TAB).build().perform();
    }

    public static void rightClickAndRefresh(WebDriver driver,By locator){
        WebDriverUtils.isLocatorVisibleByFluentWait(driver, locator);
        WebElement element= driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.contextClick(element).keyDown(Keys.CONTROL).sendKeys("r").build().perform();

    }


    //  for page factory model

    public static void actionClassMoveOver(WebDriver driver,WebElement element ){
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,element);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public static void actionClassClick(WebDriver driver,WebElement element ){
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,element);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }

    public static void actionClassRightClick(WebDriver driver,WebElement element ){
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,element);
        Actions actions = new Actions(driver);
        actions.contextClick(element).build().perform();
    }

    public static void actionClassClickAndHold(WebDriver driver,WebElement sourceLocator,WebElement targetLocator ){
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,sourceLocator);
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,targetLocator);
        Actions actions = new Actions(driver);
        actions.clickAndHold(sourceLocator).moveToElement(targetLocator).release().build().perform();
    }

    public static void actionClassDragAndDrop(WebDriver driver, WebElement
            sourceLocator,WebElement targetLocator ){
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,sourceLocator);
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,targetLocator);
        Actions actions = new Actions(driver);
        actions.dragAndDrop(sourceLocator,targetLocator).build().perform();
    }
    public static void actionClassSlider(WebDriver driver,WebElement element,int from, int to){
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,element);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).dragAndDropBy(element,from,to).build().perform();
    }

    public static void actionClassDoubleClick(WebDriver driver,WebElement element){
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,element);
        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();

    }
    // Select and the Current Address using CTRL + A
    public static void actionClassSelectClear(WebDriver driver,WebElement element) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,element);
        Actions actions = new Actions(driver);
       actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        actions.sendKeys(Keys.BACK_SPACE).build().perform();
    }


    // Copy the Current String using CTRL + C and paste using CTRL+V

    public static void actionClassCopyAndPaste(WebDriver driver,WebElement sourceElement,WebElement targetElement) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,sourceElement);
        WebElement sourceLocator=sourceElement;
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
        actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
        WebDriverUtils.isLocatorVisibleByFluentWait(driver,targetElement);
        WebElement targetLocator=targetElement;
        actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();
    }

    //Press the TAB Key to Switch Focus to new element

    public static void actionClassShift(WebDriver driver,WebElement element) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver, element);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).build().perform();
    }
    public static void rightClickAndRefresh(WebDriver driver,WebElement element) {
        WebDriverUtils.isLocatorVisibleByFluentWait(driver, element);
        Actions actions = new Actions(driver);
       actions.contextClick(element).keyDown(Keys.CONTROL).sendKeys("R").build().perform();
    }

}
