/**
 * Copyright 2011 Niall Gallagher
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.googlecode.mobilityrpc.protocol.converters.components;

import com.googlecode.mobilityrpc.protocol.converters.ComponentConverter;
import com.googlecode.mobilityrpc.protocol.protobuf.ComponentUuid;

import java.util.UUID;

/**
 * @author Niall Gallagher
 */
public class UuidComponentConverter implements ComponentConverter<UUID, ComponentUuid.UUID, ComponentUuid.UUID.Builder> {

    @Override
    public UUID convertFromProtobuf(ComponentUuid.UUID uuid) {
        return new UUID(
                uuid.getMostSignificantBits(),
                uuid.getLeastSignificantBits()
        );
    }

    @Override
    public ComponentUuid.UUID.Builder convertToProtobuf(UUID javaObject) {
        ComponentUuid.UUID.Builder builder = ComponentUuid.UUID.newBuilder();
        builder.setMostSignificantBits(javaObject.getMostSignificantBits());
        builder.setLeastSignificantBits(javaObject.getLeastSignificantBits());
        return builder;
    }
}
