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

import com.fitbur.playground.hk2.core.PerThreadInstance;
import org.glassfish.hk2.api.Factory;
import org.glassfish.hk2.api.PerThread;
import org.jvnet.hk2.annotations.Service;

/**
 *
 * @author Sharmarke Aden
 */
@Service
public class PerThreadFactory implements Factory<PerThreadInstance> {

    @PerThread
    @Override
    public PerThreadInstance provide() {
        return new PerThreadInstance();
    }

    @Override
    public void dispose(PerThreadInstance instance) {
        throw new IllegalAccessError("This method should not have been called");
    }

}
