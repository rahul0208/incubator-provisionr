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

package org.apache.provisionr.api.hardware;

import static com.google.common.base.Preconditions.checkNotNull;

import org.apache.provisionr.api.util.WithOptions;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.Map;

public class Hardware extends WithOptions {

    public static HardwareBuilder builder() {
        return new HardwareBuilder();
    }

    private final String type;
    private List<BlockDevice> blockDevices;

    Hardware(String type, List<BlockDevice> blockDevices, Map<String, String> options) {
        super(options);
        this.type = checkNotNull(type, "type is null");
        this.blockDevices = ImmutableList.copyOf(blockDevices);
    }

    public String getType() {
        return type;
    }

    public List<BlockDevice> getBlockDevices() {
        return blockDevices;
    }

    public HardwareBuilder toBuilder() {
        return builder().type(type).blockDevices(blockDevices).options(getOptions());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(type, getOptions(), getBlockDevices());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Hardware other = (Hardware) obj;
        return Objects.equal(this.type, other.type)
            && Objects.equal(this.getOptions(), other.getOptions())
            && Objects.equal(this.getBlockDevices(), other.getBlockDevices());
    }

    @Override
    public String toString() {
        return "Hardware{" +
            "type='" + type + '\'' +
            ", blockDevices=" + getBlockDevices() + 
            ", options=" + getOptions() +
            '}';
    }
}
