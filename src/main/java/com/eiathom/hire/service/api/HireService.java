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
package com.eiathom.hire.service.api;

import java.sql.Date;

import com.eiathom.hire.service.impl.Client;
import com.eiathom.hire.service.impl.HireRecord;

/**
 * API specifying operations capable on a HireService application
 *
 * @author eiathom
 *
 */
public interface HireService {

    /**
     * save a HireRecord to a database
     *
     * @param dbAuthentication a username and password json String to connect to the database
     * @param client a client making a hire request
     * @param vehicle a vehicle requested for hire
     * @param hireStartDate the start date of this hire
     * @param hireEndDate the end date of this hire
     * @return a record of the hire
     */
    public HireRecord hire(final String dbAuthentication, final Client client,
        final Vehicle vehicle, final Date hireStartDate, final Date hireEndDate);

}
