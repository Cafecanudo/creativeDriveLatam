package com.creativedrive.cora.user.controllers;

import com.creativedrive.cora.core.beans.UserBean;
import com.creativedrive.cora.user.AbstractTest;
import com.google.common.reflect.TypeToken;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.hamcrest.core.IsNot.not;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserControllerTest extends AbstractTest {

    @Test
    public void listUsers() throws Exception {
        Type listType = new TypeToken<List<UserBean>>() {}.getType();

        String content = mvc.perform(get("/api/user").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse()
                .getContentAsString();

        List<UserBean> list = super.toObject(content, listType);
        assertThat(list, not(empty()));
        assertThat(list.size(), greaterThan(3));
    }

    @Test
    public void listUsersWithMessages() {
    }

    @Test
    public void save() {
    }
}