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

/**
 * class representing a hire record
 *
 * @author eiathom
 *
 */
public interface Vehicle {

    /**
     * @return a String representing the make of this Vehicle
     */
    public String getMake();

    /**
     * @return the category of this Vehicle
     */
    public Category getCategory();

    /**
     * @return the age of this Vehicle
     */
    public Integer getAge();

    /**
     * @return whether this Vehicle is hired
     */
    public Boolean isHired();

}
