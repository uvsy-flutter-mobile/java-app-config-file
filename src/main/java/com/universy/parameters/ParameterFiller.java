package com.universy.parameters;

import java.util.function.Consumer;

public class ParameterFiller {
    private String paramPath;
    private Consumer<String> paramConsumer;

    public ParameterFiller(String paramPath, Consumer<String> paramConsumer) {
        this.paramPath = paramPath;
        this.paramConsumer = paramConsumer;
    }

    public String getParamPath() {
        return paramPath;
    }

    public Consumer<String> getParamConsumer() {
        return paramConsumer;
    }
}
