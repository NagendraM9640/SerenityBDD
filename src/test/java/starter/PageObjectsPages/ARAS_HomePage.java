package starter.PageObjectsPages;


import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import starter.Utility.ReusableUtilities;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ARAS_HomePage extends PageObject {
    static By navigationTool=By.xpath("//body/aras-toolbar[@id='headerCommandsBar']/div[1]/button[1]");
    static By designMenu=By.xpath("//body/main[1]/aras-navigation-panel[1]/aras-nav[1]/ul[1]/li[2]");
    static By partsMenu=By.xpath("//body/main[1]/aras-navigation-panel[1]/aras-nav[1]/ul[1]/li[2]/ul[1]/li[1]/span[2]");
    static By newParts=By.xpath("//body/main[1]/aras-navigation-panel[1]/div[2]/div[1]/button[1]/span[1]");
    static By searchParts=By.xpath("//body/main[1]/aras-navigation-panel[1]/div[2]/div[1]/button[2]/span[1]");
    static By arasSpinner=By.xpath("//iframe[@id='dimmer_spinner']");
    static By arasButtonIcon = By.className("aras-button__icon");
    public static By NavigationTool= By.cssSelector("button[class='aras-toolbar__item aras-button aras-header__navigation-button']>svg[class='aras-button__icon']");
    public static By NavigationOptions=By.cssSelector("li.aras-nav__parent:nth-child(1) div.aras-nav__parent-container > span.aras-nav__label");
    static @FindBy(css = "li.aras-nav__parent") List<WebElementFacade> FirstMenus;
    static @FindBy(css = "li[class*='expanded']>ul>li") List<WebElementFacade> expandedSecodaryMenu;
    static @FindBy(css = "div[class*='aras-secondary-menu']>button") List<WebElementFacade> LastMenuOption;

    static @FindBy(name = "") WebElementFacade login;
    ReusableUtilities reusableUtilities;

    public void navigating(String path) {
        withTimeoutOf(90,TimeUnit.SECONDS).waitFor(arasButtonIcon);
        if(element(By.cssSelector("aras-navigation-panel#navigationPanel")).
                getAttribute("className").toString().contains("_pinned")) {
            $(By.cssSelector("span[class*='__pin-icon']")).click();
        } else {
                 $(arasButtonIcon).click();
        }
        List<String> navigationPath= List.of(path.split("/"));
        for(String options:navigationPath) {
            if(options.equalsIgnoreCase(navigationPath.get(0))) {
                for(WebElementFacade firstMenu:FirstMenus) {
                    if(firstMenu.getAttribute("innerText").equalsIgnoreCase(options)) {
                        firstMenu.click();
                        break;
                    }}}
            else if (options.equalsIgnoreCase(navigationPath.get(navigationPath.size()-1))) {
                withTimeoutOf(60,TimeUnit.SECONDS).waitFor("//*[text()='" +options+ "']").waitUntilEnabled();
                for (WebElementFacade lastMenu:LastMenuOption) {
                    if(lastMenu.getAttribute("innerText").equalsIgnoreCase(options)) {
                        lastMenu.withTimeoutOf(120,TimeUnit.SECONDS).waitUntilClickable().click();
                        break;
                    }}}
            else {
                withTimeoutOf(60,TimeUnit.SECONDS).waitFor(expandedSecodaryMenu.get(0)).isCurrentlyVisible();
                for (WebElementFacade secondaryMenu:expandedSecodaryMenu) {
                    if(secondaryMenu.getAttribute("innerText").equalsIgnoreCase(options)) {
                        secondaryMenu.click();
                        break;
                    }}}
            waitABit(2000);
        }

    }
    public boolean verifyHomePage()
    {
       withTimeoutOf(90, TimeUnit.SECONDS).waitForPresenceOf(navigationTool);
       return $(navigationTool).isCurrentlyVisible();
    }
    public void click_On_Navigation()
    {
        withTimeoutOf(90, TimeUnit.SECONDS).waitFor(ExpectedConditions.invisibilityOf($(arasSpinner)));
       $(navigationTool).click();
    }
    public void click_On_designOption()
    {
        if(!$(newParts).isCurrentlyVisible()) {
            $(designMenu).click();
        }
    }
    public void click_On_partsSubMenu()
    {
        if(!$(newParts).isCurrentlyVisible()) {
            $(partsMenu).click();
        }
    }
    public void click_On_createNewPart()
    {
        withTimeoutOf(90, TimeUnit.SECONDS).waitForPresenceOf(newParts);
        $(newParts).click();
    }
    public void clickonSearchParts()
    {
        withTimeoutOf(90, TimeUnit.SECONDS).waitForPresenceOf(searchParts);
        $(searchParts).click();
    }
    public void navigateTo(String path){/*
        //waitABit(5000);
        *//*if($(pinButton).isClickable()) {
            reusableUtilities.performAction("", $(pinButton),"");
        }*//*
        Serenity.getDriver().switchTo().defaultContent();
        reusableUtilities.performAction("Button", $(arasButtonIcon), "Clicking on Burger Menu");
        waitABit(2000);
        if($(backToContentsButton).isCurrentlyVisible()) {
            reusableUtilities.performAction("Button", $(backToContentsButton), "");
        }
        String [] pathInArray = path.split("/");
        List <String> list = new ArrayList<String>();
        for(int r=0;r< pathInArray.length;r++){
            list.add(r, pathInArray[r]);
        }
        for(int i=0; i<list.size(); i++) {
            By pathElement = By.xpath("//*[text()='"+list.get(i)+"']");
            reusableUtilities.conditionalWait("Visibility", pathElement, "");
            waitABit(3000);
            if(list.size()>2 && i==0) {
                By firstElement = By.xpath("//*[@class='aras-nav__parent']//*[@class='aras-nav__label' and text()='" + list.get(i) + "']");
                $(firstElement).waitUntilClickable();
                reusableUtilities.performAction("Button", $(firstElement), "");
            }
            else {
                By otherElement = By.xpath("//ul[@class='aras-nav__child-container']//*[text()='" + list.get(i) + "']");;
                for(int j = 0; j< list.size(); j++){
                    if(list.get(j).equalsIgnoreCase("Template ECO") && list.get(j-1).equalsIgnoreCase("Parameter Management")){
                        otherElement = By.xpath("(//li[contains(@class,'aras-nav__child aras-nav__row') ]//*[text()='Template ECO'])[3]");
                    }
                    else if(list.get(j).equalsIgnoreCase("Parts") && list.get(j-1).equalsIgnoreCase("Product Design Reference Management")){
                        otherElement = By.xpath("(//li[contains(@class,'aras-nav__child aras-nav__row') ]//*[text()='Parts'])[3]");
                    }
                    else if(list.get(j).equalsIgnoreCase("ECOs") && list.get(j-1).equalsIgnoreCase("Product Design Reference Management")){
                        otherElement = By.xpath("(//li[contains(@class,'aras-nav__child aras-nav__row') ]//*[text()='ECOs'])[3]");
                    }
                    else if(list.get(j).equalsIgnoreCase("Template ECO") && list.get(j-1).equalsIgnoreCase("Change Management")){
                        otherElement = By.xpath("(//li[contains(@class,'aras-nav__child aras-nav__row') ]//*[text()='Template ECO'])[2]");
                    }
                    else if(list.get(j).equalsIgnoreCase("Global Products") && list.get(j-1).equalsIgnoreCase("Product Design Reference Management")){
                        otherElement = By.xpath("(//li[contains(@class,'aras-nav__child aras-nav__row') ]//*[text()='Global Products'])[2]");
                    }
                    else if(list.get(j).equalsIgnoreCase("Global Products") && list.get(j-1).equalsIgnoreCase("Product Portfolio and Project Management")){
                        otherElement = By.xpath("(//li[contains(@class,'aras-nav__child aras-nav__row') ]//*[text()='Global Products'])[3]");
                    }
                    else if(list.get(j).equalsIgnoreCase("Product Briefs") && list.get(j-1).equalsIgnoreCase("Product Portfolio and Project Management")){
                        otherElement = By.xpath("(//li[contains(@class,'aras-nav__child aras-nav__row') ]//*[text()='Product Briefs'])[2]");
                    }
                    else if(list.get(j).equalsIgnoreCase("Sellable Products") && list.get(j-1).equalsIgnoreCase("Product Design Reference Management")){
                        otherElement = By.xpath("(//li[contains(@class,'aras-nav__child aras-nav__row') ]//*[text()='Sellable Products'])[2]");
                    }
                    else if(list.get(j).equalsIgnoreCase("Product Variants") && list.get(j-1).equalsIgnoreCase("Product Design Reference Management")){
                        otherElement = By.xpath("(//li[contains(@class,'aras-nav__child aras-nav__row') ]//*[text()='Product Variants'])[2]");
                    }
                    else if(list.get(j).equalsIgnoreCase("Product Variants") && list.get(j-1).equalsIgnoreCase("Product Portfolio and Project Management")){
                        otherElement = By.xpath("(//li[contains(@class,'aras-nav__child aras-nav__row') ]//*[text()='Product Variants'])[3]");
                    }
                    else if(list.get(j).equalsIgnoreCase("Product ECOs") && list.get(j-1).equalsIgnoreCase("Product Portfolio and Project Management")){
                        otherElement = By.xpath("(//li[contains(@class,'aras-nav__child aras-nav__row') ]//*[text()='Product ECOs'])[3]");
                    }
                    else if(list.get(0).equalsIgnoreCase("Product ECOs")){
                        otherElement = By.xpath("(//li[contains(@class,'aras-nav__child aras-nav__row') ]//*[text()='Product ECOs'])");
                    }
                    else if(list.get(0).equalsIgnoreCase("Product ECO")){
                        otherElement = By.xpath("(//li[contains(@class,'aras-nav__child aras-nav__row') ]//*[text()='Product ECO'])");
                    }

                }
                if($(otherElement).isCurrentlyVisible()) {
                    waitABit(2000);
                    $(otherElement).waitUntilClickable();
                    reusableUtilities.performAction("Button", $(otherElement),"");
                }
                else {
                    otherElement = By.xpath("//*[@class='aras-secondary-menu__buttons-container']//*[text()='"+list.get(i)+"']");
                    $(otherElement).waitUntilClickable();
                    waitABit(10000);
                    reusableUtilities.performAction("Button", $(otherElement), "");
                }
            }
            waitABit(8000);

        }
        list.clear();
    */}



}
