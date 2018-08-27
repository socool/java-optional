package com.bcorpse;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Unit test for simple App.
 */
public class TestHelloOptional
{
    private List<String> listWithNulls = Arrays.asList("foo", null, "bar", "baz", null);
    private List<Optional<String>> optionals;

    @Before
    public void setUp() {
        optionals = listWithNulls.stream().map(Optional::ofNullable).collect(Collectors.toList());
    }

    @Test
    public void map_with_nulls_test() {
        List<Optional<String>> upperCased = optionals.stream().map(s -> s.map(String::toUpperCase)).collect(Collectors.toList());
        List<Optional<String>> expectedValues = Arrays.asList(Optional.of("FOO"), Optional.empty(), Optional.of("BAR"), Optional.of("BAZ"), Optional.empty());
        assertThat(upperCased, is(expectedValues));
    }

}
