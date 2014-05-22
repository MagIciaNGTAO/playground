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
package com.fitbur.playground.hk2.provider;

import com.fitbur.playground.hk2.provider.impl.BookOne;
import javax.inject.Inject;
import javax.inject.Provider;
import org.glassfish.hk2.api.IterableProvider;
import org.jvnet.hk2.annotations.Service;

/**
 *
 * @author Sharmarke Aden
 */
@Service
public class ProvidedService {

    private final Provider<BookOne> bookOne;
    private final IterableProvider<Book> books;

    @Inject
    ProvidedService(Provider<BookOne> bookOne, IterableProvider<Book> books) {
        this.bookOne = bookOne;
        this.books = books;
    }

    public Provider<BookOne> getBookOne() {
        return bookOne;
    }

    public IterableProvider<Book> getBooks() {
        return books;
    }

}
