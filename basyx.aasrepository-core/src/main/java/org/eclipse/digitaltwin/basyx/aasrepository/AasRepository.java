/*******************************************************************************
 * Copyright (C) 2023 the Eclipse BaSyx Authors
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
package org.eclipse.digitaltwin.basyx.aasrepository;

import java.util.List;

import org.eclipse.digitaltwin.aas4j.v3.model.AssetAdministrationShell;
import org.eclipse.digitaltwin.basyx.aasrepository.exceptions.CollidingIdentifierException;
import org.eclipse.digitaltwin.basyx.aasrepository.exceptions.ElementDoesNotExistException;

/**
 * Specifies the overall AasRepository API
 * 
 * @author schnicke
 *
 */
public interface AasRepository {

	/**
	 * Retrieves all Asset Administration Shells from the repository
	 * 
	 * @return a list of all found Asset Administration Shells
	 */
	public List<AssetAdministrationShell> getAASList();

	/**
	 * Retrieves a specific AAS
	 * 
	 * @param aasId
	 *            the id of the AAS
	 * @return the requested AAS
	 */
	public AssetAdministrationShell getAAS(String aasId) throws ElementDoesNotExistException;

	/**
	 * Creates a new AAS at the endpoint
	 * 
	 * @param aas
	 *            the AAS to be created
	 */
	public void createAAS(AssetAdministrationShell aas) throws CollidingIdentifierException;

	/**
	 * Deletes a specific AAS
	 * 
	 * @param aasId
	 *            the id of the AAS to be deleted
	 */
	public void deleteAAS(String aasId);

	/**
	 * Overwrites an existing AAS
	 * 
	 * @param aas
	 */
	public void updateAAS(AssetAdministrationShell aas);

	public default String getName() {
		return "aasRepository-default-name";
	}
}