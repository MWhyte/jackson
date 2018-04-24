package com.codenerve.jackson.domain;

import java.util.Objects;

public class Website {

    private String name;
    private String url;

    public Website(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Website{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Website website = (Website) o;
        return Objects.equals(name, website.name) &&
                Objects.equals(url, website.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, url);
    }
}
