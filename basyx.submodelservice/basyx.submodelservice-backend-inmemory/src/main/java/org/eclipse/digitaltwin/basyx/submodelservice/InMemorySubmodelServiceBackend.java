/*******************************************************************************
 * Copyright (C) 2024 the Eclipse BaSyx Authors
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

package org.eclipse.digitaltwin.basyx.submodelservice;

import org.eclipse.digitaltwin.aas4j.v3.model.Submodel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public class InMemorySubmodelServiceBackend implements CrudRepository<Submodel,String> {

    private Submodel submodel;

    public InMemorySubmodelServiceBackend(Submodel submodel) {
        this.submodel = submodel;
    }

    @Override
    public <S extends Submodel> S save(S entity) {
        this.submodel = entity;
        return entity;
    }

    @Override
    public <S extends Submodel> Iterable<S> saveAll(Iterable<S> entities) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<Submodel> findById(String s) {
        if(submodel.getId().equals(s))
            return Optional.of(submodel);
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return submodel.getId().equals(s);
    }

    @Override
    public Iterable<Submodel> findAll() {
        return List.of(submodel);
    }

    @Override
    public Iterable<Submodel> findAllById(Iterable<String> strings) {
        throw new UnsupportedOperationException();
    }

    @Override
    public long count() {
        return 1;
    }

    @Override
    public void deleteById(String s) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(Submodel entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll(Iterable<? extends Submodel> entities) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException();
    }
}
