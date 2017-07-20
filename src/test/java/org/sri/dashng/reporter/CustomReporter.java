package org.sri.dashng.reporter;

import java.util.List;
import java.util.Map;

import org.testng.*;
import org.testng.xml.XmlSuite;


/**
 * Created by sridhar.easwaran on 12/22/2016.
 */
public class CustomReporter implements IReporter{
    @Override
    public void generateReport(List<XmlSuite>  xmlSuites, List<ISuite> suites,
                               String outputDirectory) {
        //Iterating over each suite included in the test
        for (ISuite suite : suites) {
            //Following code gets the suite name
            String suiteName = suite.getName();
            //Getting the results for the said suite
            Map<String, ISuiteResult> suiteResults = suite.getResults();
            for (ISuiteResult sr : suiteResults.values()) {
                ITestContext tc = sr.getTestContext();
                ITestNGMethod[] iTestNGMethods=tc.getAllTestMethods();
                for (ITestNGMethod tm:iTestNGMethods) {
                    System.out.println(tm.getMethodName());
                }

                System.out.println("Passed tests for suite '" + suiteName +
                        "' is:" + tc.getPassedTests().getAllResults().size());
                System.out.println("Failed tests for suite '" + suiteName +
                        "' is:" +
                        tc.getFailedTests().getAllResults().size());
                System.out.println("Skipped tests for suite '" + suiteName +
                        "' is:" +
                        tc.getSkippedTests().getAllResults().size());
            }
        }
    }
}