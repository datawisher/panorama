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

    @Test
    public void whenPartitionList_thenPartitioned() {
        List<String> names = Lists.newArrayList("John", "Jane", "Adam", "Tom", "Viki", "Tyler");

        List<List<String>> result = Lists.partition(names, 2);

        assertEquals(3, result.size());
        assertThat(result.get(0), contains("John", "Jane"));
        assertThat(result.get(1), contains("Adam", "Tom"));
        assertThat(result.get(2), contains("Viki", "Tyler"));
    }
}
