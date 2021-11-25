/*
 * Copyright (c) 2017, MegaEase
 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.megaease.easeagent.plugin.servicename.interceptor;

import com.megaease.easeagent.plugin.Interceptor;
import com.megaease.easeagent.plugin.api.config.Config;
import com.megaease.easeagent.plugin.enums.Order;
import com.megaease.easeagent.plugin.servicename.ServiceNameConfig;
import com.megaease.easeagent.plugin.tools.config.AutoRefreshRegistry;

public abstract class BaseServiceNameInterceptor implements Interceptor {
    protected static  ServiceNameConfig config = null;
    @Override
    public void init(Config pConfig, String className, String methodName, String methodDescriptor) {
        config = AutoRefreshRegistry.getOrCreate(pConfig, ServiceNameConfig.SUPPLIER);
    }

    @Override
    public int order() {
        return Order.HIGH.getOrder();
    }

    @Override
    public String getName() {
        return "addServiceNameHead";
    }
}
