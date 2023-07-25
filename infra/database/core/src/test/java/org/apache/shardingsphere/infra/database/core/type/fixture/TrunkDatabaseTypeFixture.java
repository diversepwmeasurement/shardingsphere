/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.infra.database.core.type.fixture;

import org.apache.shardingsphere.infra.database.core.type.DataSourceMetaData;
import org.apache.shardingsphere.infra.database.core.type.DatabaseType;
import org.apache.shardingsphere.infra.database.core.type.enums.NullsOrderType;
import org.apache.shardingsphere.infra.database.core.type.enums.QuoteCharacter;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class TrunkDatabaseTypeFixture implements DatabaseType {
    
    @Override
    public QuoteCharacter getQuoteCharacter() {
        return QuoteCharacter.BACK_QUOTE;
    }
    
    @Override
    public NullsOrderType getDefaultNullsOrderType() {
        return NullsOrderType.FIRST;
    }
    
    @Override
    public boolean isReservedWord(final String identifier) {
        return "SELECT".equalsIgnoreCase(identifier);
    }
    
    @Override
    public Collection<String> getJdbcUrlPrefixes() {
        return Collections.singleton("jdbc:trunk:");
    }
    
    @Override
    public DataSourceMetaData getDataSourceMetaData(final String url, final String username) {
        return new DataSourceMetaDataFixture(url);
    }
    
    @Override
    public Map<String, Collection<String>> getSystemDatabaseSchemaMap() {
        return new HashMap<>();
    }
    
    @Override
    public Collection<String> getSystemSchemas() {
        return Collections.emptyList();
    }
    
    @Override
    public String getType() {
        return "TRUNK";
    }
    
    @Override
    public boolean isDefault() {
        return true;
    }
}