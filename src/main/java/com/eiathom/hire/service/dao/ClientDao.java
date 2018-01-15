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

import com.eiathom.hire.service.impl.Client;
import com.eiathom.persistence.service.api.DbService;

/**
 * @author eiathom
 *
 */
public class ClientDao extends BaseDao<Client> {

    private static final String SELECT_CLIENT_BY_LICENSE_NUMBER_QUERY = "SELECT * FROM client WHERE license_number = %s";

    public ClientDao(final DbService dbService) {
        super(dbService);
    }

    @Override
    public boolean create(final String connectionDetails, final Client object) {
        Client client = null;
        System.out.println("connectionDetails: " + connectionDetails);
        try {
            final String connection = getConnection(connectionDetails);
            System.out.println("connection: " + connection);
            client = (Client) getDbService().saveToDatabase(object, connection);
            System.out.println(client);
            return client != null;
        } catch(final Exception exception) {
            System.err.println(exception.getMessage());
        }
        return false;
    }

    @Override
    public Client read(final String connectionDetails, final Client object) {
        Client client = null;
        try {
            final String connection = getConnection(connectionDetails);
            final String sql = String.format(SELECT_CLIENT_BY_LICENSE_NUMBER_QUERY,
                object.getLicenseNumber());
            client = (Client) getDbService().loadFromDb(connection, sql, Client.class);
            return client;
        } catch(final Exception exception) {
            System.err.println(exception.getMessage());
        }
        return client;
    }

    @Override
    public void update(final String connectionDetails, final Client object) {
        try {
            final String connection = getConnection(connectionDetails);
            final Client client = (Client) getDbService().saveToDatabase(object, connection);
            System.out.println("Saved: " + client);
        } catch(final Exception exception) {
            System.err.println(exception.getMessage());
        }
    }

    @Override
    public boolean delete(final String connectionDetails, final Client object) {
        try {
            final String connection = getConnection(connectionDetails);
            getDbService().delete(String.valueOf(object.getId()), Client.class, connection);
            return true;
        } catch(final Exception exception) {
            System.err.println(exception.getMessage());
        }
        return false;
    }

}
