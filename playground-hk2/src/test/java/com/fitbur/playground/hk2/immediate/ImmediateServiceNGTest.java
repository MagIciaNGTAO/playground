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
package com.fitbur.playground.hk2.immediate;

import static java.lang.Thread.sleep;
import javax.inject.Inject;
import static org.assertj.core.api.Assertions.assertThat;
import org.glassfish.hk2.api.ServiceHandle;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.internal.ImmediateHelper;
import org.jvnet.testing.hk2testng.HK2;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author Sharmarke Aden
 */
@HK2
public class ImmediateServiceNGTest {

    ServiceHandle<ImmediateService> sut;

    @Inject
    ServiceLocator locator;
    @Inject
    ImmediateHelper helper;

    @BeforeClass
    public void init() throws InterruptedException {
        sut = locator.getServiceHandle(ImmediateService.class);
        sleep(2000);
    }

    @AfterClass
    public void destroy() throws InterruptedException {
        helper.shutdown();
        assertThat(sut.isActive()).isFalse();
    }

    @Test
    public void assertStarted() throws InterruptedException {
        assertThat(sut).isNotNull();
        assertThat(sut.isActive()).isTrue();
    }

}
