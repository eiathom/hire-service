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

    private final String name;
    private final Integer age;
    private final String licenseNumber;
    private final Set<HireRecord> hireRecords;

    public Client(final String name, final Integer age, final String licenseNumber) {
        this(name, age, licenseNumber, new HashSet<HireRecord>(1));
    }

    public Client(final String name, final Integer age, final String licenseNumber,
            final Set<HireRecord> hireRecords) {
        this.name = name;
        this.age = age;
        this.licenseNumber = licenseNumber;
        this.hireRecords = hireRecords;
    }

    public String getName() {
        return this.name;
    }

    public Integer getAge() {
        return this.age;
    }

    public String getLicenseNumber() {
        return this.licenseNumber;
    }

    public Set<HireRecord> getHireRecords() {
        return this.hireRecords;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((age == null) ? 0 : age.hashCode());
        result = prime * result + ((licenseNumber == null) ? 0 : licenseNumber.hashCode());
        result = prime * result + ((hireRecords == null) ? 0 : hireRecords.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj != null && obj instanceof Client) {
            final Client other = (Client) obj;
            return this.name.equals(other.name)
                    && this.age.equals(other.age)
                    && this.licenseNumber.equals(other.licenseNumber)
                    && this.hireRecords.equals(other.hireRecords);
        }
        return false;
    }

    @Override
    public String toString() {
        return new StringBuilder(this.getClass().getSimpleName())
                .append("[name=").append(this.name)
                .append(", age=").append(this.age)
                .append(", licenseNumber=").append(this.licenseNumber)
                .append(", hireRecords=").append(this.hireRecords)
                .append("]").toString();
    }

}
