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

import com.fitbur.playground.hk2.core.PerLookupInstance;
import org.glassfish.hk2.api.Factory;
import org.glassfish.hk2.api.PerLookup;
import org.jvnet.hk2.annotations.Service;

/**
 *
 * @author Sharmarke Aden
 */
@Service
public class PerLookupFactory implements Factory<PerLookupInstance> {

    @PerLookup
    @Override
    public PerLookupInstance provide() {
        return new PerLookupInstance();
    }

    @Override
    public void dispose(PerLookupInstance instance) {
        throw new IllegalAccessError("This method should not have been called");
    }

}
