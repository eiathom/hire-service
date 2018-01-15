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

import java.sql.Date;

import com.eiathom.hire.service.api.Vehicle;

/**
 * class representing a hire record
 *
 * @author eiathom
 *
 */
public class HireRecord {

    private final Client client;
    private final Vehicle vehicle;
    private final Date hireStartDate;
    private final Date hireEndDate;

    public HireRecord(final Client client, final Vehicle vehicle, final Date hireStartDate,
            final Date hireEndDate) {
        this.client = client;
        this.vehicle = vehicle;
        this.hireStartDate = hireStartDate;
        this.hireEndDate = hireEndDate;
    }

    public Client getClient() {
        return this.client;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public Date getHireStartDate() {
        return this.hireStartDate;
    }

    public Date getHireEndDate() {
        return this.hireEndDate;
    }

}
