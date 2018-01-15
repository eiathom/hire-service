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

import java.sql.SQLException;
import java.sql.Date;

import com.eiathom.hire.service.dao.Dao;

import com.eiathom.hire.service.api.HireService;
import com.eiathom.hire.service.api.Vehicle;
import com.eiathom.persistence.service.api.DbService;

/**
 * API specifying operations capable on a HireService application
 *
 * @author eiathom
 *
 */
public class HireServiceImpl implements HireService {

    private final Dao dao;

    public HireServiceImpl(final Dao dao) {
        this.dao = dao;
    }

    @Override
    public HireRecord hire(final String dbAuthentication, final Client client,
            final Vehicle vehicle, final Date hireStartDate, final Date hireEndDate) {
        final boolean created = getDao().create(dbAuthentication, client);
        return null;
    }

    public Dao getDao() {
        return dao;
    }

}
