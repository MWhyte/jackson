package com.codenerve.jackson.mixin;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;

@SuppressWarnings("unused")
@JsonAutoDetect(fieldVisibility = ANY)
public interface AccountMixin {

    @JsonProperty("accountId")
    String getAccountID();
}