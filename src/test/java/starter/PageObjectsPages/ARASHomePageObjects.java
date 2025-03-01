
package starter.PageObjectsPages;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import starter.Utility.ReusableUtilities;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class ARASHomePageObjects extends PageObject {
    public static By NavigationTool= By.cssSelector("button[class='aras-toolbar__item aras-button aras-header__navigation-button']>svg[class='aras-button__icon']");
    public static By NavigationLabel=By.cssSelector("span[class='aras-nav__label']");
    public static By NavigationOptions=By.cssSelector("li.aras-nav__parent:nth-child(1) div.aras-nav__parent-container > span.aras-nav__label");
    public ReusableUtilities comm=new ReusableUtilities();
    static By arasSpinner=By.xpath("//iframe[@id='dimmer_spinner']");
    public void NavigateTo(String NavigationPath){
        String firstMenu=NavigationPath.split("/")[0];
        String secondMenu=NavigationPath.split("/")[1];
        withTimeoutOf(90, TimeUnit.SECONDS).waitFor(ExpectedConditions.invisibilityOf($(arasSpinner)));
        $(NavigationTool).click();
        Serenity.getDriver().switchTo().defaultContent();
        Serenity.getDriver().switchTo().defaultContent();
        List<WebElement> Options= Serenity.getDriver().findElements(NavigationOptions);
        for(int limit=0;limit<Options.size();limit++)
        {
            List<WebElement> parentNav=Serenity.getDriver().findElements(By.cssSelector("ul.aras-nav>li.aras-nav__parent:nth-child("+(limit+1)+") div.aras-nav__parent-container > span.aras-nav__label"));
            for(int r = 0;r<parentNav.size();r++)
            {
                if(parentNav.get(r).getAttribute("innerText").toString().trim().equalsIgnoreCase(firstMenu.trim())){
                    parentNav.get(r).click();
                    waitABit(3000);
                    List<WebElement> childNav=Serenity.getDriver().findElements(By.cssSelector("ul.aras-nav>li.aras-nav__parent.aras-nav__parent_expanded:nth-child("+(limit+1)+") ul.aras-nav__child-container li.aras-nav__child"));
                    for(int child=0;child<childNav.size();child++)
                    {
                        WebElement ChildElement =Serenity.getDriver().findElement(By.cssSelector("ul.aras-nav>li.aras-nav__parent.aras-nav__parent_expanded:nth-child("+(limit+1)+") ul.aras-nav__child-container li.aras-nav__child:nth-child("+(child+1)+") > span.aras-nav__label:nth-child(3)"));
                        System.out.println("Second:"+ ChildElement.getAttribute("innerText").toString().trim());
                        if(ChildElement.getAttribute("innerText").toString().trim().equalsIgnoreCase(secondMenu))
                        {
                            ChildElement.click();
                            break;
                        }
                    }
                }
            }
        }
    }
    public void NavigateTo3level(String NavigationPath_3) {
        String firstMenu=NavigationPath_3.split("/")[0];
        String secondMenu=NavigationPath_3.split("/")[1];
        String thirdMenu=NavigationPath_3.split("/")[2];
        withTimeoutOf(90, TimeUnit.SECONDS).waitFor(ExpectedConditions.invisibilityOf($(arasSpinner)));
        $(NavigationTool).click();
        Serenity.getDriver().switchTo().defaultContent();
        List<WebElement> Options= Serenity.getDriver().findElements(NavigationOptions);
        for(int limit=0;limit<Options.size();limit++)
        {
            List<WebElement> parentNav=Serenity.getDriver().findElements(By.cssSelector("ul.aras-nav>li.aras-nav__parent:nth-child("+(limit+1)+") div.aras-nav__parent-container > span.aras-nav__label"));
            for(int r = 0;r<parentNav.size();r++)
            {
                if(parentNav.get(r).getAttribute("innerText").toString().trim().equalsIgnoreCase(firstMenu)){
                    parentNav.get(r).click();
                    waitABit(3000);
                    List<WebElement> childNav=Serenity.getDriver().findElements(By.cssSelector("ul.aras-nav>li.aras-nav__parent.aras-nav__parent_expanded:nth-child("+(limit+1)+") ul.aras-nav__child-container li.aras-nav__parent"));
                    for(int child=0;child<childNav.size();child++)
                    {
                        WebElement ChildElement =Serenity.getDriver().findElement(By.cssSelector("ul.aras-nav>li.aras-nav__parent.aras-nav__parent_expanded:nth-child("+(limit+1)+") ul.aras-nav__child-container li.aras-nav__parent:nth-child("+(child+1)+")>div.aras-nav__parent-container > span.aras-nav__label:nth-child(2)"));
                        System.out.println("Second:"+ ChildElement.getAttribute("innerText").toString().trim());
                        if(ChildElement.getAttribute("innerText").toString().trim().equalsIgnoreCase(secondMenu))
                        {
                            ChildElement.click();
                            break;
                        }
                    }
                    waitABit(3000);
                    List<WebElement> childNav1=Serenity.getDriver().findElements(By.cssSelector("li.aras-nav__parent.aras-nav__parent_expanded:nth-child("+(limit+1)+") ul.aras-nav__child-container li.aras-nav__child"));
                    for(int child=0;child<childNav1.size();child++)
                    {
                        WebElement ChildElement =Serenity.getDriver().findElement(By.cssSelector(" li.aras-nav__parent.aras-nav__parent_expanded:nth-child("+(limit+1)+") ul.aras-nav__child-container li.aras-nav__child:nth-child("+(child+1)+") > span.aras-nav__label:nth-child(3)"));
                        System.out.println("Second:"+ ChildElement.getAttribute("innerText").toString().trim());
                        if(ChildElement.getAttribute("innerText").toString().trim().equalsIgnoreCase(thirdMenu))
                        {
                            ChildElement.click();
                            break;
                        }
                    }
                }
            }
        }
    }
    public void CloseBrowser() {
        Serenity.getDriver().close();
    }
}
