/*
 * Copyright (c) 2012 S.C. Axemblr Software Solutions S.R.L
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.provisionr.api.provider;

import static org.apache.provisionr.api.AssertSerializable.assertSerializable;
import static org.fest.assertions.api.Assertions.assertThat;
import org.junit.Test;

public class ProviderTest {

    @Test
    public void testSerialization() {
        Provider provider = Provider.builder()
            .id("aws-ec2").accessKey("access").secretKey("secret")
            .option("location", "eu-west-1").createProvider();

        assertThat(provider.getAccessKey()).isEqualTo("access");
        assertThat(provider.getOptions()).containsKey("location");
        assertThat(provider.toBuilder().createProvider()).isEqualTo(provider);

        assertSerializable(provider, Provider.class);
    }

}