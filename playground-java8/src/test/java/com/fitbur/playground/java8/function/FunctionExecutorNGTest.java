/*
 * Copyright 2014 Fitbur.
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
package com.fitbur.playground.java8.function;

import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Sharmarke Aden
 */
public class FunctionExecutorNGTest {

    FunctionExecutor sut;

    @BeforeMethod
    public void init() {
        sut = new FunctionExecutor();
    }

    @Test
    void givenPramsAndConsumerExecuteShouldConsumeFunction() {
        sut.execute("Hello", new BiConsumerCommand());
    }

    @Test
    void givenParamsAndBiFunctionExecuteShouldCallFunction() {
        String result = sut.execute("Hello", "World", new BiFunctionQuery());
        assertThat(result).isNotEmpty();
    }

    @Test
    void givenParamsAndTriFunctionExecuteShouldCallFunction() {
        String result = sut.execute("Hello", "World", "!", new TriFunctionQuery());
        assertThat(result).isNotEmpty();
    }
}
