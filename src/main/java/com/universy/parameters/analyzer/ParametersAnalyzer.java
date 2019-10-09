package com.universy.parameters.analyzer;

import com.universy.parameters.Parameter;
import com.universy.parameters.Parameters;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParametersAnalyzer {

    public AnalyzerResult analyze(Parameters parameters) {

        List<String> missingParameters = new ArrayList<>();

        if (isStudentEndpointMissing(parameters)) {
            missingParameters.add(Parameter.STUDENT_ENDPOINT.getName());
        }

        if (isStudentKeyMissing(parameters)) {
            missingParameters.add(Parameter.STUDENT_KEY.getName());
        }

        return new AnalyzerResult(missingParameters);
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
