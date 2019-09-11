package com.universy.parameters;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Arrays;
import java.util.List;

public class Parameters {

    private static final String DB_PATH_TEMPLATE = "/%s_universy.db";

    private String accountEndpoint;
    private String accountKey;
    private String institutionEndpoint;
    private String institutionKey;
    private String studentEndpoint;
    private String studentKey;
    private String stage;
    private String dbPath;

    public Parameters(String stage) {
        this.stage = stage;
        this.dbPath = String.format(DB_PATH_TEMPLATE, stage);
    }

    public String getAccountEndpoint() {
        return accountEndpoint;
    }

    public void setAccountEndpoint(String accountEndpoint) {
        this.accountEndpoint = accountEndpoint;
    }

    public String getAccountKey() {
        return accountKey;
    }

    public void setAccountKey(String accountKey) {
        this.accountKey = accountKey;
    }

    public String getInstitutionEndpoint() {
        return institutionEndpoint;
    }

    public void setInstitutionEndpoint(String institutionEndpoint) {
        this.institutionEndpoint = institutionEndpoint;
    }

    public String getInstitutionKey() {
        return institutionKey;
    }

    public void setInstitutionKey(String institutionKey) {
        this.institutionKey = institutionKey;
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
                new ParameterFiller(ParameterName.ACCOUNT_ENDPOINT.format(stage), this::setAccountEndpoint),
                new ParameterFiller(ParameterName.ACCOUNT_KEY.format(stage), this::setAccountKey),
                new ParameterFiller(ParameterName.INSTITUTION_ENDPOINT.format(stage), this::setInstitutionEndpoint),
                new ParameterFiller(ParameterName.INSTITUTION_KEY.format(stage), this::setInstitutionKey),
                new ParameterFiller(ParameterName.STUDENT_ENDPOINT.format(stage), this::setStudentEndpoint),
                new ParameterFiller(ParameterName.STUDENT_KEY.format(stage), this::setStudentKey)
        );
    }
}
