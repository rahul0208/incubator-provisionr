/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.provisionr.cloudstack.activities;

import org.apache.provisionr.api.pool.Pool;
import org.apache.provisionr.cloudstack.core.KeyPairs;
import org.activiti.engine.delegate.DelegateExecution;
import org.jclouds.cloudstack.CloudStackClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeleteKeyPair extends CloudStackActivity {

    private static final Logger LOG = LoggerFactory.getLogger(DeleteKeyPair.class);

    @Override
    public void execute(CloudStackClient cloudStackClient, Pool pool, DelegateExecution execution) {
        String keyName = KeyPairs.formatNameFromBusinessKey(execution.getProcessBusinessKey());
        LOG.info("Deleting Admin Access Key pair {}", keyName);
        cloudStackClient.getSSHKeyPairClient().deleteSSHKeyPair(keyName);
    }
}
