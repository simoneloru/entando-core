/*
*
* Copyright 2013 Entando S.r.l. (http://www.entando.com) All rights reserved.
*
* This file is part of Entando software.
* Entando is a free software;
* You can redistribute it and/or modify it
* under the terms of the GNU General Public License (GPL) as published by the Free Software Foundation; version 2.
* 
* See the file License for the specific language governing permissions   
* and limitations under the License
* 
* 
* 
* Copyright 2013 Entando S.r.l. (http://www.entando.com) All rights reserved.
*
*/
package com.agiletec.apsadmin.system.entity.type;

/**
 * @author E.Santoboni
 */
public interface ICompositeAttributeConfigAction {
	
	public String addAttributeElement();
	
	public String moveAttributeElement();
	
	public String removeAttributeElement();
	
	public String saveAttributeElement();
	
	public String saveCompositeAttribute();
	
	public static final String COMPOSITE_ATTRIBUTE_ON_EDIT_SESSION_PARAM = "compositeAttributeOnEdit_sessionParam";
	
}
