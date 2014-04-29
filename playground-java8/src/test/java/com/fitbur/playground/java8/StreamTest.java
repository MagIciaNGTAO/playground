/*
 * Copyright 2014 saden.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.fitbur.playground.java8;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author saden
 */
public class StreamTest {

    @DataProvider
    Object[][] arrayOfStrings() {
        return new Object[][]{
            {new String[]{"a", "b", "c"}}
        };
    }

    @DataProvider
    Object[][] arraysOfStrings() {
        return new Object[][]{
            {
                new String[]{"a", "b", "c"},
                new String[]{"d", "e", "f"}
            }
        };
    }

    @DataProvider
    Object[][] emptyArray() {
        return new Object[][]{
            {new String[]{}}
        };
    }

    @Test(dataProvider = "arrayOfStrings")
    public void givenArrayShouldReturnOrderedCollection(String[] array) {
        List<String> result = Stream.of(array).collect(Collectors.toList());

        assertThat(result).hasSize(3)
                .containsSequence(array);

    }

    @Test(dataProvider = "emptyArray")
    public void givenEmptyArrayShouldReturnEmptyCollection(String[] array) {
        List<String> result = Stream.of(array).collect(Collectors.toList());

        assertThat(result).isEmpty();
    }

    @Test(dataProvider = "arrayOfStrings")
    public void givenArrayShouldReturnJoinedStringValue(String[] array) {
        String result = Stream.of(array).collect(Collectors.joining("/"));

        assertThat(result).isEqualTo("a/b/c");
    }

    @Test(dataProvider = "arraysOfStrings")
    public void givenTwoArraysShouldReturnConcatonatedCollection(String[] array1, String[] array2) {
        Stream<String> stream = Stream.concat(Stream.of(array1), Stream.of(array2));
        List<String> result = stream.collect(Collectors.toList());

        assertThat(result).hasSize(6)
                .containsSequence(array1)
                .containsSequence(array2);
    }
}
