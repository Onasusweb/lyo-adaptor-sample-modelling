<%--To avoid the overriding of any manual code changes upon subsequent code generations, disable "Generate JSP Files" option in the Adaptor model.--%>
<!DOCTYPE html>
<%--
 Copyright (c) 2011, 2012, 2017 IBM Corporation and others.

 All rights reserved. This program and the accompanying materials
 are made available under the terms of the Eclipse Public License v1.0
 and Eclipse Distribution License v. 1.0 which accompanies this distribution.

 The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 and the Eclipse Distribution License is available at
 http://www.eclipse.org/org/documents/edl-v10.php.

 Contributors:

  Sam Padgett     - initial API and implementation
  Michael Fiedler - adapted for OSLC4J
  Jad El-khoury   - initial implementation of code generator (422448)
  Frédéric Loiret - Switch the template to Bootstrap (519699)
  Frédéric Loiret - Support for UI Preview (494303)
  Andrii Berezovskyi - Support for UI Preview (494303)

 This file is generated by org.eclipse.lyo.oslc4j.codegenerator
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@page import="org.eclipse.lyo.oslc4j.core.model.ServiceProvider"%>
<%@page import="org.eclipse.lyo.oslc4j.core.model.AbstractResource"%>
<%@page import="java.util.List" %>
<%@page import="com.sample.testing.resources.TestScript"%>
<%@ page contentType="text/html" language="java" pageEncoding="UTF-8" %>
<%
  List<TestScript> resources = (List<TestScript>) request.getAttribute("resources");
  String queryUri = (String)request.getAttribute("queryUri");
  String nextPageUri = (String)request.getAttribute("nextPageUri");
%>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Query capability QueryCapability</title>

  <link href="<c:url value="/static/css/bootstrap-4.0.0-beta.min.css"/>" rel="stylesheet">
  <link href="<c:url value="/static/css/adaptor.css"/>" rel="stylesheet">

  <script src="<c:url value="/static/js/jquery-3.2.1.min.js"/>"></script>
  <script src="<c:url value="/static/js/popper-1.11.0.min.js"/>"></script>
  <script src="<c:url value="/static/js/bootstrap-4.0.0-beta.min.js"/>"></script>
  <script src="<c:url value="/static/js/ui-preview-helper.js"/>"></script>
  <script type="text/javascript">
    $(function () {setupUiPreviewOnPopover($("a.oslc-resource-link"));});
  </script>

</head>
<body>
<!-- Fixed navbar -->
  <nav class="navbar navbar-expand-lg sticky-top navbar-light bg-light">
    <div class="container">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item"><a class="nav-link" href="<c:url value="/"/>"><%= application.getServletContextName() %></a></li>
        <li class="nav-item"><a class="nav-link" href="<c:url value="/services/catalog/singleton"/>">Service Provider Catalog</a></li>
        <li class="nav-item"><a class="nav-link" href="<c:url value="/swagger-ui/index.jsp"/>">Swagger UI</a></li>
      </ul>
    </div>
  </nav>
  <!-- Begin page content -->
  <div class="container">
    <div class="page-header">
      <h1>Query Capability &quot;QueryCapability&quot; results</h1>
      <div class="alert alert-secondary" role="alert">
          Number of elements:&nbsp;
          <%= resources.size()%>
          <% if (nextPageUri != null) { %><p><a href="<%= nextPageUri %>">Next Page</a></p><% } %>
      </div>
    </div>
		<div class="alert alert-primary" role="alert">
			<h4 class="alert-heading">Sample data!</h4>
			<hr>
			<p>
				A sample set of TestScript resource is presented here. Modify the
				method
				<code>queryTestScripts()</code>
				in the class
				<code>TestingToolManager</code>
				, to return the expected set of TestScript resources.
			</p>
		</div>
        <% for (TestScript aResource : resources) { %>
        <p><a href="<%= aResource.getAbout() %>" class="oslc-resource-link"><%=aResource.getAbout().toString()%></a><br /></p>
        <% } %>
      </div>
  <footer class="footer">
      <div class="container">
          <p class="text-muted">OSLC Adaptor was generated using <a href="http://eclipse.org/lyo">Eclipse Lyo</a>.</p>
      </div>
  </footer>
</body>
</html>
