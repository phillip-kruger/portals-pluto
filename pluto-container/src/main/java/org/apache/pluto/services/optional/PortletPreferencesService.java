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
/* 

 */

package org.apache.pluto.services.optional;

import javax.portlet.PortletRequest;

import org.apache.pluto.PortletWindow;
import org.apache.pluto.PortletContainerException;
import org.apache.pluto.services.ContainerService;
import org.apache.pluto.core.PortletPreference;

public interface PortletPreferencesService extends ContainerService {

    PortletPreference[] getStoredPreferences(PortletWindow window,
                                             PortletRequest req)
        throws PortletContainerException;

    void store(PortletWindow window,
               PortletRequest req,
               PortletPreference[] preferences)
        throws PortletContainerException;

}