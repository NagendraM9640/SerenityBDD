package starter.PageObjectsPages;


import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import starter.Utility.ReusableUtilities;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
public class ARAS_ReusablePage extends PageObject {
    public static EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
    public static By closeTabButton=By.cssSelector("div.aras-tabs__list-container span.aras-icon-close");
    static By searchTable=By.xpath("//aras-grid[@id='gridTD']//div[@class='aras-grid-body-boundary']//table");
    static By searchButton1=By.xpath("//button[@title='Run Search']//span[text()='Search']");
    static By filterColumn=By.xpath("//div[@class='aras-grid-header']/div[@class='aras-grid-header-boundary']/table//th[1]");
    static By filterColumnvalue=By.xpath("//div[@class='aras-grid-header']/div[@class='aras-grid-header-boundary']/table//tr[2]/td[1]/input");
    static By firstColumn=By.xpath("//aras-grid[@id='gridTD']//div[@class='aras-grid-body-boundary']//table/tr[1]/td[1]");
    static By itemDetailpage=By.xpath("//span[@data-id='itemview.titlebar.default.title']");
    static By itemCode=By.name("item_number");
    static By calendarGrid=By.xpath("//table[@class='dijitCalendarContainer dijitCalendar']");
    static By calendarSelection=By.xpath("//input[@title='Query Date']");
    static By calendarCurrentYr=By.xpath("//span[@id='Aras_Client_Controls_Experimental_CalendarLite_0_year']");
    static By calendarPrevYr=By.xpath("//span[@class='dijitInline dijitCalendarPreviousYear']");
    static By calendarNextYr=By.xpath("//span[@class='dijitInline dijitCalendarNextYear']");
    static By calendarCurrentMnth=By.xpath("//div[@class='dijitCalendarMonthLabel dijitCalendarCurrentMonthLabel']");
    static By calendarDecrementMnth=By.xpath("//div[@class='dijitCalendarMonthLabel dijitCalendarCurrentMonthLabel']");
    static By arasSpinner=By.xpath("//iframe[@id='dimmer_spinner']");
    static By QueryType=By.xpath("//span[@data-id='searchview.commandbar.default.querytype']//select");
    static By closeButton=By.xpath("//span[@class='aras-dialog__close-button aras-icon-close']");
    static By searchCloseButtonTab0=By.xpath("//li[contains(@data-id,'search_')]//span[@class='aras-icon-close']");
    static By searchCloseButton=By.xpath("//span[@class='aras-icon-close']");
    static By moreButton=By.xpath("//button[@title='More']");
    public static By deleteButton=By.xpath("//span[text()='Delete']");
    static By deleteAllVersionButton=By.xpath("//span[text()='Delete All Versions']");
    static By deleteCancelButton=By.xpath("//input[@id='btnCancel']");
    static By deleteOKButton=By.xpath("//input[@id='btnYes']");
    static By createButtonTextBox=By.xpath("//span[@data-id='filterStructureItemsExpression']/input");
    static By newFrameToDeleteDocument = By.xpath("//*[@class='aras-dialog__iframe']");
    static By okButtonToDeleteDocument = By.xpath("//*[@id='btnYes']");
    String title = variables.getProperty("title");
    By frameSwitch=By.xpath("//iframe[contains(@name,'innovator_')]");
    By frameSwitchDetail=By.id("instance");
    By frame_dialog=By.xpath("//iframe[@class='aras-dialog__iframe']");
    By frameSwitchSearch=By.xpath("//iframe[contains(@name,'search_')]");
    By tableColumns = By.xpath("//div[@class='aras-grid-header-boundary']/table[@class='aras-grid-head']/tr[1]/th");
    By nameLabel=By.xpath("//span[@name='name_label']");
    By deleteButtonCreate=By.xpath("//button[@title='Delete']");
    By titlePage = (By.xpath("//span[@class='aras-toolbar__item aras-toolbar__text aras-toolbar__title'][contains(text(),'Part')]"));
    ReusableUtilities reusableUtilities;
    String scenarioName_Search = variables.getProperty("scenarioName_Search");
    By searchButton = By.xpath("//*[text()='Search Parts']");
    String searchValue = variables.getProperty("searchValue");
    String scenarioName_Create = variables.getProperty("scenarioName_Create");
    String createPartTextValue = variables.getProperty("createPartTextValue");
    String createType=createPartTextValue.split("/")[1];
    By createNewButton = By.xpath("//*[text()='Create New Part']");
    public static ReusableUtilities comm=new ReusableUtilities();


    public List<String> verifySearchTable()
    {
        // try {
        $(ARASHomePageObjects.NavigationTool).click();
        withTimeoutOf(90, TimeUnit.SECONDS).waitForPresenceOf(searchButton);
        $(searchButton).click();
        Serenity.getDriver().switchTo().frame((WebElement) $(frameSwitchSearch));
        withTimeoutOf(90, TimeUnit.SECONDS).waitForPresenceOf(searchTable);
        List<WebElement> Options= Serenity.getDriver().findElements(tableColumns);
        List<String> columnHeader = new ArrayList<String>();
        for(int limit=1;limit<Options.size();limit++)
        {
            String columnValue= Serenity.getDriver().findElement(By.xpath("//div[@class='aras-grid-header-boundary']/table[@class='aras-grid-head']/tr[1]/th["+limit+"]/span/span[1]")).getText();
            //System.out.print(columnValue);
            columnHeader.add(columnValue);
        }
        return columnHeader;
        // }catch(Exception e)
        //{
        //    e.printStackTrace();
        //  }
    }
    public void verifyDetailsPage() {
        // try{
        withTimeoutOf(90, TimeUnit.SECONDS).waitForPresenceOf(searchTable);
        if ($(filterColumn).isCurrentlyVisible()) {
            String text = $(filterColumn).getText();
        }
        if ($(filterColumnvalue).isClickable()) {
            comm.performAction("Text", $(filterColumnvalue),searchValue);
            $(filterColumnvalue).sendKeys(Keys.ENTER);
        }
        withTimeoutOf(90, TimeUnit.SECONDS).waitForPresenceOf(firstColumn);
        if ($(firstColumn).isDisplayed()) {
            assert ($(firstColumn).isDisplayed());
            withAction().doubleClick($(firstColumn)).perform();
        }
        Serenity.getDriver().switchTo().defaultContent();
        $(searchCloseButtonTab0).click();
        // }catch(Exception e)
        // {
        //     e.printStackTrace();
        //  }
    }
    public void validateDetailsPage() {
        //   try
        //  {
        Serenity.getDriver().switchTo().frame((WebElement) $(frameSwitch));
        if($(itemDetailpage).isDisplayed()){
            assert ($(itemDetailpage).getText().contains(searchValue));
            Serenity.getDriver().switchTo().frame((WebElement) $(frameSwitchDetail));
            assert ($(itemCode).isDisplayed());
            Serenity.getDriver().switchTo().defaultContent();
            Serenity.getDriver().switchTo().frame((WebElement) $(frameSwitch));
            $(moreButton).click();
            $(deleteButton).click();
            if($(deleteAllVersionButton).isDisplayed())
            {
                $(deleteAllVersionButton).click();
                Serenity.getDriver().switchTo().frame((WebElement) $(frame_dialog));
                $(deleteCancelButton).click();
            }
        }
        Serenity.getDriver().switchTo().defaultContent();
        $(searchCloseButton).click();
//        {
        //         e.printStackTrace();
        //      }
    }
    public void selectDateInCalendar() {
        //     try
        //     {
        String date = variables.getProperty("date");
        String month = variables.getProperty("month");
        String year = variables.getProperty("year");
        WebElement element = $(calendarGrid);
        Serenity.getDriver().switchTo().frame((WebElement) $(frameSwitchSearch));
        boolean test = $(searchButton1).isDisplayed();
        withTimeoutOf(90, TimeUnit.SECONDS).waitForPresenceOf($(QueryType));
        Select select = new Select($(QueryType));
        select.selectByValue("Effective");
        withTimeoutOf(90, TimeUnit.SECONDS).waitForPresenceOf($(element));
        if ($(element).isCurrentlyVisible()) {
            $(element).click();
            while ($(calendarCurrentYr).getText() == year) {
                if (Integer.parseInt($(calendarCurrentYr).getText()) < Integer.parseInt(year)) {
                    $(calendarNextYr).click();
                }
                if (Integer.parseInt($(calendarCurrentYr).getText()) > Integer.parseInt(year)) {
                    $(calendarPrevYr).click();
                }
            }
            while ($(calendarCurrentMnth).getText() == month) {
                $(calendarDecrementMnth).click();
            }
            $(By.xpath("//span[@class='dijitCalendarDateLabel'][text()=" + date + "]")).click();
        }
        // }catch(Exception e)
        // {
        //     e.printStackTrace();
        // }
    }
    public void createNewScenario(){
        try{
            withTimeoutOf(90, TimeUnit.SECONDS).waitForPresenceOf(createNewButton);
            $(createNewButton).click();
            withTimeoutOf(90, TimeUnit.SECONDS).waitForPresenceOf(closeButton);
            $(closeButton).click();
            withTimeoutOf(90, TimeUnit.SECONDS).waitFor(ExpectedConditions.invisibilityOf($(arasSpinner)));
            //Serenity.getDriver().switchTo().frame((WebElement) $(frameSwitchDetail));
            //withTimeoutOf(90, TimeUnit.SECONDS).waitForPresenceOf(itemCode);
            Serenity.getDriver().switchTo().defaultContent();
            $(searchCloseButton).click();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void searchScenario(){
        try{
            $(ARASHomePageObjects.NavigationTool).click();
            withTimeoutOf(90, TimeUnit.SECONDS).waitForPresenceOf(searchButton);
            $(searchButton).click();
            withTimeoutOf(90, TimeUnit.SECONDS).waitFor(ExpectedConditions.invisibilityOf($(arasSpinner)));
            Serenity.getDriver().switchTo().frame((WebElement) $(frameSwitchSearch));
            withTimeoutOf(90, TimeUnit.SECONDS).waitForPresenceOf(titlePage);
            Serenity.getDriver().switchTo().defaultContent();
            $(searchCloseButton).click();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void quickSearchScenario() {
        try{
            $(ARASHomePageObjects.NavigationTool).click();
            String searchCriteria = variables.getProperty("searchValue");
            By quickSearch = (By.xpath("//input[@class='aras-input aras-quick-search__input']"));
            comm.performAction("Text", $(quickSearch),searchCriteria);
            $(quickSearch).sendKeys(Keys.ENTER);
            withTimeoutOf(90, TimeUnit.SECONDS).waitFor(ExpectedConditions.invisibilityOf($(arasSpinner)));
            Serenity.getDriver().switchTo().frame((WebElement) $(frameSwitch));
            withTimeoutOf(90, TimeUnit.SECONDS).waitForPresenceOf(itemDetailpage);
            if ($(itemDetailpage).isDisplayed()) {
                assert ($(itemDetailpage).getText().contains(searchCriteria));
                Serenity.getDriver().switchTo().defaultContent();
                Serenity.getDriver().switchTo().frame((WebElement) $(frameSwitchDetail));
                assert ($(itemCode).isDisplayed());
                Serenity.getDriver().switchTo().defaultContent();
                $(searchCloseButton).click();
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public void createPopUpHandle() {
        // try {
        //$(ARASHomePageObjects.NavigationTool).click();
        withTimeoutOf(90, TimeUnit.SECONDS).waitForPresenceOf(createNewButton);
        $(createNewButton).click();
        withTimeoutOf(90, TimeUnit.SECONDS).waitForPresenceOf(closeButton);
        Serenity.getDriver().switchTo().frame((WebElement) $(frame_dialog));
        withTimeoutOf(90, TimeUnit.SECONDS).waitForPresenceOf(createButtonTextBox);
        comm.performAction("Text", $(createButtonTextBox),createPartTextValue);
        $(createButtonTextBox).sendKeys(Keys.ENTER);
        List<WebElement> childNode=Serenity.getDriver().findElements(By.xpath("//aras-class-structure[@class='aras-class-structure aras-nav_non-editable']//li[@class='aras-nav__parent aras-nav__parent_expanded']/child::node()"));
        for(int child=0;child<childNode.size();child++)
        {
            WebElement ChildElement =Serenity.getDriver().findElement(By.xpath("//aras-class-structure[@class='aras-class-structure aras-nav_non-editable']//li[@class='aras-nav__parent aras-nav__parent_expanded']//span[2]"));
            System.out.println("Second:"+ ChildElement.getAttribute("innerText").toString().trim());
            if(ChildElement.getAttribute("innerText").toString().trim().equalsIgnoreCase(createType))
            {
                //ChildElement.click();
                withAction().doubleClick(ChildElement).perform();
                break;
            }
        }
        Serenity.getDriver().switchTo().defaultContent();
    }
    public void deletePart() {
        Serenity.getDriver().switchTo().frame((WebElement) $(frameSwitchDetail));
        assert ($(itemCode).isDisplayed());
        //  assert ($(nameLabel).getText()).equalsIgnoreCase(createType);
        Serenity.getDriver().switchTo().defaultContent();
        Serenity.getDriver().switchTo().frame((WebElement) $(frameSwitch));
        /*$(moreButton).click();
        $(deleteButton).click();
        waitABit(2000);
        if($(deleteAllVersionButton).isDisplayed());*/
        comm.clickUsingJavaScriptExecutor($(deleteAllVersionButton));
        comm.switchFrame($(newFrameToDeleteDocument),"",0);
        comm.conditionalWait("visibility", okButtonToDeleteDocument, "");
        comm.clickUsingJavaScriptExecutor($(okButtonToDeleteDocument));
    }
}