/**
 * Copyright (C) 2016 DSpot Sp. z o.o
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
package com.dspot.declex.action;

import javax.lang.model.element.Element;

import org.androidannotations.AndroidAnnotationsEnvironment;

import com.dspot.declex.util.TypeUtils;

public abstract class BaseSystemClassActionHandler extends BaseActionHandler {
	
	@Override
	public boolean canProcessElement(Element element, AndroidAnnotationsEnvironment environment) {
		super.canProcessElement(element, environment);
		
		String elementClass = element.asType().toString();
		if (TypeUtils.isSubtype(elementClass, getClassName(), processingEnv))
			return true;
		
		return false;
	}
	
	public abstract String getClassName();
	
	@Override
	protected boolean useEnhancedClass() {
		return false;
	}

}
