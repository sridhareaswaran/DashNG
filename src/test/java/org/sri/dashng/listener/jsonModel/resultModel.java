package org.sri.dashng.listener.jsonModel;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by sridhar.easwaran on 2/9/2017.
 */
public class resultModel {

    @JsonProperty("info")
    public Info getInfo() {
        return this.info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }
    Info info;

    @JsonProperty("passed")
    public List<Passed> getPassed() {
        return this.passed;
    }

    public void setPassed(List<Passed> passed) {
        this.passed = passed;
    }

    List<Passed> passed;

    @JsonProperty("failed")
    public List<Failed> getFailed() {
        return this.failed;
    }

    public void setFailed(List<Failed> failed) {
        this.failed = failed;
    }

    List<Failed> failed;

    @JsonProperty("skipped")
    public List<Skipped> getSkipped() {
        return this.skipped;
    }

    public void setSkipped(List<Skipped> skipped) {
        this.skipped = skipped;
    }

    List<Skipped> skipped;


}

