/*
 * Copyright 2014 Click Travel Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package com.clicktravel.cheddar.infrastructure.persistence.document.search;

import com.clicktravel.cheddar.infrastructure.persistence.document.search.query.Query;

public interface DocumentSearchEngine {

    void update(Document document);

    void delete(Document document);

    /**
     * Search for documents based on the given query
     * 
     * @param query describing the documents you wish to return
     * @param start the index of the first document you want to return <code>null</code> will default to the index of
     *            the first document in the results
     * @param size the size of the page of documents you want returned; leave <code>null</code> to return up the
     *            implementation defined default size
     * @param documentClass the type of document being queried
     * @return a DocumentSearchResponse containing a page of documents matching the supplied query along with results
     *         metadata
     */
    <T extends Document> DocumentSearchResponse<T> search(final Query query, final Integer start, final Integer size,
            Class<T> documentClass);

}