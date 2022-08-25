/*
 * Tencent is pleased to support the open source community by making Spring Cloud Tencent available.
 *
 * Copyright (C) 2019 THL A29 Limited, a Tencent company. All rights reserved.
 *
 * Licensed under the BSD 3-Clause License (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://opensource.org/licenses/BSD-3-Clause
 *
 * Unless required by applicable law or agreed to in writing, software distributed
 * under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 */

package com.tencent.cloud.plugin.pushgateway;

import com.tencent.cloud.polaris.context.ConditionalOnPolarisEnabled;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @author lingxiao.wlx
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnPolarisEnabled
@EnableConfigurationProperties(PolarisStatPushGatewayProperties.class)
public class PolarisStatPushGatewayAutoConfiguration {

	@Bean
	@ConditionalOnMissingBean
	public PolarisStatPushGatewayModifier polarisStatPushGatewayModifier(PolarisStatPushGatewayProperties polarisStatPushGatewayProperties,
				Environment environment) {
		return new PolarisStatPushGatewayModifier(polarisStatPushGatewayProperties, environment);
	}
}