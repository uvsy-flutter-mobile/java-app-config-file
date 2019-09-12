package com.universy.parameters.analyzer;

import com.universy.parameters.Parameter;
import com.universy.parameters.Parameters;

import java.util.ArrayList;
import java.util.List;

public class ParametersAnalyzer {

    public AnalyzerResult analyze(Parameters parameters) {

        List<String> missingParameters = new ArrayList<>();

        String accountEndpoint = parameters.getAccountEndpoint();
        if(isStringNullOrEmpty(accountEndpoint)) missingParameters.add(Parameter.ACCOUNT_ENDPOINT.getName());

        String accountKey = parameters.getAccountKey();
        if(isStringNullOrEmpty(accountKey)) missingParameters.add(Parameter.ACCOUNT_KEY.getName());

        String institutionEndpoint = parameters.getInstitutionEndpoint();
        if(isStringNullOrEmpty(institutionEndpoint)) missingParameters.add(Parameter.INSTITUTION_ENDPOINT.getName());

        String institutionKey = parameters.getInstitutionKey();
        if(isStringNullOrEmpty(institutionKey)) missingParameters.add(Parameter.INSTITUTION_KEY.getName());

        String studentEndpoint = parameters.getStudentEndpoint();
        if(isStringNullOrEmpty(studentEndpoint)) missingParameters.add(Parameter.STUDENT_ENDPOINT.getName());

        String studentKey = parameters.getStudentKey();
        if(isStringNullOrEmpty(studentKey)) missingParameters.add(Parameter.STUDENT_KEY.getName());

        return new AnalyzerResult(missingParameters);
    }

    private boolean isStringNullOrEmpty(String value){
        return value == null || value.isEmpty();
    }
}
