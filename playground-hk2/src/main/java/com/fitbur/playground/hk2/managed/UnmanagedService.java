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
package com.fitbur.playground.hk2.managed;

import com.fitbur.playground.hk2.core.DummyService;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

/**
 *
 * @author Sharmarke Aden
 */
public class UnmanagedService {

    @Inject
    DummyService field;
    DummyService method;
    private boolean destroyed;
    private boolean initialized;

    @Inject
    public void setMethod(DummyService method) {
        this.method = method;
    }

    public DummyService getField() {
        return field;
    }

    public DummyService getMethod() {
        return method;
    }

    @PreDestroy
    public void destroy() {
        this.destroyed = true;
    }

    @PostConstruct
    public void construct() {
        this.initialized = true;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public boolean isInitialized() {
        return initialized;
    }

}
