/*
 * Copyright 2004 The Apache Software Foundation
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
package org.apache.pluto.maven;

import org.apache.pluto.util.assemble.Assembler;
import org.apache.pluto.util.assemble.AssemblerConfig;
import org.apache.pluto.util.assemble.AssemblerFactory;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.logging.Log;

import java.io.File;

/**
 * TODO: Document
 * TODO: Refactor this and the assembler to model deployer and allow no arg constructor
 * 
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>
 * @since Jul 30, 2005
 * @see org.apache.pluto.util.assemble.Assembler
 * 
 * @goal assemble
 * @description prepares a web application as a portlet application
 * @phase process-resources
 */
public class AssembleMojo extends AbstractPortletMojo {
	
	// Private Member Variables ------------------------------------------------
	
    /**
     * The portlet application descriptor (<code>WEB-INF/portlet.xml</code>).
     * @parameter expression="${basedir}/src/main/webapp/WEB-INF/portlet.xml"
     * @required
     */
    private File portletXml = null;

    /**
     * The original webapp descriptor (<code>WEB-INF/web.xml</code>).
     * @parameter expression="${basedir}/src/main/webapp/WEB-INF/web.xml"
     * @required
     */
    private File webXml = null;
    
    /**
     * The file to which the updated webapp descriptor is written. 
     * @parameter expression="${project.build.directory}/pluto-resources/web.xml"
     */
    private File webXmlDestination = null;
    
    
    // AbstractPlutoMojo Impl --------------------------------------------------
    
    protected void doExecute() throws Exception {
        // Log parameter values.
    	Log log = getLog();
        if (log.isInfoEnabled()) {
            log.info("Reading web.xml from :" + webXml.getAbsolutePath());
            log.info("Reading portlet.xml from: " + portletXml.getAbsolutePath());
            log.info("Writing web.xml to: " + webXmlDestination.getAbsolutePath());
        }
        // Assemble portlet app by updating web.xml.
        AssemblerConfig config = createAssemblerConfig();
        Assembler assembler = AssemblerFactory.getFactory()
        		.createAssembler(config);
        assembler.assemble(config);
    }

    protected void doValidate() throws MojoExecutionException {
        if (webXml == null || !webXml.exists()) {
            throw new MojoExecutionException("Web application descriptor must be a valid web.xml");
        }
        if (portletXml == null || !portletXml.exists()) {
            throw new MojoExecutionException("Portlet descriptor must be a valid portlet.xml");
        }
    }
    
    // Private Methods ---------------------------------------------------------
    
    private AssemblerConfig createAssemblerConfig() {
        AssemblerConfig config = new AssemblerConfig();
        config.setPortletDescriptor(portletXml);
        config.setWebappDescriptor(webXml);
        config.setDestination(webXmlDestination);
        return config;
    }
    
}