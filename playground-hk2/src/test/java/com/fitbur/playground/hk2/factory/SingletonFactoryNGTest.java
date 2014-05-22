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
package com.fitbur.playground.hk2.factory;

import com.fitbur.playground.hk2.factory.impl.SingletonInstance;
import static org.assertj.core.api.Assertions.assertThat;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.utilities.ServiceLocatorUtilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author Sharmarke Aden
 */
public class SingletonFactoryNGTest {

    SingletonInstance sut;
    ServiceLocator locator;

    @BeforeClass
    public void init() {
        locator = ServiceLocatorUtilities.createAndPopulateServiceLocator("singleton");
        sut = locator.getService(SingletonInstance.class);
        assertThat(sut.isDisposed()).isFalse();
    }

    @AfterClass
    public void destroy() {
        locator.shutdown();
        assertThat(sut.isDisposed()).isTrue();
    }

    @Test
    public void assertInjection() {
        assertThat(sut).isNotNull();
    }

    @Test
    public void assertNotSame() {
        assertThat(sut)
                .isSameAs(locator.getService(SingletonInstance.class));
    }

}
