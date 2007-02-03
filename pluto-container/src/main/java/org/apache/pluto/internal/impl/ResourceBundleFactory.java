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
package org.apache.pluto.internal.impl;

import org.apache.pluto.descriptors.portlet.PortletDD;
import org.apache.pluto.descriptors.portlet.PortletInfoDD;
import org.apache.pluto.util.StringManager;
import org.apache.pluto.spi.optional.PortletInfoService;
import org.apache.pluto.PortletWindow;
import org.apache.pluto.core.ContainerInvocation;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;

import java.util.*;

/**
 * Factory object used to create Portlet Resource Bundles.
 *
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 *
 */
class ResourceBundleFactory {
    
    private static final Log LOG = 
        LogFactory.getLog(ResourceBundleFactory.class);
    
    private static final StringManager EXCEPTIONS =
        StringManager.getManager(ResourceBundleFactory.class.getPackage().getName());

    /**
     * The default (no local) resources bundle for
     * this bundle.
     */
    private InlinePortletResourceBundle defaultBundle;

    /**
     * All of the previously loaded bundles.
     */
    private Map bundles = new HashMap();

    /**
     * The name of the bundle.
     */
    private String bundleName;

    public ResourceBundleFactory(PortletDD dd) {
        bundleName = dd.getResourceBundle();
        if(LOG.isDebugEnabled()) {
            LOG.debug("Resource Bundle Created: "+bundleName);
        }

        PortletInfoDD info = dd.getPortletInfo();

        PortletInfoService infoService = getPortletInfoService();
        PortletWindow window = getWindow();

        if(info != null) {
            String title = infoService == null ? info.getTitle() : infoService.getTitle(window);
            String shortTitle = infoService == null ? info.getShortTitle() : infoService.getShortTitle(window);
            String keywords = infoService == null ? info.getKeywords() : infoService.getKeywords(window);

            defaultBundle = new InlinePortletResourceBundle(
                title, shortTitle, keywords
            );
        }
        else {
            defaultBundle = new InlinePortletResourceBundle(new Object[][] { {"a", "b"} });
        }
   }

    public ResourceBundle getResourceBundle(Locale locale) {
        if(LOG.isDebugEnabled()) {
            LOG.debug("Resource Bundle: "+bundleName+" : "+locale+" requested. ");
        }

        // If allready loaded for this local, return immediately!
        if (bundles.containsKey(locale)) {
            return (ResourceBundle) bundles.get(locale);
        }

        try {
            ResourceBundle bundle = null;
            if(bundleName != null) {
                ClassLoader loader =
                        Thread.currentThread().getContextClassLoader();
                bundle = ResourceBundle.getBundle(bundleName, locale, loader);
                bundles.put(locale, new CombinedPortletResourceBundle(defaultBundle, bundle));
            }
            else {
                bundles.put(locale, defaultBundle);
            }
       } catch (MissingResourceException mre) {
            if(bundleName != null && LOG.isWarnEnabled()) {
                LOG.info(EXCEPTIONS.getString("warning.resourcebundle.notfound",bundleName, mre.getMessage()));
            }
            if(LOG.isDebugEnabled()) {
                LOG.debug("Using default bundle for locale ("+locale+").");
            }
            bundles.put(locale, defaultBundle);
        }
       return (ResourceBundle)bundles.get(locale);
    }


    private PortletInfoService getPortletInfoService() {
        ContainerInvocation invocation = ContainerInvocation.getInvocation();
        if(invocation != null) {
            return invocation.getPortletContainer().getOptionalContainerServices().getPortletInfoService();
        }
        return null;
    }

    private PortletWindow getWindow() {
        ContainerInvocation invocation = ContainerInvocation.getInvocation();
        if(invocation != null) {
            return invocation.getPortletWindow();
        }
        return null;
    }
}