//package starter;
//
//import org.junit.platform.suite.api.ConfigurationParameter;
//import org.junit.platform.suite.api.IncludeEngines;
//import org.junit.platform.suite.api.SelectClasspathResource;
//import org.junit.platform.suite.api.Suite;
//import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;
//
//@Suite
//@IncludeEngines("cucumber")
//@SelectClasspathResource("features/Regression_C&CC/Manufacturing_Specifications_Task_Request1.feature")
//@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "io.cucumber.core.plugin.SerenityReporterParallel,pretty,timeline:build/test-results/timeline")
//public class CucumberTestSuite {
//
//}
package starter;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.FILTER_TAGS_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
//@SelectClasspathResource("features/MigratedDataForPVE2ETesting.feature")
@SelectClasspathResource("features/MigratedDataForPVE2ETesting.feature")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "io.cucumber.core.plugin.SerenityReporterParallel,pretty,timeline:build/test-results/timeline,json:target/serenity-reports/cucumber_report.json")
//@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@MNRegression")
public class CucumberTestSuite {

}
