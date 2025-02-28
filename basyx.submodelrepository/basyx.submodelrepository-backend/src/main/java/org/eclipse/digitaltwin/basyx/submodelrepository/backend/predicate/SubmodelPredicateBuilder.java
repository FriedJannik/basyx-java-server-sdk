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

package org.eclipse.digitaltwin.basyx.submodelrepository.backend.predicate;

import com.querydsl.core.types.Predicate;
import org.eclipse.digitaltwin.basyx.core.qtypes.QQuerySubmodel;

import java.util.List;

public class SubmodelPredicateBuilder {

    /**
     * Builds a Querydsl Predicate to filter SubmodelEntities by a list of IDs.
     *
     * @param submodelIdFilter a list of Submodel IDs
     * @return a Predicate filtering by the provided IDs
     */
    public static Predicate buildSubmodelIdPredicate(List<String> submodelIdFilter) {
        return QQuerySubmodel.querySubmodel.id.in(submodelIdFilter);
    }

    public static Predicate buildSubmodelSemanticIdPredicate(String semanticId) {
        return QQuerySubmodel.querySubmodel.keyValues.contains(semanticId);
    }
}
