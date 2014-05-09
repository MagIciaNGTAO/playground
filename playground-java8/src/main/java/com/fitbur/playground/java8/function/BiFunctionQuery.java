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

import java.util.function.BiFunction;

/**
 *
 * @author Sharmarke Aden
 */
public class BiFunctionQuery implements BiFunction<String, String, String> {

    @Override
    public String apply(String t, String u) {
        String r = "got: " + t + " and " + u;
        System.out.println(r);

        return r;
    }

}
