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

import java.util.Set;
import java.util.HashSet;

import com.eiathom.hire.service.impl.HireRecord;

/**
 * class representing a client of HireService
 *
 * @author eiathom
 *
 */
public class Client {

    private final Long id;
    private final String firstName;
    private final String lastName;
    private final Integer age;
    private final String licenseNumber;

    public Client(final Long id, final String firstName, final String lastName, final Integer age,
            final String licenseNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.licenseNumber = licenseNumber;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Integer getAge() {
        return this.age;
    }

    public String getLicenseNumber() {
        return this.licenseNumber;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((age == null) ? 0 : age.hashCode());
        result = prime * result + ((licenseNumber == null) ? 0 : licenseNumber.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj != null && obj instanceof Client) {
            final Client other = (Client) obj;
            return this.id.equals(other.id)
                    && this.firstName.equals(other.firstName)
                    && this.lastName.equals(other.lastName)
                    && this.age.equals(other.age)
                    && this.licenseNumber.equals(other.licenseNumber);
        }
        return false;
    }

    @Override
    public String toString() {
        return new StringBuilder(this.getClass().getSimpleName())
                .append("[id=").append(this.id)
                .append(", firstName=").append(this.firstName)
                .append(", lastName=").append(this.lastName)
                .append(", age=").append(this.age)
                .append(", licenseNumber=").append(this.licenseNumber)
                .append("]").toString();
    }

}
