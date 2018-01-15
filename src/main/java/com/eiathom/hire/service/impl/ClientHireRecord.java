/**
 * Copyright 2018 eiathom
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
package com.eiathom.hire.service.impl;

import java.util.List;
import java.util.ArrayList;

/**
 * class representing a Client HireRecord mapping
 *
 * @author eiathom
 *
 */
public class ClientHireRecord {

    private final Client client;

    private final List<HireRecord> records;

    public ClientHireRecord(final Client client) {
        this(client, new ArrayList<HireRecord>(1));
    }

    public ClientHireRecord(final Client client, final List<HireRecord> records) {
        this.client = client;
        this.records = records;
    }

    public Client getClient() {
        return this.client;
    }

    // yes, this ain't mutable
    public List<HireRecord> getHireRecords() {
        return this.records;
    }

}
