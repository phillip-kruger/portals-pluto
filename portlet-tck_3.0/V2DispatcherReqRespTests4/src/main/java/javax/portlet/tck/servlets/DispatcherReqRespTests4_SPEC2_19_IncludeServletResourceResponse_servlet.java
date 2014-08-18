/*  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */


package javax.portlet.tck.servlets;

import java.io.*;
import java.util.*;
import java.util.logging.*;
import static java.util.logging.Logger.*;
import javax.portlet.*;
import javax.portlet.filter.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.portlet.tck.beans.*;
import javax.portlet.tck.constants.*;
import static javax.portlet.tck.constants.Constants.*;
import static javax.portlet.tck.beans.JSR286DispatcherReqRespTestCaseDetails.*;

/**
 * Servlet for JSR 362 request dispatcher testing.
 * Used by portlet: DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceResponse
 *
 * @author nick
 *
 */
public class DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceResponse_servlet extends HttpServlet {
   private static final String LOG_CLASS = 
         DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceResponse_servlet.class.getName();
   private final Logger LOGGER = Logger.getLogger(LOG_CLASS);

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp)
         throws ServletException, IOException {
      processTCKReq(req, resp);
   }

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp)
         throws ServletException, IOException {
      processTCKReq(req, resp);
   }

   // The tck uses only get & post requests
   protected void processTCKReq(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      LOGGER.entering(LOG_CLASS, "servlet entry");

      PortletRequest portletReq = (PortletRequest) request.getAttribute("javax.portlet.request");
      PortletResponse portletResp = (PortletResponse) request.getAttribute("javax.portlet.response");
      PortletConfig portletConfig = (PortletConfig) request.getAttribute("javax.portlet.config");
      long svtTid = Thread.currentThread().getId();
      long reqTid = (Long) portletReq.getAttribute(THREADID_ATTR);

      PrintWriter writer = ((MimeResponse)portletResp).getWriter();

      JSR286DispatcherReqRespTestCaseDetails tcd = new JSR286DispatcherReqRespTestCaseDetails();

      // Create result objects for the tests

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceResponse_addCookie */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletResponse.addCookie does not perform any        */
      /* operation"                                                           */
      TestResult tr0 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_ADDCOOKIE);
      /* TODO: implement test */
      tr0.appendTcDetail("Not implemented.");
      tr0.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceResponse_addDateHeader */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletResponse.addDateHeader does not perform any    */
      /* operation"                                                           */
      TestResult tr1 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_ADDDATEHEADER);
      /* TODO: implement test */
      tr1.appendTcDetail("Not implemented.");
      tr1.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceResponse_addHeader */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletResponse.addHeader does not perform any        */
      /* operation"                                                           */
      TestResult tr2 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_ADDHEADER);
      /* TODO: implement test */
      tr2.appendTcDetail("Not implemented.");
      tr2.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceResponse_addIntHeader */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletResponse.addIntHeader does not perform any     */
      /* operation"                                                           */
      TestResult tr3 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_ADDINTHEADER);
      /* TODO: implement test */
      tr3.appendTcDetail("Not implemented.");
      tr3.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceResponse_containsHeader */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletResponse.containsHeader must return false"     */
      TestResult tr4 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_CONTAINSHEADER);
      try {
         boolean ok = response.containsHeader("Accept");
         tr4.setTcSuccess(ok == false);
      } catch(Exception e) {tr4.appendTcDetail(e.toString());}
      tr4.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceResponse_encodeRedirectURL1 */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletResponse.encodeRedirectURL must return null"   */
      TestResult tr5 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_ENCODEREDIRECTURL1);
      try {
         String isval = response.encodeRedirectURL("http://www.cnn.com/");
         CompareUtils.stringsEqual(isval, null, tr5);
      } catch(Exception e) {tr5.appendTcDetail(e.toString());}
      tr5.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceResponse_encodeRedirectUrl */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletResponse.encodeRedirectUrl must return null"   */
      TestResult tr6 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_ENCODEREDIRECTURL);
      try {
         String isval = response.encodeRedirectUrl("http://www.cnn.com/");
         CompareUtils.stringsEqual(isval, null, tr6);
      } catch(Exception e) {tr6.appendTcDetail(e.toString());}
      tr6.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceResponse_encodeURL1 */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletResponse.encodeURL must provide the same       */
      /* functionality as ResourceResponse.encodeURL"                         */
      TestResult tr7 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_ENCODEURL1);
      /* TODO: implement test */
      tr7.appendTcDetail("Not implemented.");
      tr7.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceResponse_encodeUrl */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletResponse.encodeUrl must provide the same       */
      /* functionality as ResourceResponse.encodeURL"                         */
      TestResult tr8 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_ENCODEURL);
      /* TODO: implement test */
      tr8.appendTcDetail("Not implemented.");
      tr8.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceResponse_flushBuffer */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletResponse.flushBuffer must provide the same     */
      /* functionality as ResourceResponse.flushBuffer"                       */
      TestResult tr9 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_FLUSHBUFFER);
      /* TODO: implement test */
      tr9.appendTcDetail("Not implemented.");
      tr9.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceResponse_getBufferSize */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletResponse.getBufferSize must provide the same   */
      /* functionality as ResourceResponse.getBufferSize"                     */
      TestResult tr10 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_GETBUFFERSIZE);
      /* TODO: implement test */
      tr10.appendTcDetail("Not implemented.");
      tr10.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceResponse_getCharacterEncoding */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletResponse.getCharacterEncoding must provide     */
      /* the same functionality as ResourceResponse.getCharacterEncoding"     */
      TestResult tr11 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_GETCHARACTERENCODING);
      /* TODO: implement test */
      tr11.appendTcDetail("Not implemented.");
      tr11.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceResponse_getContentType */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletResponse.getContentType must provide the       */
      /* same functionality as ResourceResponse.getContentType"               */
      TestResult tr12 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_GETCONTENTTYPE);
      /* TODO: implement test */
      tr12.appendTcDetail("Not implemented.");
      tr12.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceResponse_getLocale */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletResponse.getLocale must provide the same       */
      /* functionality as ResourceResponse.getLocale"                         */
      TestResult tr13 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_GETLOCALE);
      try {
         Locale hl = response.getLocale();
         Locale pl = ((MimeResponse)portletResp).getLocale();
         CompareUtils.stringsEqual(hl.getDisplayName(), pl.getDisplayName(), tr13);
      } catch(Exception e) {tr13.appendTcDetail(e.toString());}
      tr13.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceResponse_getOutputStream */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletResponse.getOutputStream must provide the      */
      /* same functionality as ResourceResponse.getPortletOutputStream"       */
      TestResult tr14 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_GETOUTPUTSTREAM);
      /* TODO: implement test */
      tr14.appendTcDetail("Not implemented.");
      tr14.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceResponse_getWriter */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletResponse.getWriter must provide the same       */
      /* functionality as ResourceResponse.getWriter"                         */
      TestResult tr15 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_GETWRITER);
      /* TODO: implement test */
      tr15.appendTcDetail("Not implemented.");
      tr15.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceResponse_isCommitted */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletResponse.isCommitted must provide the same     */
      /* functionality as ResourceResponse.isCommitted"                       */
      TestResult tr16 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_ISCOMMITTED);
      /* TODO: implement test */
      tr16.appendTcDetail("Not implemented.");
      tr16.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceResponse_reset */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletResponse.reset must provide the same           */
      /* functionality as ResourceResponse.reset"                             */
      TestResult tr17 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_RESET);
      /* TODO: implement test */
      tr17.appendTcDetail("Not implemented.");
      tr17.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceResponse_resetBuffer */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletResponse.resetBuffer must provide the same     */
      /* functionality as ResourceResponse.resetBuffer"                       */
      TestResult tr18 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_RESETBUFFER);
      /* TODO: implement test */
      tr18.appendTcDetail("Not implemented.");
      tr18.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceResponse_sendError */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletResponse.sendError does not perform any        */
      /* operation"                                                           */
      TestResult tr19 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_SENDERROR);
      /* TODO: implement test */
      tr19.appendTcDetail("Not implemented.");
      tr19.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceResponse_sendRedirect */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletResponse.sendRedirect does not perform any     */
      /* operation"                                                           */
      TestResult tr20 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_SENDREDIRECT);
      /* TODO: implement test */
      tr20.appendTcDetail("Not implemented.");
      tr20.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceResponse_setBufferSize */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletResponse.setBufferSize must provide the same   */
      /* functionality as ResourceResponse.setBufferSize"                     */
      TestResult tr21 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_SETBUFFERSIZE);
      /* TODO: implement test */
      tr21.appendTcDetail("Not implemented.");
      tr21.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceResponse_setCharacterEncoding */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletResponse.setCharacterEncoding does not         */
      /* perform any operation"                                               */
      TestResult tr22 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_SETCHARACTERENCODING);
      /* TODO: implement test */
      tr22.appendTcDetail("Not implemented.");
      tr22.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceResponse_setContentLength */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletResponse.setContentLength does not perform     */
      /* any operation"                                                       */
      TestResult tr23 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_SETCONTENTLENGTH);
      /* TODO: implement test */
      tr23.appendTcDetail("Not implemented.");
      tr23.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceResponse_setContentType */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletResponse.setContentType does not perform any   */
      /* operation"                                                           */
      TestResult tr24 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_SETCONTENTTYPE);
      /* TODO: implement test */
      tr24.appendTcDetail("Not implemented.");
      tr24.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceResponse_setDateHeader */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletResponse.setDateHeader does not perform any    */
      /* operation"                                                           */
      TestResult tr25 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_SETDATEHEADER);
      /* TODO: implement test */
      tr25.appendTcDetail("Not implemented.");
      tr25.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceResponse_setHeader */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletResponse.setHeader does not perform any        */
      /* operation"                                                           */
      TestResult tr26 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_SETHEADER);
      /* TODO: implement test */
      tr26.appendTcDetail("Not implemented.");
      tr26.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceResponse_setIntHeader */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletResponse.setIntHeader does not perform any     */
      /* operation"                                                           */
      TestResult tr27 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_SETINTHEADER);
      /* TODO: implement test */
      tr27.appendTcDetail("Not implemented.");
      tr27.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceResponse_setLocale */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletResponse.setLocale does not perform any        */
      /* operation"                                                           */
      TestResult tr28 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_SETLOCALE);
      /* TODO: implement test */
      tr28.appendTcDetail("Not implemented.");
      tr28.writeTo(writer);

      /* TestCase: V2DispatcherReqRespTests4_SPEC2_19_IncludeServletResourceResponse_setStatus */
      /* Details: "In a target servlet of a include in the Resource phase,    */
      /* the method HttpServletResponse.setStatus does not perform any        */
      /* operation"                                                           */
      TestResult tr29 = tcd.getTestResultFailed(V2DISPATCHERREQRESPTESTS4_SPEC2_19_INCLUDESERVLETRESOURCERESPONSE_SETSTATUS);
      /* TODO: implement test */
      tr29.appendTcDetail("Not implemented.");
      tr29.writeTo(writer);


   }
}