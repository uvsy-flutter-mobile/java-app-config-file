package com.universy.parameters;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum ParameterName {

    ACCOUNT_ENDPOINT("/%s/apigw/api-account/endpoint"),
    ACCOUNT_KEY("/%s/apigw/api-account/key"),
    INSTITUTION_ENDPOINT("/%s/apigw/api-institution/endpoint"),
    INSTITUTION_KEY("/%s/apigw/api-institution/key"),
    STUDENT_ENDPOINT("/%s/apigw/api-student/endpoint"),
    STUDENT_KEY("/%s/apigw/api-student/key");


    private final String pathTemplate;

    ParameterName(String pathTemplate) {
        this.pathTemplate = pathTemplate;
    }

    public String getPathTemplate() {
        return pathTemplate;
    }

    public String format(String stage){
        return String.format(getPathTemplate(), stage);
    }

    public static List<String> getFormattedPaths(String stage){
        return Stream.of(ParameterName.values())
                .map(parameterName -> parameterName.format(stage))
                .collect(Collectors.toList());
    }
}
