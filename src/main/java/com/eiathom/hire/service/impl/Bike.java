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

import com.eiathom.hire.service.api.BaseVehicle;
import com.eiathom.hire.service.api.Category;

/**
 * base class of Vehicle
 *
 * @author eiathom
 *
 */
public class Bike extends BaseVehicle {

    private final String make;
    private final Category category;

    public Bike(final String make, final Category category, final int yearManufactured) {
        super(yearManufactured);
        this.make = make;
        this.category = category;
    }

    @Override
    public String getMake() {
        return make;
    }

    @Override
    public Category getCategory() {
        return category;
    }

}