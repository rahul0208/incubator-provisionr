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

package org.apache.provisionr.core.templates;

import org.apache.provisionr.api.pool.Pool;
import com.google.common.base.Function;

/**
 * Marker interface for pre-configured pools. You can use it by
 * applying the function on an existing pool definition
 */
public interface PoolTemplate extends Function<Pool, Pool> {

    /**
     * Get the pre-configured pool template identifier
     */
    String getId();

    /**
     * A short description of this template
     */
    String getDescription();

}
