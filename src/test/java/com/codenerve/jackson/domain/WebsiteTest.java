package com.codenerve.jackson.domain;

import com.codenerve.jackson.domain.Website;
import com.codenerve.jackson.mixin.WebsiteMixin;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class WebsiteTest {

    private ObjectMapper objectMapper;
    private Website website;

    @Before
    public void setUp() throws Exception {
        objectMapper = new ObjectMapper();
        website = new Website("codenerve", "https://codenerve.com");
    }

    @Test(expected = JsonMappingException.class)
    public void mappingObjectWithNoDefaultConstructor_fails() throws IOException {
        byte[] valueAsBytes = objectMapper.writeValueAsBytes(website);

        // lack of default constructor (private or otherwise) causes this to fail!
        assertThat(objectMapper.readValue(valueAsBytes, Website.class), is(equalTo(website)));
    }

    @Test
    public void mappingObjectWithNoDefaultConstructor_passesWithMixin() throws IOException {
        objectMapper = new ObjectMapper();
        objectMapper.addMixIn(Website.class, WebsiteMixin.class);

        byte[] valueAsBytes = objectMapper.writeValueAsBytes(website);
        assertThat(objectMapper.readValue(valueAsBytes, Website.class), is(equalTo(website)));
    }
}