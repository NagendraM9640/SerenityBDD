package starter.PageObjectsPages.Develop;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.ScriptTimeoutException;
import starter.Utility.ReusableMethods;
import starter.Utility.ReusableUtilities;

import static starter.PageObjectsPages.Develop.PartPageDev.*;
import static starter.PageObjectsPages.Develop.QCSPage.clearSearchCriteria;
import static starter.PageObjectsPages.Develop.QCSPage.runSearchButton;

public class PartParameterValues extends PageObject {

    public static @FindBy(xpath = "//iframe[@class='content-block__iframe']") WebElementFacade parentFrame;

    public static @FindBy(xpath = "//iframe[@id='instance']") WebElementFacade childFrame;
    public static @FindBy(xpath = "//iframe[@title='pmi_Parameters Relationship']") WebElementFacade ParametersIframe;
    public static @FindBy(xpath = "//select[@title='Search Modes']") WebElementFacade searchModesInSearchDialogue;
    public static @FindBy(xpath = "//*[@id='gridTD']/div[2]/div[2]/div/table/tr/td[1]") WebElementFacade firstTdElementInRow;
    public static @FindBy(xpath = "//td[@data-head-id='pmi_data_type_R']") WebElementFacade dataTypeFieldInSimpleSearch;
    public static @FindBy(xpath = "//td[@data-head-id='pmi_text_value_D']") WebElementFacade textFieldInSimpleSearch;
    public static @FindBy(xpath = "//td[@data-head-id='pmi_target_value_D']") WebElementFacade targetFieldInSimpleSearch;
    public static @FindBy(xpath = "//td[@data-head-id='pmi_max_value_D']") WebElementFacade maxFieldInSimpleSearch;
    public static @FindBy(xpath = "//td[@data-head-id='pmi_min_value_D']") WebElementFacade minFieldInSimpleSearch;
    ReusableUtilities reusableUtilities = new ReusableUtilities();
    ReusableMethods reusableMethods = new ReusableMethods();

    String input ="";


    public static List<String> extractParameterNumbersForPackagingItems(String input) {
        List<String> parameterNumbers = new ArrayList<>();

        // Split the input string into lines
        String[] lines = input.split("\\.\\s*");

        // Pattern to match Parameter Numbers
        Pattern pattern = Pattern.compile("R\\d+");

        for (String line : lines) {
            if (line.contains("Value")) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    parameterNumbers.add(matcher.group());
                }
            }
        }

        return parameterNumbers;
    }

    public Map<String, Set<String>> extractMandatoryValuesForDims(String input) {
        Map<String, Set<String>> mandatoryValuesMap = new HashMap<>();

        String[] lines = input.split("\\r?\\n");

        String currentAffectedItem = null;

        for (String line : lines) {
            if (line.startsWith("Affected Item")) {
                currentAffectedItem = line.split(":")[0].replace("Affected Item", "").trim();
                ItemCodeStore.storeTheData("affectedItem", currentAffectedItem);
            } else if (line.contains("Parameter:")) {

                int paramIndex = line.indexOf("Parameter: ") + "Parameter: ".length();
                int dashIndex = line.indexOf(" - ", paramIndex);
                String parameter = line.substring(paramIndex, dashIndex);

                Set<String> mandatoryValues = mandatoryValuesMap.getOrDefault(parameter, new LinkedHashSet<>());

                if (line.contains("Text")) mandatoryValues.add("Text");
                if (line.contains("Target")) mandatoryValues.add("Target");
                if (line.contains("Min")) mandatoryValues.add("Min");
                if (line.contains("Max")) mandatoryValues.add("Max");
                if (line.contains("Free Text")) mandatoryValues.add("Free Text");

                mandatoryValuesMap.put(parameter, mandatoryValues);
            }
        }

        return mandatoryValuesMap;
    }

    private boolean isParameterAvailable(String parameterNumber) {
        return $(By.xpath("//td[text()='" + parameterNumber + "']")).isCurrentlyVisible();
    }

    private void switchToParameterIframe() {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame).switchTo().frame(ParametersIframe);
    }

    private void performFinalActions() {
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame);
        $(doneButton).click();
        waitABit(2000);
        $(editButton).click();
    }

    public void theParameterShouldBeFilledWithValueAndItsDataTypeShouldBe(String parameterNumber, String parameterValues) {

        reusableMethods.clickOnEdit();

        waitABit(3000);

        Serenity.getDriver().switchTo().defaultContent();
        waitABit(15000);
        withTimeoutOf(Duration.ofSeconds(120)).waitFor(parentFrame);
        waitABit(3000);
        Serenity.getDriver().switchTo().frame(parentFrame).switchTo().frame(ParametersIframe);
        //withTimeoutOf(Duration.ofSeconds(120)).waitFor(parentFrame);

        withTimeoutOf(Duration.ofSeconds(120)).waitFor(searchModesInSearchDialogue).selectByVisibleText("Simple");

        waitABit(2000);
        withTimeoutOf(Duration.ofSeconds(120)).waitFor(clearSearchCriteria).click();
        waitABit(2000);

        withTimeoutOf(Duration.ofSeconds(100)).waitFor(parameterNumberFieldInSearchMode).click();
        waitABit(1000);

        $(Serenity.getDriver().switchTo().activeElement()).typeAndEnter(parameterNumber);
        waitABit(10000);

        // Check if the parameter is available
        if (isParameterAvailable(parameterNumber)) {
            if (parameterNumber.equalsIgnoreCase("R10903")) {
                int textFieldPosition = Integer.parseInt(getTheColumnDataIndex("Free Text"));
                System.out.println("Text Value Index : " + textFieldPosition);
                String textValue = $(By.xpath("//*[@id='gridTD']/div[2]/div[2]/div/table/tr/td[" + textFieldPosition + "]")).getAttribute("textContent");
                System.out.println("Text Value : " + textValue);
                if (textValue.trim().isEmpty()) {
                    handleParameterValues(parameterNumber, parameterValues);
                }
            } else {
                // Handle existing parameter values
                handleParameterValues(parameterNumber, parameterValues);
            }

        } else {
            // Add parameter and enter values if not available
            System.out.println("Parameter is not available. Adding it now...");
            addGHPAndEnterParameterValues(parameterNumber);

            switchToParameterIframe();
            handleParameterValues(parameterNumber, parameterValues);
        }

        waitABit(3000);
        // Click on Done and Edit
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame);
        $(doneButton).click();
        waitABit(3000);
    }


    private void addGHPAndEnterParameterValues(String GHPNumber) {
        $(GHPAddButton).click();

        Serenity.getDriver().switchTo().parentFrame().switchTo().frame(dialogueFrame);
        waitABit(3000);

        withTimeoutOf(Duration.ofSeconds(100)).waitFor(clearSearchCriteria).click();
        waitABit(2000);

        withTimeoutOf(Duration.ofSeconds(100)).waitFor(parameterNumberFieldInDialogueFrame).click();
        waitABit(2000);

        $(Serenity.getDriver().switchTo().activeElement()).type(GHPNumber);
        waitABit(2000);

        $(runSearchButton).click();
        waitABit(1000);

        withTimeoutOf(Duration.ofSeconds(100)).waitFor(By.xpath("//*[@id='gridTD']/div[2]/div[1]/div/table/tr/td[2]"));
        $(arasSearchOkButton).click();
    }

    private String getTheColumnDataIndex(String columnName) {
        String dataIndex = "";
        switch (columnName) {
            case "List":
            case "Free Text":
            case "Multi List":
                dataIndex = textFieldInSimpleSearch.getAttribute("data-index");
                break;
            case "Number":
                dataIndex = targetFieldInSimpleSearch.getAttribute("data-index");
                break;
            default:
                System.out.println("ColumnName is not found......");
        }
        return dataIndex;
    }

    private void handleParameterValues(String parameterNumber, String parameterValues) {

        if (!dataTypeFieldInSimpleSearch.isCurrentlyVisible()) {
            scrollGrid();
        }

        int dataIndex = Integer.parseInt(dataTypeFieldInSimpleSearch.getAttribute("data-index"));

        System.out.println("DataType Field Index is: " + dataIndex);

        String finalDataType = $(By.xpath("//*[@id='gridTD']/div[2]/div[2]/div/table/tr/td[" + dataIndex + "]")).getAttribute("textContent");

        System.out.println("DataType is : " + finalDataType);

        int textFieldPosition = 1;

        int targetFieldPosition = 2;

        if (finalDataType.equalsIgnoreCase("Number")) {
            targetFieldPosition = Integer.parseInt(getTheColumnDataIndex(finalDataType));
            System.out.println("Target Value Index : " + targetFieldPosition);
        } else {
            textFieldPosition = Integer.parseInt(getTheColumnDataIndex(finalDataType));
            System.out.println("Text Value Index : " + textFieldPosition);
        }

        switch (finalDataType) {
            case "Free Text":
                handleFreeText(textFieldPosition, parameterValues);
                break;
            case "List":
                handleList(textFieldPosition);
                break;
            case "Multi List":
                handleMultiList(parameterNumber,textFieldPosition,parameterValues);
                break;
            case "Number":
                handleNumber(targetFieldPosition, parameterValues);
                break;
            default:
                throw new IllegalArgumentException("Invalid data type: " + finalDataType);
        }
    }

    private void handleFreeText(int noOfMoves, String text) {
        $(firstTdElementInRow).click();
        waitAndExecuteTabs(noOfMoves);
        waitABit(2000);
        if (text.isEmpty()) {
            $(Serenity.getDriver().switchTo().activeElement()).type("MN");
        } else {
            $(Serenity.getDriver().switchTo().activeElement()).type(text);
        }
    }

    private void handleList(int noOfMoves) {
        $(firstTdElementInRow).click();
        waitAndExecuteTabs(noOfMoves);
        waitABit(1000);
        reusableUtilities.pressDownNavigation();
        waitABit(1000);
        reusableUtilities.pressDownNavigation();
        waitABit(1000);
        reusableUtilities.pressDownNavigation();
        waitABit(1000);
        reusableUtilities.pressShiftTab();
    }

    private void handleMultiList(String paramNum, int noOfMoves, String parameterValues) {
        String[] multiListValues = parameterValues.split(",");
        $(firstTdElementInRow).click();
        waitAndExecuteTabs(noOfMoves);
        waitABit(2000);
        $(By.xpath("//span[text()='0 item(s) selected']/following-sibling::button")).click();
        waitABit(2000);
        IntStream.range(0, multiListValues.length).forEach(i -> {
            $(By.xpath("//li[@class='aras-list-item aras-list-item_shown']/label[text()[normalize-space()='" + multiListValues[i] + "']]")).click();
        });
        reusableUtilities.pressTab();
        handlePopup(paramNum);
        scrollGrid();
    }

    private void handleNumber(int noOfMoves, String parameterValues) {
        if (parameterValues.contains(",")) {
            checkTheColumnNameHandleMultipleMinMaxTargetValues(noOfMoves, parameterValues);
        } else {
            checkTheColumnNameAndHandleTheParamValues(noOfMoves, parameterValues);
        }
    }

    private void checkTheColumnNameAndHandleTheParamValues(int tabIndex, String parameterValue) {
        String targetValue = "100"; // Default target value

        switch (parameterValue.toLowerCase()) {
            case "target":
                // Check if min and max values are present
                if (isMinMaxValuesPresent(tabIndex)) {
                    double min = Double.parseDouble(ItemCodeStore.getStoredData("min"));
                    double max = Double.parseDouble(ItemCodeStore.getStoredData("max"));
                    targetValue = String.valueOf(RandomValueBetweenMinAndMax(min, max));
                }

                enterTheMinMaxTargetValues(targetValue, tabIndex);
                break;

            case "min":
                enterTheMinMaxTargetValues("5", tabIndex + 1);
                break;

            case "max":
                enterTheMinMaxTargetValues("10", tabIndex + 2);
                break;

            default:
                throw new IllegalArgumentException("Invalid data type: " + parameterValue);
        }
    }


    public boolean isMinMaxValuesPresent(int noOfMoves) {
        try {
            int dataIndexForMin = Integer.parseInt(minFieldInSimpleSearch.getAttribute("data-index"));

            int dataIndexForMax = Integer.parseInt(maxFieldInSimpleSearch.getAttribute("data-index"));

            System.out.println("Min Field Index is: " + dataIndexForMin);
            System.out.println("Max Field Index is: " + dataIndexForMax);

            waitABit(2000);

            String min = $(By.xpath("//*[@id='gridTD']/div[2]/div[2]/div/table/tr/td[" + dataIndexForMin + "]")).getAttribute("textContent");
            String max = $(By.xpath("//*[@id='gridTD']/div[2]/div[2]/div/table/tr/td[" + dataIndexForMax + "]")).getAttribute("textContent");

            System.out.println("Min text is: " + min);
            System.out.println("Max text is: " + max);

            ItemCodeStore.storeTheData("min", min);
            ItemCodeStore.storeTheData("max", max);

            return min != null && max != null && !min.isEmpty() && !max.isEmpty();

        } catch (Exception e) {
            System.err.println("Error while checking Min/Max values: " + e.getMessage());
            return false;
        }
    }


    public void enterTheMinMaxTargetValues(String parameterValue, int noOfMoves) {
        $(firstTdElementInRow).click();
        waitABit(1000);
        waitAndExecuteTabs(noOfMoves);
        waitABit(1000);
        reusableUtilities.pressControlA();
        waitABit(1000);
        reusableUtilities.pressBackspace();
        waitABit(1000);
        $(Serenity.getDriver().switchTo().activeElement()).typeAndTab(parameterValue.trim());
        //scrollGrid();
    }

    public void checkTheColumnNameHandleMultipleMinMaxTargetValues(int noOfMoves, String parameterValues) {
        String paramValues = parameterValues.trim();
        $(firstTdElementInRow).click();
        waitABit(1000);
        waitAndExecuteTabsForMinMaxTargetColumns(noOfMoves);
        if (paramValues.equalsIgnoreCase("Target,Min,Max")) {
            reusableUtilities.pressControlA();
            waitABit(1000);
            reusableUtilities.pressBackspace();
            waitABit(1000);
            $(Serenity.getDriver().switchTo().activeElement()).typeAndTab("15");
            waitABit(1000);
            $(Serenity.getDriver().switchTo().activeElement()).typeAndTab("10");
            waitABit(1000);
            $(Serenity.getDriver().switchTo().activeElement()).typeAndTab("20");
            waitABit(1000);
        } else if (paramValues.equalsIgnoreCase("Min,Max")) {
            waitABit(1000);
            reusableUtilities.pressTab();
            waitABit(1000);
            reusableUtilities.pressControlA();
            waitABit(1000);
            reusableUtilities.pressBackspace();
            waitABit(1000);
            $(Serenity.getDriver().switchTo().activeElement()).typeAndTab("10");
            waitABit(1000);
            $(Serenity.getDriver().switchTo().activeElement()).typeAndTab("20");
        } else if (paramValues.equalsIgnoreCase("Max,Target")) {
            waitABit(1000);
            reusableUtilities.pressTab();
            waitABit(1000);
            reusableUtilities.pressTab();
            waitABit(1000);
            reusableUtilities.pressControlA();
            waitABit(1000);
            reusableUtilities.pressBackspace();
            waitABit(1000);
            $(Serenity.getDriver().switchTo().activeElement()).type("20");
            waitABit(1000);
            reusableUtilities.pressShiftTab();
            waitABit(1000);
            reusableUtilities.pressShiftTab();
            waitABit(1000);
            $(Serenity.getDriver().switchTo().activeElement()).typeAndTab("10");
        }
    }

    private void handlePopup(String parameterNum) {
        Serenity.getDriver().switchTo().parentFrame().switchTo().frame(dialogueFrame);
        waitABit(1000);
        String popupText = $(popupTextContent).getAttribute("value").trim();
        System.out.println(popupText + " PopText");
        if (parameterNum.equalsIgnoreCase("R10454")) {
            ItemCodeStore.storeTheData("PackedItems", popupText);
        }
        $(closePopup).click();
        Serenity.getDriver().switchTo().defaultContent().switchTo().frame(parentFrame);
        if ($(ParametersIframe).isCurrentlyVisible()) {
            Serenity.getDriver().switchTo().frame(ParametersIframe);
        }
    }

    private void scrollGrid() {
        try {
            evaluateAsyncJavascript("arguments[0].scrollLeft = 0", arasGridDiv.get(arasGridDiv.size() - 1));
        } catch (ScriptTimeoutException e) {
            // Handle exception
        }
    }

    private void waitAndExecuteTabs(int times) {
        IntStream.range(1, times - 1).forEach(i -> {
            reusableUtilities.pressRightNavigation();
            waitABit(1000);
        });
        reusableUtilities.pressTab();
    }

    private void waitAndExecuteTabsForMinMaxTargetColumns(int times) {
        IntStream.range(0, times).forEach(i -> {
            //reusableUtilities.pressRightNavigation();
            reusableUtilities.pressTab();
            waitABit(1000);
        });
    }

    private Double RandomValueBetweenMinAndMax(Double min, Double max) {
        return min + (max - min) * Math.random();
    }

}
