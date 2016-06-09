/*
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for additional information regarding
 * copyright ownership. The ASF licenses this file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */


package javax.portlet.tck.filters;

import java.io.*;
import java.util.logging.*;
import javax.portlet.*;
import javax.portlet.filter.*;
import javax.portlet.tck.beans.*;
import javax.portlet.tck.constants.*;
import static javax.portlet.tck.beans.JSR286ApiTestCaseDetails.*;
import static javax.portlet.PortletSession.*;

/**
 * Filter for JSR 362 request dispatcher testing. Used by portlet:
 * FilterTests_EventFilter_ApiEventFilter
 *
 * @author ahmed
 *
 */
public class FilterTests_EventFilter_ApiEventFilter_filter implements EventFilter {
  private static final String LOG_CLASS =
      FilterTests_EventFilter_ApiEventFilter_filter.class.getName();
  private final Logger LOGGER = Logger.getLogger(LOG_CLASS);
  public static boolean tr4_success = false;

  private FilterConfig filterConfig;

  @Override
  public void init(FilterConfig filterConfig) throws PortletException {
    this.filterConfig = filterConfig;
  }

  @Override
  public void destroy() {}

  @Override
  public void doFilter(EventRequest portletReq, EventResponse portletResp, FilterChain chain)
      throws IOException, PortletException {
    LOGGER.entering(LOG_CLASS, "doFilter");

    StringWriter writer = new StringWriter();

    JSR286ApiTestCaseDetails tcd = new JSR286ApiTestCaseDetails();

    /* TestCase: V2FilterTests_EventFilter_ApiEventFilter_canBeConfigured1 */
    /* Details: "An EventFilter can be configured in the portlet */
    /* descriptor" */
    TestResult tr0 =
        tcd.getTestResultFailed(V2FILTERTESTS_EVENTFILTER_APIEVENTFILTER_CANBECONFIGURED1);
    String action = filterConfig.getFilterName();
    if (action.equals("FilterTests_EventFilter_ApiEventFilter_filter")) {
      tr0.setTcSuccess(true);
    }
    tr0.writeTo(writer);

    /* TestCase: V2FilterTests_EventFilter_ApiEventFilter_doFilterProcessEvent2 */
    /* Details: "After the doFilter(EventRequest, EventResponse, */
    /* FilterChain): method has sucessfully completed and invokes the */
    /* next filter, the next filter in the chain is called if multiple */
    /* filters are defined" */
    tr4_success = true;

    portletReq.getPortletSession().setAttribute(
        Constants.RESULT_ATTR_PREFIX + "FilterTests_EventFilter_ApiEventFilter", writer.toString(),
        APPLICATION_SCOPE);
    chain.doFilter(portletReq, portletResp);

    /* TestCase: V2FilterTests_EventFilter_ApiEventFilter_doFilterExamine */
    /* Details: "Method doFilter(EventRequest, EventResponse, */
    /* FilterChain): After the next filter has been successfully invoked, */
    /* the EventResponse may be examined" */
    portletResp.setRenderParameter("tr8", "true");

  }
}
