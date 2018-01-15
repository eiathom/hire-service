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
package com.eiathom.hire.service.dao

import spock.lang.*

import com.eiathom.hire.service.impl.Client
import com.eiathom.persistence.service.api.DbService

/**
 * @author eiathom
 *
 */
class DaoSpec extends Specification {

    def mockedDbService = Mock(DbService)

    // object under test
    def clientDao

    def setup() {
        clientDao = new ClientDao(mockedDbService)
    }

    def "do some really good test"() {
        given: 'a database return object'
            mockedDbService.saveToDatabase(_ as Client, _ as String) >> { args -> args[0].getId() == 1 ? args[0] : null }

        and: 'a database connection'
            def connection = '{"username" : "someone", "password" : "something"}'

        and: 'an aboject to save'
            def objectToSave = getClient()

        when: 'an attempt is made to save a new, valid object'
            def result = clientDao.create(connection, objectToSave)

        then: 'the object is saved'
            result == true
    }

    def getClient() {
        return new Client(1, "first", "last", 21, "99-OY-1234567")
    }

}
