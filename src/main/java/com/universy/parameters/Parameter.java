package com.universy.parameters;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Parameter {

    ACCOUNT_ENDPOINT("/%s/apigw/api-account/endpoint", "API Account Endpoint"),
    ACCOUNT_KEY("/%s/apigw/api-account/key", "API Account Key"),
    INSTITUTION_ENDPOINT("/%s/apigw/api-institution/endpoint", "API Institution Endpoint"),
    INSTITUTION_KEY("/%s/apigw/api-institution/key", "API Institution Key"),
    STUDENT_ENDPOINT("/%s/apigw/api-student/endpoint", "API Student Endpoint"),
    STUDENT_KEY("/%s/apigw/api-student/key", "API Student Key");


    private final String pathTemplate;
    private final String parameterName;

    Parameter(String pathTemplate, String parameterName) {
        this.pathTemplate = pathTemplate;
        this.parameterName = parameterName;
    }

    public String getPathTemplate() {
        return pathTemplate;
    }

    public String getName() {
        return parameterName;
    }

    public String format(String stage){
        return String.format(getPathTemplate(), stage);
    }

    public static List<String> getFormattedPaths(String stage){
        return Stream.of(Parameter.values())
                .map(parameter -> parameter.format(stage))
                .collect(Collectors.toList());
    }
}
