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
package com.eiathom.hire.service.api;

import java.util.Calendar;

/**
 * base class of Vehicle
 *
 * @author eiathom
 *
 */
public abstract class BaseVehicle implements Vehicle {

    protected final Long id;

    protected final Integer yearManufactured;

    protected final String make;

    protected final Category category;

    protected Boolean hired;

    public BaseVehicle(final Long id, final String make, final Category category,
            final Integer yearManufactured) {
        this(id, make, category, yearManufactured, false);
    }

    public BaseVehicle(final Long id, final String make, final Category category,
            final Integer yearManufactured, final Boolean hired) {
        this.id = id;
        this.make = make;
        this.category = category;
        this.yearManufactured = yearManufactured;
        this.hired = hired;
    }

    public Long getId() {
        return this.id;
    }

    public Boolean isHired() {
        return hired;
    }

    public void setHired(final Boolean hired) {
        this.hired = hired;
    }

    public Integer getAge() {
        return Calendar.getInstance().get(Calendar.YEAR) - this.yearManufactured;
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
