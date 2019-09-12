package com.universy.parameters;

import java.util.function.Consumer;

public class ParameterFiller {
    private String paramName;
    private Consumer<String> paramConsumer;

    public ParameterFiller(String paramName, Consumer<String> paramConsumer) {
        this.paramName = paramName;
        this.paramConsumer = paramConsumer;
    }

    public String getParamName() {
        return paramName;
    }

    public Consumer<String> getParamConsumer() {
        return paramConsumer;
    }
}
