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
package com.eiathom.persistence.service.api;

import java.sql.SQLException;

/**
 * API specifying basic CRUD (Create, Read, Update, Delete) operations over an underlying database
 *
 * @author eiathom
 *
 */
public interface DbService {

    /**
     * Load, into memory, an Object representing a database row
     *
     * @param connectionDetails information enabling connection to a database
     * @param sql the SQL command used to retrieve a database row
     * @param type the type of Object representing the database row requested
     * 
     * @return an Object (if found) of Class 'type' representing a database row
     */
    public Object loadFromDb(final String connectionDetails, final String sql,
        final Class type) throws SQLException;

    /**
     * Save an Object, in memory, to a database
     *
     * @param data the Object to be saved
     * @param connectionDetails information enabling connection to a database
     *
     * @return an Object representing a database row
     */
    public Object saveToDatabase(final Object data,
        final String connectionDetails) throws SQLException;

    /**
     * Delete a database row
     *
     * @param id the id of a database row
     * @param type the type of Object representing a database row
     * @param connectionDetails information enabling connection to a database
     */
    public void delete(final String id, final Class type,
        final String connectionDetails) throws SQLException;

}
