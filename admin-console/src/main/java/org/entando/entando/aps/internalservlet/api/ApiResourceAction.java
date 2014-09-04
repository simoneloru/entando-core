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
package org.entando.entando.aps.internalservlet.api;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.agiletec.aps.system.SystemConstants;
import com.agiletec.aps.system.exception.ApsSystemException;
import com.agiletec.aps.system.services.baseconfig.ConfigInterface;

/**
 * @author E.Santoboni
 */
public class ApiResourceAction extends org.entando.entando.apsadmin.api.ApiResourceAction implements ServletResponseAware {

	private static final Logger _logger = LoggerFactory.getLogger(ApiResourceAction.class);
	
	@Override
	public String generateRequestBodySchema() {
		try {
			String result = super.generateRequestBodySchema();
			if (!result.equals(SUCCESS)) return result;
			this.getResponse().sendRedirect(this.generateRedirectUrl("executeRequestSchema"));
		} catch (Throwable t) {
			_logger.error("error in generateRequestBodySchema", t);
			//ApsSystemUtils.logThrowable(t, this, "generateRequestBodySchema");
			return FAILURE;
		}
		return null;
	}
	
	public String executeRequestBodySchema() {
		return super.generateRequestBodySchema();
	}
	
	@Override
	public String generateResponseBodySchema() {
		try {
			String result = super.generateResponseBodySchema();
			if (!result.equals(SUCCESS)) return result;
			this.getResponse().sendRedirect(this.generateRedirectUrl("executeResponseSchema"));
		} catch (Throwable t) {
			_logger.error("error in generateRequestBodySchema", t);
			//ApsSystemUtils.logThrowable(t, this, "generateRequestBodySchema");
			return FAILURE;
		}
		return null;
	}
	
	public String executeResponseBodySchema() {
		return super.generateResponseBodySchema();
	}
	
	private String generateRedirectUrl(String actionName) throws ApsSystemException {
		String url = null;
		try {
			String applicationBaseUrl = this.getConfigManager().getParam(SystemConstants.PAR_APPL_BASE_URL);
			StringBuilder builder = new StringBuilder(applicationBaseUrl);
			if (!builder.toString().endsWith("/")) builder.append("/");
			builder.append("do/Front/Api/Resource/").append(actionName).append(".action");
			builder.append("?resourceName=").append(this.getResourceName());
			builder.append("&namespace=").append(this.getNamespace());
			builder.append("&httpMethod=").append(this.getHttpMethod());
			url = this.getResponse().encodeRedirectURL(builder.toString());
		} catch (Throwable t) {
			_logger.error("Error generating redirect url ", t);
			//ApsSystemUtils.logThrowable(t, this, "generateRedirectUrl");
			throw new ApsSystemException("Error generating redirect url", t);
		}
		return url;
	}
	
	protected HttpServletResponse getResponse() {
		return _response;
	}
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this._response = response;
	}
	
	protected ConfigInterface getConfigManager() {
		return _configManager;
	}
	public void setConfigManager(ConfigInterface configManager) {
		this._configManager = configManager;
	}
	
	private HttpServletResponse _response;
	
	private ConfigInterface _configManager;
	
}