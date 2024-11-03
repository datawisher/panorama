package com.datawisher.panorama.guava;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.google.common.collect.Lists;

public class GuavaListTest {

    @Test
    public void whenReverseList_thenReversed() {
        List<String> names = Lists.newArrayList("John", "Adam", "Jane");
        List<String> reversed = Lists.reverse(names);
        assertThat(reversed, contains("Jane", "Adam", "John"));
    }

    @Test
    public void whenCreateCharacterListFromString_thenCreated() {
        List<Character> chars = Lists.charactersOf("John");

        assertEquals(4, chars.size());
        assertThat(chars, contains('J', 'o', 'h', 'n'));
    }

}
