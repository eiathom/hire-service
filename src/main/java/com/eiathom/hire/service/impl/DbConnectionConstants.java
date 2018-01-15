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

/**
 * DB connection constants
 *
 * @author eiathom
 *
 */
public final class DbConnectionConstants {

    private static final String COLON = ":";

    private static final String BACKSLASH = "/";

    private static final String CONNECTION = "jdbc";

    private static final String DATABASE = "postgresql";

    private static final String DATABASE_NAME = "test";

    private static final String DATABASE_SERVER = "localhost";

    private static final String DATABASE_SERVER_PORT = "5432";

    private static final String AUTHENTICATION = "?user=%s&password=%s&ssl=true";

    public static final String DB_CONNECTION_DETAILS = CONNECTION + COLON + DATABASE + COLON + BACKSLASH + BACKSLASH + DATABASE_SERVER + COLON + DATABASE_SERVER_PORT + BACKSLASH + DATABASE_NAME + AUTHENTICATION;

    private DbConnectionConstants() {}

}