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
package com.fitbur.playground.hk2.qualified;

import com.fitbur.playground.hk2.qualified.impl.CustomQualifiedService;
import com.fitbur.playground.hk2.qualified.impl.DefaultNamedService;
import com.fitbur.playground.hk2.qualified.impl.ExplicitlyNamedService;
import javax.inject.Inject;
import javax.inject.Named;
import org.jvnet.hk2.annotations.Service;

/**
 *
 * @author Sharmarke Aden
 */
@Service
public class NamedService {

    private final DefaultNamedService defaultNamedService;
    private final CustomQualifiedService customQualifiedService;
    private final ExplicitlyNamedService explicitlyNamedService;

    @Inject
    NamedService(DefaultNamedService defaultNamedService,
            @CustomQualifier CustomQualifiedService customQualifiedService,
            @Named("explicit") ExplicitlyNamedService explicitlyNamedService) {
        this.defaultNamedService = defaultNamedService;
        this.customQualifiedService = customQualifiedService;
        this.explicitlyNamedService = explicitlyNamedService;
    }

    public DefaultNamedService getDefaultNamedService() {
        return defaultNamedService;
    }

    public CustomQualifiedService getCustomQualifiedService() {
        return customQualifiedService;
    }

    public ExplicitlyNamedService getExplicitlyNamedService() {
        return explicitlyNamedService;
    }

}
