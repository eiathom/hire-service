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

import static com.eiathom.hire.service.impl.DbConnectionConstants.DB_CONNECTION_DETAILS;

import java.sql.SQLException;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import org.json.JSONObject;


/**
 * Helper class to build a valid DB connection
 *
 * @author eiathom
 *
 */
public final class DbConnectionHelper {

    private static final String USERNAME_JSON_KEY = "username";

    private static final String PASSWORD_JSON_KEY = "password";

    private static Pattern PATTERN = Pattern.compile("^\\{\\s*(\"username\")\\s*:\\s*(\"\\w+\"),\\s*(\"password\")\\s*:\\s*(\"\\w+\")\\s*}$");;

    private DbConnectionHelper() {}

    /**
     * For a database connection, we need to pass autherization parameters to a DB connection String
     *
     * @param json a JSON String (username, password) used to access the DB
     * @return a DB connection String
     */
    public String getConnectionDetails(final String json) throws SQLException {
        if(isValidInput(json)) {

            final JSONObject jsonObject = new JSONObject(json);

            return String.format(DB_CONNECTION_DETAILS, jsonObject.getString(USERNAME_JSON_KEY),
                    jsonObject.getString(PASSWORD_JSON_KEY));
        }

        throw new SQLException("cannot access this DB using '" + json + "'");
    }

    /**
     * Tests whether an input String is valid DB connection JSON autherization String
     *
     * @param input String input to test
     * @return whether the input String is valid
     */
    private boolean isValidInput(final String input) {
        final Matcher matcher = PATTERN.matcher(input);
        return matcher.matches();
    }

    private static class Holder {
        static final DbConnectionHelper INSTANCE = new DbConnectionHelper();
    }

    public static DbConnectionHelper getInstance() {
        return Holder.INSTANCE;
    }

}
