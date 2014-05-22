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
package com.fitbur.playground.hk2.ranking;

import com.fitbur.playground.hk2.ranking.impl.HigherRanked;
import com.fitbur.playground.hk2.ranking.impl.LowerRanked;
import javax.inject.Inject;
import org.glassfish.hk2.api.IterableProvider;
import org.jvnet.hk2.annotations.Service;

/**
 *
 * @author Sharmarke Aden
 */
@Service
public class RankedService {

    Ranked rankedService;
    IterableProvider<Ranked> rankedServices;
    HigherRanked higherRanked;
    LowerRanked lowerRanked;

    @Inject
    RankedService(Ranked rankedService,
            IterableProvider<Ranked> rankedServices,
            HigherRanked higherRanked,
            LowerRanked lowerRanked) {
        this.rankedService = rankedService;
        this.rankedServices = rankedServices;
        this.higherRanked = higherRanked;
        this.lowerRanked = lowerRanked;
    }

    public Ranked getRankedService() {
        return rankedService;
    }

    public IterableProvider<Ranked> getRankedServices() {
        return rankedServices;
    }

    public HigherRanked getHigherRanked() {
        return higherRanked;
    }

    public LowerRanked getLowerRanked() {
        return lowerRanked;
    }

}
