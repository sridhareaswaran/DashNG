package org.sri.dashng.listener.jsonModel;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by sridhar.easwaran on 2/9/2017.
 */
public class Info {

    @JsonProperty("suiteName")
    public String getSuiteName() {
        return this.suiteName;
    }
    public void setSuiteName(String suiteName) {
        this.suiteName = suiteName;
    }
    String suiteName;

    @JsonProperty("startTime")
    public String getStartTime() {
        return this.startTime;
    }
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    String startTime;

    @JsonProperty("endTime")
    public String getEndTime() {
        return this.endTime;
    }
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    String endTime;

    @JsonProperty("testDuration")
    public String getTestDuration() {
        return this.testDuration;
    }
    public void setTestDuration(String testDuration) {
        this.testDuration = testDuration;
    }
    String testDuration;

    @JsonProperty("totalTests")
    public String getTotalTests() {
        return this.totalTests;
    }
    public void setTotalTests(String totalTests) {
        this.totalTests = totalTests;
    }
    String totalTests;

    @JsonProperty("includedGroups")
    public String[] getIncludedGroups() {
        return this.includedGroups;
    }
    public void setIncludedGroups(String[] includedGroups) {
        this.includedGroups = includedGroups;
    }
    String[] includedGroups;

    @JsonProperty("excludedGroups")
    public String[] getExcludedGroups() {
        return this.excludedGroups;
    }
    public void setExcludedGroups(String[] excludedGroups) {
        this.excludedGroups = excludedGroups;
    }
    String[] excludedGroups;
}
