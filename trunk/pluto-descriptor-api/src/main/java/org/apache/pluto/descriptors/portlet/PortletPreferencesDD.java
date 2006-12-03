/*
 * Copyright 2003,2004 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.pluto.descriptors.portlet;

import java.util.List;
import java.util.ArrayList;

/**
 * Portlet preferences definition in portlet.xml.
 *
 * @see PortletPreferenceDD
 * 
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>
 * @author <a href="mailto:zheng@apache.org">ZHENG Zhong</a>
 * @since Jun 29, 2005
 */
public class PortletPreferencesDD {
	
	/** List of portlet preferences. */
    private List portletPreferences = new ArrayList();
    
    /** Portlet preferences validator class name. */
    private String preferencesValidator;

    public List getPortletPreferences() {
        return portletPreferences;
    }

    public void setPortletPreferences(List portletPreferences) {
        this.portletPreferences = portletPreferences;
    }

    public String getPreferencesValidator() {
        return preferencesValidator;
    }

    public void setPreferencesValidator(String preferencesValidator) {
        this.preferencesValidator = preferencesValidator;
    }
}