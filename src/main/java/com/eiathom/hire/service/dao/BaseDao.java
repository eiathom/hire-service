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
package com.eiathom.hire.service.dao;

import java.sql.SQLException;

import com.eiathom.persistence.service.api.DbService;
import com.eiathom.hire.service.impl.DbConnectionHelper;

/**
 * @author eiathom
 *
 */
public abstract class BaseDao<T> implements Dao<T> {

    private static final DbConnectionHelper CONNECTION = DbConnectionHelper.getInstance();

    private final DbService dbService;

    public BaseDao(final DbService dbService) {
        this.dbService = dbService;
    }

    protected String getConnection(final String connectionDetails) throws SQLException {
        return getConnectionHelper().getConnectionDetails(connectionDetails);
    }

    protected DbService getDbService() {
        return this.dbService;
    }

    protected DbConnectionHelper getConnectionHelper() {
        return this.CONNECTION;
    }

}
