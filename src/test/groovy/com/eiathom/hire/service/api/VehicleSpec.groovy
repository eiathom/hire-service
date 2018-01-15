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
package com.eiathom.hire.service.api

import spock.lang.*

import java.util.Calendar

import com.eiathom.hire.service.api.Vehicle
import com.eiathom.hire.service.api.BaseVehicle
import com.eiathom.hire.service.api.Category
import com.eiathom.hire.service.impl.Car
import com.eiathom.hire.service.impl.CarCategory

/**
 * @author eiathom
 *
 */
class VehicleSpec extends Specification {

    static CURRENT_YEAR = Calendar.getInstance().get(Calendar.YEAR)

    def "test hierarchial object"() {
        expect: 'many forms'
            def carCategory = CarCategory.SEDAN
            def vehicle = new Car(1, "Honda Accord", carCategory, 2001, "99-LS-10")
            vehicle instanceof Vehicle
            vehicle instanceof BaseVehicle
    }

    /**
     * do some interesting testing over time operations
     */
    def "do some test on time"() {
        given: 'some Vehicle object'
            def testYear = 2001
            def carCategory = CarCategory.SEDAN
            def vehicle = new Car(1, "Honda Accord", carCategory, testYear, "99-LS-10")
        when: 'we attempt to get the age of the Vehicle object'
            def yearManufactured = vehicle.getAge()
        then: 'we should get the age'
            yearManufactured == (CURRENT_YEAR - testYear)
    }

}
