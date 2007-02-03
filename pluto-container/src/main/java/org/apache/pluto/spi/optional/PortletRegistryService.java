/*
 * Copyright 2004 The Apache Software Foundation.
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
package org.apache.pluto.spi.optional;

import org.apache.pluto.descriptors.portlet.PortletAppDD;
import org.apache.pluto.PortletContainerException;

import java.util.Iterator;
import java.util.Map;

/**
 * Interface defining the services used by the container
 * to access portlet application descriptors.  The registry
 * acts as both internally as descriptor cache and publically
 * as a mechanism for notifying the container of new applications.
 *
 * @since 1.1.0
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>
 * 
 */
public interface PortletRegistryService {

    /**
     * Retrieve all registered applications.  This list
     * will only contain those applications which have
     * been registered with the container.  Others may
     * or may not be available within the servers.
     *
     * @return iterator of all application descriptors.
     */
    Iterator getRegisteredPortletApplications()
        throws PortletContainerException;

    /**
     * Retrieve the portlet descriptor for the specified
     * portlet application. If the name does not match
     * the name of a contextPath registered with the container
     * the portlet application name must be checked.
     *
     * @param name the name of the portlet application.
     * @return the named portlet application descriptor.
     * @throws PortletContainerException if the descriptor
     *         can not be found or if the portlet.xml can not be parsed.
     */
    PortletAppDD getPortletApplicationDescriptor(String name)
        throws PortletContainerException;

    /**
     * Add a listener which will recieve notifications of newly
     * registered applications.
     *
     * @param listener the listener to add
     */
    void addPortletRegistryListener(PortletRegistryListener listener);

    /**
     * Remove a previously registered listener.
     *
     * @param listener the listener to remove
     */
    void removePortletRegistryListener(PortletRegistryListener listener);

    
}