/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.uima.fit.legacy.converter;

import org.apache.uima.fit.descriptor.FsIndex;
import org.apache.uima.fit.descriptor.FsIndexCollection;

public class FsIndexCollectionConverter
        extends
        ContextlessAnnotationConverterBase<org.uimafit.descriptor.FsIndexCollection, org.apache.uima.fit.descriptor.FsIndexCollection> {

  public FsIndexCollectionConverter() {
    // Nothing to do
  }

  @Override
  public FsIndexCollection convert(
          final org.uimafit.descriptor.FsIndexCollection aAnnotation) {
    return new FsIndexCollectionSubstitute(aAnnotation);
  }

  public Class<org.uimafit.descriptor.FsIndexCollection> getLegacyType() {
    return org.uimafit.descriptor.FsIndexCollection.class;
  }
  
  public Class<FsIndexCollection> getModernType() {
    return FsIndexCollection.class;
  }
  
  @SuppressWarnings("serial")
  public class FsIndexCollectionSubstitute extends
          AnnotationLiteral<FsIndexCollection> implements FsIndexCollection {

    private org.uimafit.descriptor.FsIndexCollection legacyAnnotation;
    
    public FsIndexCollectionSubstitute(org.uimafit.descriptor.FsIndexCollection aAnnotation) {
      legacyAnnotation = aAnnotation;
    }

    public FsIndex[] fsIndexes() {
      FsIndex[] result = new FsIndex[legacyAnnotation.fsIndexes().length];
      FsIndexConverter conv = new FsIndexConverter();
      int i = 0;
      for (org.uimafit.descriptor.FsIndex k : legacyAnnotation.fsIndexes()) {
        result[i] = conv.convert(k);
        i++;
      }
      return result;
    }
  }
}
