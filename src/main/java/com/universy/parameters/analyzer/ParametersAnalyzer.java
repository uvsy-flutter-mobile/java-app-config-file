package com.universy.parameters.analyzer;

import com.universy.parameters.Parameter;
import com.universy.parameters.Parameters;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParametersAnalyzer {

    public AnalyzerResult analyze(Parameters parameters) {

        List<String> missingParameters = new ArrayList<>();

        if (isAccountEndpointMissing(parameters)) {
            missingParameters.add(Parameter.ACCOUNT_ENDPOINT.getName());
        }

        if (isAccountKeyMissing(parameters)) {
            missingParameters.add(Parameter.ACCOUNT_KEY.getName());
        }

        if (isInstitutionEndpointMissing(parameters)) {
            missingParameters.add(Parameter.INSTITUTION_ENDPOINT.getName());
        }

        if (isInstitutionKeyMissing(parameters)) {
            missingParameters.add(Parameter.INSTITUTION_KEY.getName());
        }

        if (isStudentEndpointMissing(parameters)) {
            missingParameters.add(Parameter.STUDENT_ENDPOINT.getName());
        }

        if (isStudentKeyMissing(parameters)) {
            missingParameters.add(Parameter.STUDENT_KEY.getName());
        }

        return new AnalyzerResult(missingParameters);
    }

    private boolean isAccountEndpointMissing(Parameters parameters) {
        return Optional.of(parameters)
                .map(Parameters::getAccountEndpoint)
                .map(String::isEmpty)
                .orElse(Boolean.TRUE);
    }

    private boolean isAccountKeyMissing(Parameters parameters) {
        return Optional.of(parameters)
                .map(Parameters::getAccountKey)
                .map(String::isEmpty)
                .orElse(Boolean.TRUE);
    }

    private boolean isInstitutionEndpointMissing(Parameters parameters) {
        return Optional.of(parameters)
                .map(Parameters::getInstitutionEndpoint)
                .map(String::isEmpty)
                .orElse(Boolean.TRUE);
    }

    private boolean isInstitutionKeyMissing(Parameters parameters) {
        return Optional.of(parameters)
                .map(Parameters::getInstitutionKey)
                .map(String::isEmpty)
                .orElse(Boolean.TRUE);
    }

    private boolean isStudentEndpointMissing(Parameters parameters) {
        return Optional.of(parameters)
                .map(Parameters::getStudentEndpoint)
                .map(String::isEmpty)
                .orElse(Boolean.TRUE);
    }

    private boolean isStudentKeyMissing(Parameters parameters) {
        return Optional.of(parameters)
                .map(Parameters::getStudentKey)
                .map(String::isEmpty)
                .orElse(Boolean.TRUE);
    }
}
