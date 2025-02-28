/*******************************************************************************
 * Copyright (C) 2025 the Eclipse BaSyx Authors
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 * SPDX-License-Identifier: MIT
 ******************************************************************************/

package org.eclipse.digitaltwin.basyx.core.qtypes;

import jakarta.persistence.*;
import org.eclipse.digitaltwin.aas4j.v3.model.Reference;
import org.eclipse.digitaltwin.aas4j.v3.model.impl.DefaultSubmodel;
import org.eclipse.digitaltwin.basyx.core.qtypes.converter.ReferenceConverter;

import java.util.List;
import java.util.stream.Collectors;


/**
 * Generates the Q-Class for filtering via QuerydslPredicateExecutor
 *
 * @author fried
 */
@Entity
@Table(name = "submodel")
public class QuerySubmodel extends DefaultSubmodel {
    @Id
    protected String id;

    @Convert(converter = ReferenceConverter.class)
    protected Reference semanticId;

    @ElementCollection
    @CollectionTable(name = "submodel_key_values", joinColumns = @JoinColumn(name = "submodel_id"))
    @Column(name = "key_value")
    private List<String> keyValues;

    @Override
    public String getId() {
        return this.id;
    }
    @Override
    public Reference getSemanticId() {
        return semanticId;
    }

    public List<String> getKeyValues() {
        return keyValues;
    }

    public void setKeyValues(List<String> keyValues) {
        this.keyValues = keyValues;
    }

    @PrePersist
    @PreUpdate
    public void updateKeyValues() {
        if (semanticId != null) {
            this.keyValues = semanticId.getKeys().stream()
                    .map(key -> key.getValue()) // adjust extraction as needed
                    .collect(Collectors.toList());
        } else {
            this.keyValues = null;
        }
    }
}