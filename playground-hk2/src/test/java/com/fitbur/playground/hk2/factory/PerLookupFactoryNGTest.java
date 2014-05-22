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

import com.fitbur.playground.hk2.factory.impl.PerLookupInstance;
import javax.inject.Inject;
import static org.assertj.core.api.Assertions.assertThat;
import org.glassfish.hk2.api.ServiceLocator;
import org.jvnet.testing.hk2testng.HK2;
import org.testng.annotations.Test;

/**
 *
 * @author Sharmarke Aden
 */
@HK2
public class PerLookupFactoryNGTest {

    @Inject
    ServiceLocator locator;
    @Inject
    PerLookupInstance sut;

    @Test
    public void assertInjection() {
        assertThat(locator).isNotNull();
        assertThat(sut).isNotNull();
    }

    @Test
    public void assertNotSame() {
        assertThat(sut)
                .isNotSameAs(locator.getService(PerLookupInstance.class));
    }
}
