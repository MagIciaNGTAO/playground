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
package com.fitbur.playground.hk2.aop.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;
import org.aopalliance.intercept.ConstructorInterceptor;
import org.aopalliance.intercept.MethodInterceptor;
import org.glassfish.hk2.api.Filter;
import org.glassfish.hk2.api.InterceptionService;
import org.glassfish.hk2.utilities.BuilderHelper;
import org.jvnet.hk2.annotations.Service;

/**
 *
 * @author Sharmarke Aden
 */
@Service
public class AccessInterceptionService implements InterceptionService {

    private final AccessInterceptor interceptor;

    @Inject
    AccessInterceptionService(AccessInterceptor interceptor) {
        this.interceptor = interceptor;
    }

    @Override
    public Filter getDescriptorFilter() {
        return BuilderHelper.allFilter();
    }

    @Override
    public List<MethodInterceptor> getMethodInterceptors(Method method) {
        if (method.isAnnotationPresent(Access.class)) {
            return Collections.singletonList(interceptor);
        }
        return null;
    }

    @Override
    public List<ConstructorInterceptor> getConstructorInterceptors(Constructor<?> constructor) {
        if (constructor.isAnnotationPresent(Access.class)) {
            return Collections.singletonList(interceptor);
        }
        return null;
    }

}
