/*
*
* Copyright 2014 Entando S.r.l. (http://www.entando.com) All rights reserved.
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
* Copyright 2014 Entando S.r.l. (http://www.entando.com) All rights reserved.
*
*/
package org.entando.entando.aps.system.services.widgettype.api;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.entando.entando.aps.system.services.api.model.AbstractApiResponse;
import org.entando.entando.aps.system.services.api.model.AbstractApiResponseResult;

/**
 * @author E.Santoboni
 */
@XmlRootElement(name = "response")
public class WidgetTypeResponse extends AbstractApiResponse {
	
	@Override
	@XmlElement(name = "result", required = true)
	public WidgetTypeResponseResult getResult() {
		return (WidgetTypeResponseResult) super.getResult();
	}
	
	public void setResult(WidgetTypeResponseResult result) {
		super.setResult(result);
	}
	
	@Override
	protected AbstractApiResponseResult createResponseResultInstance() {
		return new WidgetTypeResponseResult();
	}
	
}