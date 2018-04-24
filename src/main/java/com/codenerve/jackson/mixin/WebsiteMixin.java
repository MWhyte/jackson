package com.codenerve.jackson.mixin;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class WebsiteMixin {

    private final String name;
    private final String url;

    @JsonCreator
    public WebsiteMixin(@JsonProperty("name") String name,
                        @JsonProperty("url") String url) {
        this.name = name;
        this.url = url;
    }
}