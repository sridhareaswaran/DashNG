package org.sri.dashng.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.sri.dashng.listener.jsonModel.*;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


/**
 * Created by sridhar.easwaran on 2/6/2017.
 */
public class DashNGListener extends TestListenerAdapter {

    //objects for the json model
    resultModel r = new resultModel();
    Info i = new Info();


    //list declaration of the items
    List<Passed> passedList = new ArrayList<>();
    List<Failed> failedList = new ArrayList<>();
    List<Skipped> skippedList = new ArrayList<>();

    long difference;

    String separator= File.separator;

    public void flushJSONReport() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String jsonInString = mapper.writeValueAsString(r);
            System.out.println(jsonInString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        try {
            FileWriter fileWriter =new FileWriter("dashboard"+separator+"data"+separator+"dashng.json");
            fileWriter.write(mapper.writeValueAsString(r));
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @Override
    public void onStart(ITestContext tc) {
        String suiteName = tc.getSuite().getName();
        String startTime = tc.getStartDate().toString();
        String totalTests = Integer.toString(tc.getSuite().getAllMethods().size());
        String[] includedGroups = tc.getIncludedGroups();
        String[] excludedGroups = tc.getExcludedGroups();

        i.setSuiteName(suiteName);
        i.setStartTime(startTime);
        i.setTotalTests(totalTests);
        i.setIncludedGroups(includedGroups);
        i.setExcludedGroups(excludedGroups);

        r.setInfo(i);
        flushJSONReport();

    }

    @Override
    public void onFinish(ITestContext tc) {

        String endTime = tc.getEndDate().toString();
        difference = tc.getEndDate().getTime() - tc.getStartDate().getTime();
        String testDuration = (new SimpleDateFormat("mm:ss:SSS")).format(new Date(difference));

        i.setEndTime(endTime);
        i.setTestDuration(testDuration);

        flushJSONReport();

    }

    @Override
    public void onTestStart(ITestResult tr) {
        System.out.println("Test Started....");
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        Passed p = new Passed();

        Long duration = tr.getEndMillis() - tr.getStartMillis();

        String suiteName = tr.getTestContext().getSuite().getName();
        String className = tr.getMethod().getTestClass().getName();
        String testMethodName = tr.getMethod().getMethodName();
        String testName = tr.getTestContext().getName();
        String testDescription = tr.getMethod().getDescription();
        String[] group = tr.getMethod().getGroups();
        String runTime = (new SimpleDateFormat("mm:ss:SSS")).format(new Date(duration));
        int priority = tr.getMethod().getPriority();

        p.setSuiteName(suiteName);
        p.setClassName(className);
        p.setMethodName(testMethodName);
        p.setTestName(testName);
        p.setTestDescription(testDescription);
        p.setGroup(group);
        p.setStatus("Passed");
        p.setRunTime(runTime);
        p.setPriority(priority);

        passedList.add(p);
        r.setPassed(passedList);
        flushJSONReport();
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        Failed f = new Failed();

        Long duration = tr.getEndMillis() - tr.getStartMillis();

        String suiteName = tr.getTestContext().getSuite().getName();
        String className = tr.getMethod().getTestClass().getName();
        String testMethodName = tr.getMethod().getMethodName();
        String testName = tr.getTestContext().getName();
        String testDescription = tr.getMethod().getDescription();
        String[] group = tr.getMethod().getGroups();
        String runTime = (new SimpleDateFormat("mm:ss:SSS")).format(new Date(duration));
        int priority = tr.getMethod().getPriority();
        String errorMsg = tr.getThrowable().toString();

        String temp1 = Arrays.toString(tr.getThrowable().getStackTrace());
        String temp2 = temp1.substring(0, temp1.length() - 1);
        String temp3 = temp2.substring(1, temp2.length());
        //String[] stackTrace = Arrays.toString(tr.getThrowable().getStackTrace()).split(", ");
        String[] stackTrace = temp3.split(", ");

        System.out.println(Arrays.toString(tr.getThrowable().getStackTrace()));
        f.setSuiteName(suiteName);
        f.setClassName(className);
        f.setMethodName(testMethodName);
        f.setTestName(testName);
        f.setTestDescription(testDescription);
        f.setGroup(group);
        f.setStatus("Failed");
        f.setRunTime(runTime);
        f.setPriority(priority);
        f.setErrorMsg(errorMsg);
        f.setStackTrace(stackTrace);

        failedList.add(f);
        r.setFailed(failedList);
        flushJSONReport();

    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        Skipped s = new Skipped();

        Long duration = tr.getEndMillis() - tr.getStartMillis();

        String suiteName = tr.getTestContext().getSuite().getName();
        String className = tr.getMethod().getTestClass().getName();
        String testMethodName = tr.getMethod().getMethodName();
        String testName = tr.getTestContext().getName();
        String testDescription = tr.getMethod().getDescription();
        String[] group = tr.getMethod().getGroups();
        String runTime = (new SimpleDateFormat("mm:ss:SSS")).format(new Date(duration));
        int priority = tr.getMethod().getPriority();

        s.setSuiteName(suiteName);
        s.setClassName(className);
        s.setMethodName(testMethodName);
        s.setTestName(testName);
        s.setTestDescription(testDescription);
        s.setGroup(group);
        s.setStatus("Skipped");
        s.setRunTime(runTime);
        s.setPriority(priority);

        skippedList.add(s);
        r.setSkipped(skippedList);
        flushJSONReport();

    }

}
