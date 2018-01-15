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

    protected final int yearManufactured;

    protected boolean hired;

    public BaseVehicle(final int yearManufactured) {
        this.yearManufactured = yearManufactured;
    }

    public boolean isHired() {
        return hired;
    }

    public void setHired(final boolean hired) {
        this.hired = hired;
    }

    public Integer getAge() {
        return Calendar.getInstance().get(Calendar.YEAR) - this.yearManufactured;
    }

}
