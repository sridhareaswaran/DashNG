package org.sri.dashng.listener.jsonModel;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by sridhar.easwaran on 2/9/2017.
 */
public class Failed {

    @JsonProperty("methodName")
    public String getMethodName() {
        return this.methodName;
    }
    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
    String methodName;

    @JsonProperty("status")
    public String getStatus() {
        return this.status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    String status;

    @JsonProperty("className")
    public String getClassName() {
        return this.className;
    }
    public void setClassName(String className) {
        this.className = className;
    }
    String className;

    @JsonProperty("suiteName")
    public String getSuiteName() {
        return this.suiteName;
    }
    public void setSuiteName(String suiteName) {
        this.suiteName = suiteName;
    }
    String suiteName;

    @JsonProperty("testName")
    public String getTestName() {
        return this.testName;
    }
    public void setTestName(String testName) {
        this.testName = testName;
    }
    String testName;

    @JsonProperty("testDescription")
    public String getTestDescription() {
        return this.testDescription;
    }
    public void setTestDescription(String testDescription) {
        this.testDescription = testDescription;
    }
    String testDescription;

    @JsonProperty("priority")
    public int getPriority() {
        return this.priority;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }
    int priority;

    @JsonProperty("group")
    public String[] getGroup() {
        return this.group;
    }
    public void setGroup(String[] group) {
        this.group = group;
    }
    String[] group;

    @JsonProperty("runTime")
    public String getRunTime() {
        return this.runTime;
    }
    public void setRunTime(String runTime) {
        this.runTime = runTime;
    }
    String runTime;

    @JsonProperty("errorMsg")
    public String getErrorMsg() {
        return this.errorMsg;
    }
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
    String errorMsg;

    @JsonProperty("stackTrace")
    public String[] getStackTrace() {
        return this.stackTrace;
    }
    public void setStackTrace(String[] stackTrace) {
        this.stackTrace = stackTrace;
    }
    String[] stackTrace;
}
