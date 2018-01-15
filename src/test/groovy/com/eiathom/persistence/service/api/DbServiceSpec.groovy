/**
 * Copyright 2018 eiathom
 * 
 * Licensed under the Apache License, Version 2.0 (the "License")
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
package com.eiathom.persistence.service.api

import spock.lang.*

import com.eiathom.persistence.service.api.DbService

/**
 * @author eiathom
 *
 */
class DbServiceSpec extends Specification {

    static CONNECTION_DETAILS = 'jdbc:postgresql://localhost/test'
    static SQL = 'SELECT * FROM some_table ORDER BY id DESC LIMIT 1;'

    def dbService = Mock(DbService)

    /**
     * test a database row can be loaded into memory
     */
    def "testLoadFromDb"() {
        setup: 'a datbase to return data'
            def id = "1"
            def data = "something"
            def testObject = new DatabaseObjectStub(id, data)
            dbService.loadFromDb(_, _, _) >> testObject

        when: 'an object type is loaded'
            def someObject = dbService.loadFromDb(CONNECTION_DETAILS, SQL, DatabaseObjectStub.class)

        then: 'expect a type to be loaded into memory'
            someObject.class == DatabaseObjectStub.class
            someObject == testObject
            someObject.getId() == id
            someObject.getData() == data
    }

    /**
     * test an Object in memory can be saved to a database
     */
    def "testSaveToDatabase"() {
        setup: 'a database to return data'
            def id = "1"
            def data = "something"
            def testObject = new DatabaseObjectStub(id, data)
            dbService.saveToDatabase(_, _) >> testObject

        when: 'an object type is saved'
            def someObject = dbService.saveToDatabase(testObject, CONNECTION_DETAILS)

        then: 'expect a database row to be created and an object to be loaded into memory'
            someObject.class == DatabaseObjectStub.class
            someObject == testObject
            someObject.getId() == id
            someObject.getData() == data
    }

    /**
     * test a database row can deleted
     */
    def "testDelete"() {
        setup: 'a datbase to return data'
            def id = "1"
            def data = "something"
            def testObject = new DatabaseObjectStub(id, data)
            dbService.loadFromDb(_, _, _) >> null

        when: 'an object type is deleted'
            dbService.delete(id, DatabaseObjectStub.class, CONNECTION_DETAILS)

        then: 'expect a row to be deleted in the database'
            dbService.loadFromDb(CONNECTION_DETAILS, SQL, DatabaseObjectStub.class) == null
    }

    class DatabaseObjectStub {
        String id
        Object data
        DatabaseObjectStub(id, data) {
            this.id = id
            this.data = data
        }
        def getId() {
            return this.id
        }
        def getData() {
            return this.data
        }
    }

}
