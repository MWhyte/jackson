package com.codenerve.jackson.domain;

import com.codenerve.jackson.mixin.AccountMixin;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class AccountTest {

    private ObjectMapper objectMapper;
    private Account account;

    @Before
    public void setUp() throws Exception {
        objectMapper = new ObjectMapper();
        account = new Account("123456", "Savings");
    }

    @Test(expected = UnrecognizedPropertyException.class)
    public void mappingObjectWithNonDefaultGetter_fails() throws Exception {
        byte[] valueAsBytes = objectMapper.writeValueAsBytes(account);

//        System.out.println("After serialisation: " + new String(valueAsBytes));

        // accounts accountId field and getAccountID causes this to fail!
        // change getter to getAccountId and this works. But what if you're mapping a 3rd party jar!?
        assertThat(objectMapper.readValue(valueAsBytes, Account.class), is(equalTo(account)));
    }

    @Test
    public void mappingObjectWithNonDefaultGetter_passesWithMixin() throws Exception {
        objectMapper.addMixIn(Account.class, AccountMixin.class);

        byte[] valueAsBytes = objectMapper.writeValueAsBytes(account);

//        System.out.println("After serialisation: " + new String(valueAsBytes));
        assertThat(objectMapper.readValue(valueAsBytes, Account.class), is(equalTo(account)));
    }
}