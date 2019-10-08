package com.universy.parameters;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Arrays;
import java.util.List;

public class Parameters {

    private static final String DB_PATH_TEMPLATE = "/%s_universy.db";

    private String studentEndpoint;
    private String studentKey;
    private String stage;
    private String dbPath;

    public Parameters(String stage) {
        this.stage = stage;
        this.dbPath = String.format(DB_PATH_TEMPLATE, stage);
    }

    public String getStudentEndpoint() {
        return studentEndpoint;
    }

    public void setStudentEndpoint(String studentEndpoint) {
        this.studentEndpoint = studentEndpoint;
    }

    public String getStudentKey() {
        return studentKey;
    }

    public void setStudentKey(String studentKey) {
        this.studentKey = studentKey;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getDbPath() {
        return dbPath;
    }

    public void setDbPath(String dbPath) {
        this.dbPath = dbPath;
    }

    @JsonIgnore
    public List<ParameterFiller> getFillers() {
        return Arrays.asList(
                new ParameterFiller(Parameter.STUDENT_ENDPOINT.format(stage), this::setStudentEndpoint),
                new ParameterFiller(Parameter.STUDENT_KEY.format(stage), this::setStudentKey)
        );
    }
}
