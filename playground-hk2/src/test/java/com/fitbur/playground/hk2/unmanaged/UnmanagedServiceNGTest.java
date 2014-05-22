/*
 * Copyright 2014 Sharmarke Aden.
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
package com.fitbur.playground.hk2.unmanaged;

import javax.inject.Inject;
import static org.assertj.core.api.Assertions.assertThat;
import org.glassfish.hk2.api.ServiceLocator;
import org.jvnet.testing.hk2testng.HK2;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Sharmarke Aden
 */
@HK2
public class UnmanagedServiceNGTest {

    UnmanagedService sut;

    @Inject
    ServiceLocator locator;

    @BeforeMethod
    public void init() {
        sut = new UnmanagedService();
    }

    @Test
    public void assertInitialState() {
        assertThat(sut.getMethod()).isNull();
        assertThat(sut.getField()).isNull();
        assertThat(sut.isInitialized()).isFalse();
        assertThat(sut.isDestroyed()).isFalse();
    }

    @Test
    public void assertInjections() {
        locator.inject(sut);
        assertThat(sut.getMethod()).isNotNull();
        assertThat(sut.getField()).isNotNull();
    }

    @Test
    public void assertConstruction() {
        locator.postConstruct(sut);
        assertThat(sut.isInitialized()).isTrue();
    }

    @Test
    public void assertDestruction() {
        locator.preDestroy(sut);
        assertThat(sut.isDestroyed()).isTrue();
    }
}
