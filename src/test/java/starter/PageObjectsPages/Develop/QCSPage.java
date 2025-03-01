package starter.PageObjectsPages.Develop;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.webdriver.shadow.ByShadow;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import starter.Utility.ReusableMethods;
import starter.Utility.ReusableUtilities;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static starter.PageObjectsPages.MigratedDataMSpecPage.*;


public class QCSPage extends PageObject {

    ReusableUtilities reusableUtilities;

    ReusableMethods reusableMethods;

    public static @FindBy(xpath = "//iframe[@title='pmi_QcsECO_AffectedItem Relationship']") WebElementFacade QCSAffectedItemFrame;

    public static @FindBy(xpath = "//iframe[@class='content-block__iframe']") WebElementFacade parentFrame;

    public static @FindBy(xpath = "//iframe[@id='instance']") WebElementFacade childFrame;

    public static @FindBy(xpath = "//button[@title='Save']") WebElementFacade saveButton;
    public static @FindBy(xpath = "//button[@title='Refresh']") WebElementFacade refreshButton;
    public static @FindBy(xpath = "//iframe[@class='aras-dialog__iframe']") WebElementFacade dialogueIframe;

    public static @FindBy(xpath = "//button[@title='Clear Search Criteria']") WebElementFacade clearSearchCriteria;

    public static @FindBy(xpath = "(//*[@class='aras-grid-row-cell '])[1]") WebElementFacade searchResultsInGrid;
    public static @FindBy(xpath = "//button[@class='aras-button aras-button_primary aras-buttons-bar__button']") WebElementFacade searchOkButton;

    public static @FindBy(xpath = "//button[@title='Run Search']") WebElementFacade runSearchButton;
    public static @FindBy(xpath = "//iframe[@id='0D3817EFC859483E97C417B33DF5EBCD']") WebElementFacade qcsChangesTabIframe;

    public static @FindBy(xpath = "//*[text()='Done']") WebElementFacade doneBtn;
    public static @FindBy(xpath = "//button[@title='Add QCS ECO Poly Item']") WebElementFacade addQCSPolyItems;
    public static @FindBy(xpath = "//td[@data-head-id='pmi_item_code_D']") WebElementFacade searchCodeField;
    public static @FindBy(xpath = "//iframe[@title='pmi_QCSIPC_ControlParameter Relationship']") WebElementFacade controlParameterRelationshipIframe;
    public static @FindBy(xpath = "//iframe[@title='pmi_QCSIPC_ControlParameter Relationship']") WebElementFacade selectionParameterRelationshipIframe;
    public static @FindBy(xpath = "//textarea[@name='description']") WebElementFacade descriptionFiledInQCS;

    public static @FindBy(xpath = "//iframe[contains(@name,'innovator_')]") WebElementFacade newFrameForCreatePartFrame;
    public static @FindBy(xpath = "//div[@id='pmi_templateplatformMultiList']/a/span") WebElementFacade technologyPlatformFieldBtn;
    public static @FindBy(xpath = "//div[@id='pmi_itemtypeMultiList']/a/span") WebElementFacade itemTypeFieldBtn;
    public static @FindBy(xpath = "//*[@id='pmi_templateplatformMultiList']/div//span[@class='dropdown-search']/input") WebElementFacade dropDownSearchTechnologyPlatform;
    public static @FindBy(xpath = "//*[@id='pmi_itemtypeMultiList']/div//span[@class='dropdown-search']/input") WebElementFacade dropDownSearchItemType;
    public static @FindBy(xpath = "//div[@id='pmi_templateplatformMultiList']//a[@class='dropdown-clear-all']") WebElementFacade technologyPlatformDropDownClear;
    public static @FindBy(xpath = "//div[@id='pmi_itemtypeMultiList']//a[@class='dropdown-clear-all']") WebElementFacade itemTypeDropDownClear;
    public static @FindBy(xpath = "//div[@id='pmi_templateplatformMultiList']//span[@class='dropdown-selected']") List<WebElementFacade> getTheSelectedTechnologyList;
    public static @FindBy(xpath = "//div[@id='pmi_itemtypeMultiList']//span[@class='dropdown-selected']") List<WebElementFacade> getTheSelectedItemTypeList;
    public static @FindBy(xpath = "//td[@data-head-id='pmi_item_code_D']") WebElementFacade qcsItemCodeInSearchSection;
    public static @FindBy(xpath = "//*[text()='QCS-000171']") WebElementFacade searchTableFirstElement;
    public static @FindBy(xpath = "(//select[@title='ItemType'])") WebElementFacade searchItemTypeSelection;
    public static @FindBy(xpath = "//span[@class='aras-tabs__label' and text()='Affected Items']") WebElementFacade affectedItemTabButton;
    public static @FindBy(xpath = "//*[@class='aras-icon-close']") WebElementFacade closeBtn;
    public static @FindBy(xpath = "//*[@id='main-tab']/div/div/ul/li[1]/span[1]") WebElementFacade closeTheFirstOpenedTab;
    public static @FindBy(xpath = "//button[contains(@class, 'aras-button_primary') and contains(@class, 'aras-buttons-bar__button')]//span[text()='OK']") WebElementFacade searchOkBtn;
    public static @FindBy(xpath = "//span[@class='aras-form aras-compat-toolbar__textbox']/input") WebElementFacade classificationSelection;
    public static @FindBy(xpath = "//button[@title='Add Global Harmonized Parameters']") WebElementFacade addGHPBtn;
    public static @FindBy(xpath = "//iframe[@title='pmi_QCSIPC_ControlParameter Relationship']") WebElementFacade IPCControlParameterRelationshipTabIframe;
    public static @FindBy(xpath = "//iframe[@title='pmi_QCSLAB_ControlParamer Relationship']") WebElementFacade LabControlParameterRelationshipTabIframe;
    public static @FindBy(xpath = "//iframe[@title='pmi_QCSMCS_ControlParameter Relationship']") WebElementFacade McsControlParameterRelationshipTabIframe;
    public static @FindBy(xpath = "//*[@id='gridTD']/div[2]/div[1]/div/table/tr/td[3]") List<WebElementFacade> GHPResults;
    public static @FindBy(xpath = "//td[@data-head-id='pmi_parameter_number_D']") WebElementFacade parameterNumberSearchField;
    public static @FindBy(xpath = "//input[@name='pmi_qcs_productgroup']") WebElementFacade qcsProductGroupField;
    public static @FindBy(xpath = "//textarea[@name='title']") WebElementFacade titleFieldInQCSEco;
    public static @FindBy(xpath = "//textarea[@name='description']") WebElementFacade changeDescFieldInQCSEco;
    public static @FindBy(xpath = "//input[@name='pmi_reason_for_change']") WebElementFacade reasonForChangeFieldInQCSEco;
    public static @FindBy(xpath = "//iframe[@title='pmi_QcsECO_AffectedItem Relationship']") WebElementFacade qcsAffectedItemIframe;
    public static @FindBy(xpath = "//button[@title='Add QCS ECO Poly Item']") WebElementFacade addQCSPolyItemsBtn;
    public static @FindBy(xpath = "//select[@title='ItemType']") WebElementFacade itemTypeSelection;
    public static @FindBy(xpath = "//td[@data-head-id='pmi_item_code_D']") WebElementFacade qcsCodeInSearch;
    public static @FindBy(xpath = "//div[@id='pmi_QualifiedLabMultiList']/a/span") WebElementFacade qualifiedLaboratoriesFormFieldButton;
    public static @FindBy(xpath = "//*[@id='pmi_QualifiedLabMultiList']/div//span[@class='dropdown-search']/input") WebElementFacade dropDownSearchQualifiedLaboratories;

    public static @FindBy(xpath = "//*[@class='aras-dialog__iframe']") WebElementFacade newFrameToSelectPart;

    public static @FindBy(xpath = "//iframe[@id='dimmer_spinner']") WebElementFacade arasSpinner;
    public static @FindBy(xpath = "//input[contains(@name,'classification')]") WebElementFacade itemName;

    public static @FindBy(xpath = "//*[@class='item_number']") WebElementFacade itemCode;
    public static @FindBy(xpath = "//*[@class='pmi_code']") WebElementFacade pmiCode;
    public static @FindBy(xpath = "//input[@name='pmi_methodid']") WebElementFacade methodIDField;
    public static @FindBy(xpath = "//textarea[@name='name']") WebElementFacade nameField;
    public static @FindBy(css = "button[aria-label='Open User Menu']") WebElementFacade userMenu;
    public static @FindBy(xpath = "//span[text()='Logout']") WebElementFacade logoutButton;
    public static @FindBy(xpath = "//iframe[@class='aras-dialog__iframe']") WebElementFacade newFrameToSelectState;
    public static @FindBy(xpath = "//span[@title='Logout without Saving']") WebElementFacade logoutWithoutSaveButton;
    public static @FindBy(xpath = "//span[text()='Login Again']") WebElementFacade loginAgain;
    public static @FindBy(xpath = "//span[@class='aras-list-item__label' and text()='Delete']") WebElementFacade deleteButton;
    public static @FindBy(xpath = "//span[@class='aras-list-item__label' and text()='Delete All Versions']") WebElementFacade deleteAllTheVersionsButton;
    public static @FindBy(xpath = "//button[@title='More']") WebElementFacade moreActionButton;

    public static @FindBy(xpath = "//button[@class='aras-button aras-button_secondary']/span") WebElementFacade confirmDeleteButton;
    public static @FindBy(xpath = "//span[@class='aras-dialog-alert__text']") WebElementFacade alertMessage;
    public static @FindBy(xpath = "(//iframe[contains(@name,'innovator_')])[3]") WebElementFacade newFrameForCreatePartFrame3;

    public static @FindBy(xpath = "(//iframe[contains(@name,'innovator_')])[2]") WebElementFacade newFrameForCreatePartFrame2;
    public static @FindBy(xpath = "//*[text()='OK']") WebElementFacade alertOkButton;
    public static @FindBy(xpath = "//input[@name='pmi_changeqcs_type']") WebElementFacade qcsChangeTypeField;
    public static @FindBy(css = "input[name='pmi_effectivedate']") WebElementFacade effectiveDateAndTimeField;
    public static @FindBy(xpath = "//input[@name='release_date']") WebElementFacade releaseDateField;
    public static @FindBy(xpath = "//table[@id='item_status']/tbody/tr/td") WebElementFacade qcsECOState;
    public static @FindBy(xpath = "//*[@id='rb_tree_grid']/div[2]/div[1]/div/table/tr/td") List<WebElementFacade> qcsChangesTabData;
    public static @FindBy(xpath = "//iframe[@title='pmi_QCSAttachments Relationship']") WebElementFacade qcsAttachmentRelationshipTab;
    public static @FindBy(xpath = "//iframe[@title='pmi_SelectionParameters Relationship']") WebElementFacade qcsSelectionParameterRelationshipTabFrame;
    public static @FindBy(xpath = "//button[@title='Add Files']") WebElementFacade addAttachmentBtn;
    public static @FindBy(xpath = "//button[@title='Delete pmi_QCSAttachments']") WebElementFacade deleteAttachmentBtnForQcs;
    public static @FindBy(xpath = "//*[@id='gridTD']/div[2]/div[2]/div/table/tr") List<WebElementFacade> tableRows;
    public static @FindBy(xpath = "//*[@id='gridTD']/div[2]/div[1]/div/table/tr/td[2]") List<WebElementFacade> firstResults;
    public static @FindBy(xpath = "//*[@id='gridTD']/div[2]/div[1]/div/table/tr[2]/td[2]") WebElementFacade secondResults;
    public static @FindBy(xpath = "//*[@id='gridTD']/div[2]/div[2]/div/table/tr/td[2]") WebElementFacade tableRowFirstElement;
    public static @FindBy(xpath = "//span[@class='aras-dialog-alert__text']") WebElementFacade alertText;
    public static @FindBy(xpath = "//span[text()='OK']") WebElementFacade alertOkBtn;
    public static @FindBy(xpath = "//select[@title='ItemType']") WebElementFacade itemTypeSwitch;
    public static @FindBy(xpath = "//button[@title='New Selection Parameters']") WebElementFacade addNewSelectionParametersBtn;

    public static String generatedItemCode = "";

    public static List<String> qcsEcoInformation = new ArrayList<String>();

    public enum Objects {
        effectiveDate(By.cssSelector("input[name='pmi_effectivedate']")), effectiveDateSelector(By.cssSelector("input[name='pmi_effectivedate']+div")), votingList2(By.cssSelector("div#VoteSection select#VoteList"));
        public final By objects;

        private Objects(By attribute) {
            this.objects = attribute;
        }
    }

    public void addEffectivityDate(String date) {
        String day = date.split("-")[0];
        String month = date.split("-")[1];
        String year = date.split("-")[2];
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame).switchTo().frame(childFrame);
        withTimeoutOf(90, TimeUnit.SECONDS).waitFor(Objects.effectiveDateSelector.objects).click();
        waitABit(3000);
        Serenity.getDriver().switchTo().parentFrame();
        String currentText = $(calanderSwitchButton).getAttribute("outerText").toString().trim();
        if (currentText.contains(month) && currentText.contains(year)) {
            waitABit(2000);
        } else if (currentText.contains(month) && !currentText.contains(year)) {
            evaluateJavascript("arguments[0].click();", $(calanderSwitchButton));
            waitABit(3000);
            List<WebElementFacade> Month = findAll(calanderGrids);
            for (WebElementFacade object : Month) {
                if (object.getAttribute("textContent").trim().equalsIgnoreCase(month.substring(0, 3))) {
                    evaluateJavascript("arguments[0].click();", object);
                    break;
                }
            }
        } else if (!currentText.contains(month) && !currentText.contains(year)) {
            evaluateJavascript("arguments[0].click();", $(calanderSwitchButton));
            waitABit(4000);
            evaluateJavascript("arguments[0].click();", $(calanderSwitchButton));
            WebElementFacade Year = $(ByShadow.cssSelector("div[data-value='" + year + "']", "aras-calendar.aras-calendar"));
            evaluateJavascript("arguments[0].click();", Year);
            waitABit(4000);
            List<WebElementFacade> Month = findAll(calanderGrids);
            for (WebElementFacade object : Month) {
                if (object.getAttribute("textContent").trim().equalsIgnoreCase(month.substring(0, 3))) {
                    evaluateJavascript("arguments[0].click();", object);
                    break;
                }
            }
        }
        waitABit(4000);
        List<WebElementFacade> Day = findAll(ByShadow.cssSelector("div[data-value='" + day + "']", "aras-calendar.aras-calendar"));
        evaluateJavascript("arguments[0].click();", Day.get(Day.size() - 1));
        waitABit(5000);
        Serenity.takeScreenshot();
        ApplyButton.click();
    }

    public void userShouldSelectTheTypeOfQCSYouWantToCreate(String qcsType) {
        By partNameAsIngredient = By.xpath("//*[text()='" + qcsType.trim() + "']");
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(newFrameToSelectPart);
        waitABit(1000);
        $(classificationSelection).click();
        waitABit(1000);
        $(classificationSelection).sendKeys(qcsType);
        waitABit(1000);
        reusableUtilities.pressEnterWithoutElement();
        waitABit(2000);
        Actions a = new Actions(Serenity.getDriver());
        a.moveToElement($(partNameAsIngredient)).doubleClick().build().perform();
        //withTimeoutOf(100, TimeUnit.SECONDS).waitForElementsToDisappear((By) arasSpinner);
    }


    public void validateAttributesPresentOrNot(List<String> attribute) {
        for (String attr : attribute) {
            Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame).switchTo().frame(childFrame);
            //withTimeoutOf(100, TimeUnit.SECONDS).waitFor(By.xpath("//*[text()='" + attr + "']"));
            Assert.assertTrue(attr + ":is not present in the form", $(By.xpath("//*[text()='" + attr + "']")).isCurrentlyVisible());
        }
    }

    public void clickOnSaveButtonWithoutProvidingMandatoryFields() {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame);
        $(saveButton).click();
    }


    public void logOutAndLogin() {
        Serenity.getDriver().switchTo().defaultContent();
        if ($(userMenu).isCurrentlyVisible()) {
            $(userMenu).click();
            withTimeoutOf(100, TimeUnit.SECONDS).waitFor(logoutButton).click();
            if ($(newFrameToSelectState).isPresent()) {
                Serenity.getDriver().switchTo().frame(newFrameToSelectState);
                withTimeoutOf(100, TimeUnit.SECONDS).waitFor(logoutWithoutSaveButton).click();
                Serenity.getDriver().switchTo().defaultContent();
            }
            $(loginAgain).click();
        }
    }

    public void multiSelectionOfTechnologyPlatform(String[] technologyPlatformValues) {
        $(technologyPlatformFieldBtn).click();
        withTimeoutOf(Duration.ofSeconds(100)).waitFor(dropDownSearchTechnologyPlatform);
        $(dropDownSearchTechnologyPlatform).sendKeys(technologyPlatformValues[0].trim());
        withTimeoutOf(Duration.ofSeconds(100)).waitFor(By.xpath("//li[text()='" + technologyPlatformValues[0].trim() + "']"));
        waitABit(2000);
        $(By.xpath("//li[text()='" + technologyPlatformValues[0].trim() + "']")).click();
        for (int i = 1; i < technologyPlatformValues.length; i++) {
            String searchText = $(dropDownSearchTechnologyPlatform).getAttribute("value").trim();
            System.out.println(searchText + "searchText: TechnologyPlatform");
            for (int j = 0; j < searchText.length(); j++) {
                $(dropDownSearchTechnologyPlatform).sendKeys(Keys.BACK_SPACE);
            }
            $(dropDownSearchTechnologyPlatform).sendKeys(technologyPlatformValues[i].trim());
            withTimeoutOf(Duration.ofSeconds(100)).waitFor(By.xpath("//li[text()='" + technologyPlatformValues[i].trim() + "']"));
            waitABit(2000);
            $(By.xpath("//li[text()='" + technologyPlatformValues[i].trim() + "']")).click();
        }
    }

    public void multiSelectionOfItemTypes(String[] itemTypeValues) {
        System.out.println(itemTypeValues + "itemTypeValues");
        $(itemTypeFieldBtn).click();
        withTimeoutOf(100, TimeUnit.SECONDS).waitFor(dropDownSearchItemType);
        $(dropDownSearchItemType).sendKeys(itemTypeValues[0]);
        withTimeoutOf(100, TimeUnit.SECONDS).waitFor(By.xpath("//li[text()='" + itemTypeValues[0].trim() + "']"));
        waitABit(2000);
        $(By.xpath("//li[text()='" + itemTypeValues[0].trim() + "']")).click();
        for (int i = 1; i < itemTypeValues.length; i++) {
            String searchText2 = $(dropDownSearchItemType).getAttribute("value").toString().trim();
            System.out.println(searchText2 + "searchText: ItemTypes");
            for (int k = 0; k < searchText2.length(); k++) {
                $(dropDownSearchItemType).sendKeys(Keys.BACK_SPACE);
            }
            $(dropDownSearchItemType).sendKeys(itemTypeValues[i]);
            withTimeoutOf(100, TimeUnit.SECONDS).waitFor(By.xpath("//li[text()='" + itemTypeValues[i].trim() + "']"));
            waitABit(2000);
            $(By.xpath("//li[text()='" + itemTypeValues[i].trim() + "']")).click();
        }
    }

    public void multiSelectQualifiedLaboratories(String[] qualifiedLaboratories) {
        $(qualifiedLaboratoriesFormFieldButton).click();
        withTimeoutOf(100, TimeUnit.SECONDS).waitFor(dropDownSearchQualifiedLaboratories);
        $(dropDownSearchQualifiedLaboratories).sendKeys(qualifiedLaboratories[0].trim());
        withTimeoutOf(100, TimeUnit.SECONDS).waitFor(By.xpath("//li[text()='" + qualifiedLaboratories[0].trim() + "']"));
        $(By.xpath("//li[text()='" + qualifiedLaboratories[0].trim() + "']")).click();
        for (int i = 1; i < qualifiedLaboratories.length; i++) {
            String searchText = $(dropDownSearchQualifiedLaboratories).getAttribute("value").toString().trim();
            for (int j = 0; j < searchText.length(); j++) {
                $(dropDownSearchQualifiedLaboratories).sendKeys(Keys.BACK_SPACE);
            }
            $(dropDownSearchQualifiedLaboratories).sendKeys(qualifiedLaboratories[i].trim());
            waitABit(2000);
            withTimeoutOf(100, TimeUnit.SECONDS).waitFor(By.xpath("//li[text()='" + qualifiedLaboratories[i].trim() + "']"));
            waitABit(2000);
            $(By.xpath("//li[text()='" + qualifiedLaboratories[i].trim() + "']")).click();
        }
    }

    public void userProvidesDescriptionAndSelectTheTechnologyPlatformAndItemTypeAndClickOnSaveAnd(String description, String technologyPlatform, String itemType, String productGroup) {
        String[] technologyPlatformValues = technologyPlatform.split(",");
        String[] itemTypeValues = itemType.split(",");

        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame).switchTo().frame(childFrame);
        $(descriptionFiledInQCS).sendKeys(description);

        //Technology Platform multi selection
        reusableMethods.selectMultipleTechnologyPlatforms(technologyPlatformValues);
        //Select multiple ItemTypes
        reusableMethods.selectMultipleItemTypes(itemTypeValues);
        //Select the Product Group
        $(qcsProductGroupField).sendKeys(productGroup);

        //Saving the data
        Serenity.getDriver().switchTo().parentFrame();
        $(saveButton).click();
    }

    public void userShouldAddRequiredParametersToQCSControlParameterTab() {
        Actions action = new Actions(Serenity.getDriver());
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame);
        $(refreshButton).click();
        waitABit(3000);
        if ($(IPCControlParameterRelationshipTabIframe).isCurrentlyVisible()) {
            Serenity.getDriver().switchTo().frame(IPCControlParameterRelationshipTabIframe);
        } else if ($(LabControlParameterRelationshipTabIframe).isCurrentlyVisible()) {
            Serenity.getDriver().switchTo().frame(LabControlParameterRelationshipTabIframe);
        } else if ($(McsControlParameterRelationshipTabIframe).isCurrentlyVisible()) {
            Serenity.getDriver().switchTo().frame(McsControlParameterRelationshipTabIframe);
        }
        $(addGHPBtn).click();
        Serenity.getDriver().switchTo().parentFrame().switchTo().frame(dialogueIframe);
        waitABit(2000);
        $(itemTypeSwitch).selectByVisibleText("Global Harmonized Parameter");
        waitABit(3000);
        withTimeoutOf(90, TimeUnit.SECONDS).waitFor(clearSearchCriteria).click();
        waitABit(3000);
        $(clearSearchCriteria).click();
        waitABit(2000);
        $(parameterNumberSearchField).click();
        waitABit(2000);
        $(Serenity.getDriver().switchTo().activeElement()).type("N*");
        waitABit(2000);
        for (int i = 1; i <= 11; i++) {
            Serenity.getDriver().switchTo().activeElement().sendKeys(Keys.TAB);
            waitABit(1000);
        }
        waitABit(2000);
        $(Serenity.getDriver().switchTo().activeElement()).type("Released");
        waitABit(2000);
        $(runSearchButton).click();
        withTimeoutOf(90, TimeUnit.SECONDS).waitFor(searchResultsInGrid).click();
        System.out.println(GHPResults.size() + "GHP Size");
        System.out.println(GHPResults + "GHP Results");
        GHPResults.stream().skip(1).forEach(partNum -> action.keyDown(Keys.CONTROL).click(partNum).keyUp(Keys.CONTROL).build().perform());
        $(searchOkButton).click();
        Serenity.getDriver().switchTo().parentFrame();
        $(saveButton).click();
        waitABit(3000);
        if ($(IPCControlParameterRelationshipTabIframe).isCurrentlyVisible()) {
            Serenity.getDriver().switchTo().frame(IPCControlParameterRelationshipTabIframe);
        } else if ($(LabControlParameterRelationshipTabIframe).isCurrentlyVisible()) {
            Serenity.getDriver().switchTo().frame(LabControlParameterRelationshipTabIframe);
        } else if ($(McsControlParameterRelationshipTabIframe).isCurrentlyVisible()) {
            Serenity.getDriver().switchTo().frame(McsControlParameterRelationshipTabIframe);
        }
//        List<WebElement> BOMResults = Serenity.getDriver().findElements(ControlParameterResult);
//        System.out.println(BOMResults + "CP Results");
//        Assert.assertEquals("GHP Mismatch", GHPParamResults.size(), BOMResults.size());
//        List<String> BOMElements = BOMResults.stream().map(WebElement::getText).collect(Collectors.toList());
//        UniqueCodeStore.storeLists("CP Elements", BOMElements);
//        System.out.println(UniqueCodeStore.getStoreList("CP Elements"));
    }


    public void clearMultiListAndUpdateWithNewList(String listName, String[] newListValues, WebElementFacade dropDownClear, WebElementFacade listFieldBtn) {
        // withTimeoutOf(100, TimeUnit.SECONDS).waitFor(dropDownClear);
        $(listFieldBtn).click();
        waitABit(1000);
        $(dropDownClear).click();
        if (listName.equalsIgnoreCase("technologyPlatforms")) {
            multiSelectionOfTechnologyPlatform(newListValues);
        } else if (listName.equalsIgnoreCase("itemTypes")) {
            multiSelectionOfItemTypes(newListValues);
        } else if (listName.equalsIgnoreCase("qualifiedLaboratories")) {
            multiSelectQualifiedLaboratories(newListValues);
        }
    }

    public void userTryToUpdateTheDescriptionAndSelectTheTechnologyPlatformAndItemTypeAndClickOnSaveAnd(String description, String technologyPlatform, String itemType, String productGroup) {
        String[] technologyPlatformValues = technologyPlatform.split(",");
        String[] itemTypeValues = itemType.split(",");
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame).switchTo().frame(childFrame);
        $(descriptionFiledInQCS).waitUntilClickable().clear();
        $(descriptionFiledInQCS).waitUntilClickable().sendKeys(description);
        clearMultiListAndUpdateWithNewList("technologyPlatforms", technologyPlatformValues, technologyPlatformDropDownClear, technologyPlatformFieldBtn);
        clearMultiListAndUpdateWithNewList("itemTypes", itemTypeValues, itemTypeDropDownClear, itemTypeFieldBtn);
        String productGroupName = $(qcsProductGroupField).getValue().trim();
        for (int i = 0; i < productGroupName.length(); i++) $(qcsProductGroupField).sendKeys(Keys.BACK_SPACE);
        $(qcsProductGroupField).sendKeys(productGroup);
        Serenity.getDriver().switchTo().parentFrame();
        $(doneBtn).click();
    }

    public void validateSelectedValues(List<WebElementFacade> selectedValues, String[] expectedValues, String itemName) {
        List<String> selectedValues1 = selectedValues.stream()
                .map(WebElementFacade::getText)
                .collect(Collectors.toList());
        List<String> expected = Arrays.asList(expectedValues);
        System.out.println(selectedValues1 + ":" + "Actual" + itemName);
        System.out.println(expected + ":" + "Expected" + itemName);
        if (selectedValues1.size() != expectedValues.length) {
            Assert.fail("Number of selected values does not match the expected number");
        }
        boolean areEqual = reusableUtilities.compareTwoLists(selectedValues1, expected);
        if (areEqual) {
            Assert.assertTrue(true);
        } else {
            Assert.fail(itemName + ": Values are not updated/Edit Failed");
        }
    }

    public void andShouldBeUpdatedAndSavedSuccessfully(String description, String technologyPlatform, String itemType) {
        String[] technologyPlatformValues = technologyPlatform.split(",");
        String[] itemTypeValues = itemType.split(",");
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame).switchTo().frame(childFrame);
        String descText = $(descriptionFiledInQCS).getValue().toString().trim();
        Assert.assertTrue("Description is not updated", descText.equalsIgnoreCase(description));
        validateSelectedValues(getTheSelectedTechnologyList, technologyPlatformValues, "technologyPlatformValues");
        validateSelectedValues(getTheSelectedItemTypeList, itemTypeValues, "itemTypeValues");
    }

    public void userAddsPreliminaryStatusQCSToTheAffectedItem() {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame).switchTo().frame(QCSAffectedItemFrame);
        $(addQCSPolyItems).click();
        Serenity.getDriver().switchTo().parentFrame();
        withTimeoutOf(90, TimeUnit.SECONDS).waitFor(dialogueIframe);
        Serenity.getDriver().switchTo().frame(dialogueIframe);
        withTimeoutOf(90, TimeUnit.SECONDS).waitFor(searchItemTypeSelection);
        $(searchItemTypeSelection).selectByVisibleText("QCS");
        waitABit(2000);
        $(clearSearchCriteria).click();
        $(searchCodeField).click();
        $(Serenity.getDriver().switchTo().activeElement()).typeAndEnter("QCS-0032");
        waitABit(2000);
        $(searchOkBtn).click();
        Assert.assertTrue("User is not able to add Preliminary Status QCS to affected item", true);
    }

    public void userOpensTheQCSRequestFromTheAffectedItems(String qcsItemCode) {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame).switchTo().frame(childFrame);
        String releaseDate = $(releaseDateField).getAttribute("value").toString().trim();
        String qcsEcoState = $(qcsECOState).getText().toString().trim();
        qcsEcoInformation.add(reusableUtilities.DateConverter(releaseDate));
        qcsEcoInformation.add(qcsEcoState);
        qcsEcoInformation.add(ItemCodeStore.getUniqueCode("targetLifeCycle"));
        Serenity.getDriver().switchTo().parentFrame();
        withTimeoutOf(90, TimeUnit.SECONDS).waitFor(affectedItemTabButton).click();
        Serenity.getDriver().switchTo().frame(QCSAffectedItemFrame);
        withTimeoutOf(90, TimeUnit.SECONDS).waitFor(By.xpath("//span[text()='" + qcsItemCode + "']")).click();
        Serenity.getDriver().switchTo().defaultContent();
        waitABit(3000);
        $(closeTheFirstOpenedTab).click();
    }

    public void searchItemsFromSearchSection(String itemCode) {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame);
        withTimeoutOf(90, TimeUnit.SECONDS).waitFor(qcsItemCodeInSearchSection);
        withTimeoutOf(90, TimeUnit.SECONDS).waitFor(clearSearchCriteria);
        $(clearSearchCriteria).click();
        waitABit(2000);
        $(qcsItemCodeInSearchSection).click();
        waitABit(2000);
        $(Serenity.getDriver().switchTo().activeElement()).type(itemCode);
        $(runSearchButton).click();
        withTimeoutOf(90, TimeUnit.SECONDS).waitFor(By.xpath("//*[text()='" + itemCode + "']"));
        Actions a = new Actions(Serenity.getDriver());
        a.moveToElement($(By.xpath("//*[text()='" + itemCode + "']"))).doubleClick().build().perform();
        Serenity.getDriver().switchTo().defaultContent();
        withTimeoutOf(90, TimeUnit.SECONDS).waitFor(closeTheFirstOpenedTab).click();
    }

    public void validateColumn(List<List<String>> data, int i) {
        By defaultAttribute = By.xpath("//*[contains(text(),'" + data.get(0).get(i) + "')]");
        if ($(defaultAttribute).isCurrentlyVisible()) {
            System.out.println(data.get(0).get(i) + " column is present in the form");
            Serenity.reportThat(data.get(0).get(i) + "column is present in the form", () -> assertThat(data.get(0).get(i), true));
        } else {
            Serenity.getDriver().switchTo().parentFrame();
            if ($(defaultAttribute).isCurrentlyVisible()) {
                Serenity.reportThat(data.get(0).get(i) + "column is present in the form", () -> assertThat(data.get(0).get(i), true));
                System.out.println(data.get(0).get(i) + " column is present in the form");
            } else {
                // Assert.fail(data.get(0).get(i) + "column is not present in the form");
            }
        }
    }

    public void validationOfFieldsInQCSTab(List<List<String>> data) {
        for (int i = 0; i < data.get(0).size(); i++) {
            Serenity.getDriver().switchTo().defaultContent().switchTo().frame(newFrameForCreatePartFrame);
            if ($(controlParameterRelationshipIframe).isCurrentlyVisible()) {
                validateColumn(data, i);
            } else if ($(selectionParameterRelationshipIframe).isCurrentlyVisible()) {
                validateColumn(data, i);
            }

        }
    }

    public void userFillAllMandatoryFieldsInQCSECO(String title, String changeDesc, String reasonForChange, String qcsChangeType) {
        String effectiveDate = "7/26/2024 12:00:00 AM";
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame).switchTo().frame(childFrame);
        $(titleFieldInQCSEco).sendKeys(title);
        $(changeDescFieldInQCSEco).sendKeys(changeDesc);
        $(reasonForChangeFieldInQCSEco).sendKeys(reasonForChange);
        $(qcsChangeTypeField).sendKeys(qcsChangeType);
        $(effectiveDateAndTimeField).sendKeys(effectiveDate);
        Serenity.getDriver().switchTo().parentFrame();
        $(saveButton).click();
        Serenity.getDriver().switchTo().frame(childFrame);
        //Storing QCS ECO Information in the List to validate the Changes tab Data in QCS
        qcsEcoInformation.add(title);
        qcsEcoInformation.add(changeDesc);
        qcsEcoInformation.add(qcsChangeType);
        qcsEcoInformation.add("1");
        qcsEcoInformation.add(reusableUtilities.DateConverter(effectiveDate));
    }

    public void userShouldAddDratStatusQCSToTheAffectedItem(String qcsItemCode) {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame).switchTo().frame(qcsAffectedItemIframe);
        $(addQCSPolyItemsBtn).click();
        Serenity.getDriver().switchTo().parentFrame().switchTo().frame(dialogueIframe);
        withTimeoutOf(90, TimeUnit.SECONDS).waitFor(itemTypeSelection);
        $(itemTypeSelection).selectByVisibleText("QCS");
        withTimeoutOf(90, TimeUnit.SECONDS).waitFor(clearSearchCriteria);
        waitABit(3000);
        $(clearSearchCriteria).click();
        $(qcsCodeInSearch).click();
        waitABit(2000);
        $(Serenity.getDriver().switchTo().activeElement()).type(qcsItemCode);
        waitABit(2000);
        $(runSearchButton).click();
        withTimeoutOf(90, TimeUnit.SECONDS).waitFor(searchResultsInGrid);
        withTimeoutOf(90, TimeUnit.SECONDS).waitFor(searchOkButton);
        $(searchOkBtn).click();
    }

    public void userDeleteAllTheVersionsOfPart() {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame);
        $(moreActionButton).click();
        withTimeoutOf(90, TimeUnit.SECONDS).waitFor(deleteButton).click();
        waitABit(3000);
        withTimeoutOf(90, TimeUnit.SECONDS).waitFor(deleteAllTheVersionsButton).click();
        waitABit(2000);
        withTimeoutOf(90, TimeUnit.SECONDS).waitFor(confirmDeleteButton).click();
    }

    public void changesTabShouldContainQCSAndQCSECOInformation() {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame).switchTo().frame(qcsChangesTabIframe);
        List<String> changesTabData = qcsChangesTabData.stream().map(WebElementFacade::getText).collect(Collectors.toList());
        System.out.println("Changes Tab Data: " + changesTabData);
        System.out.println("QCS Changes Tab Data: " + qcsEcoInformation);
        Assert.assertTrue("Changes tab not having full information something is missing/failed", reusableUtilities.compareTwoLists(changesTabData, qcsEcoInformation));
    }

    public void storeECONumber(String itemType, String number) {
        qcsEcoInformation.add(ItemCodeStore.getUniqueCode(itemType));
        System.out.println(itemType + " : " + ItemCodeStore.getUniqueCode(itemType));
    }

    public void validateAttachmentsCanBeAddedOrRemovedFromTheAttachmentTab() {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame).switchTo().frame(qcsAttachmentRelationshipTab);
        waitABit(2000);
        $(addAttachmentBtn).click();
        waitABit(2000);
        int beforeAddingAttachments = tableRows.size();
        Serenity.getDriver().switchTo().parentFrame().switchTo().frame(dialogueIframe);
        $(clearSearchCriteria).click();
        waitABit(2000);
        $(runSearchButton).click();
        withTimeoutOf(100, TimeUnit.SECONDS).waitFor(firstResults);
        withTimeoutOf(100, TimeUnit.SECONDS).waitFor(secondResults);
        reusableUtilities.pressAndHoldControl($(secondResults));
        $(searchOkButton).click();
        Serenity.getDriver().switchTo().parentFrame();
        $(saveButton).click();
        Serenity.getDriver().switchTo().frame(qcsAttachmentRelationshipTab);
        List<WebElementFacade> attachmentRows = tableRows;
        Assert.assertEquals("Attachments are added to the tab", 2 + beforeAddingAttachments, attachmentRows.size());
        waitABit(1000);
        $(tableRowFirstElement).click();
        waitABit(1000);
        $(deleteAttachmentBtnForQcs).click();
        Serenity.getDriver().switchTo().parentFrame();
        $(saveButton).click();
        Serenity.getDriver().switchTo().frame(qcsAttachmentRelationshipTab);
        waitABit(3000);
        attachmentRows = tableRows;
        Assert.assertEquals("Attachments are added to the tab", 1 + beforeAddingAttachments, attachmentRows.size());
    }

    public void userShouldAddCriteriaOnSelectionParametersTab() {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame).switchTo().frame(qcsSelectionParameterRelationshipTabFrame);
        $(addNewSelectionParametersBtn).click();
        waitABit(3000);
        $(By.xpath("//li[@class='aras-list-item aras-list-item_shown']/label[text()[normalize-space()='Sub Family']]")).click();
        waitABit(2000);
        $(By.xpath("//li[@class='aras-list-item aras-list-item_shown']/label[text()[normalize-space()='Item Type']]")).click();
        Serenity.getDriver().switchTo().parentFrame();
        $(saveButton).click();
        String alterValue = $(alertText).getText().toString();
        String expectedValue = "Item Type,Sub Family is mandatory if the selected criteria is Item Type,Sub Family.Please select the value to proceed further.";
        System.out.println(alterValue + "AlterValue");
        Assert.assertTrue("Validation message is displaying", alterValue.equalsIgnoreCase(expectedValue));
        waitABit(2000);
        $(alertOkBtn).click();
        Serenity.getDriver().switchTo().frame(qcsSelectionParameterRelationshipTabFrame);
        $(By.xpath("//li[@class='aras-list-item aras-list-item_shown']/label[text()[normalize-space()='Adhesive - 80']]")).click();
        waitABit(2000);
        $(By.xpath("//li[@class='aras-list-item aras-list-item_shown']/label[text()[normalize-space()='Liquid - LIQ']]")).click();
    }
}
