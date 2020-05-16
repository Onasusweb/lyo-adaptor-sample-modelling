// Start of user code Copyright
/*******************************************************************************
 * Copyright (c) 2012 IBM Corporation and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompanies this distribution.
 *
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *
 *     Michael Fiedler     - initial API and implementation for Bugzilla adapter
 *     Jad El-khoury       - initial implementation of code generator (https://bugs.eclipse.org/bugs/show_bug.cgi?id=422448)
 *     Jim Amsden          - Support for UI Preview (494303)
 *
 * This file is generated by org.eclipse.lyo.oslc4j.codegenerator
 *******************************************************************************/
// End of user code

package com.sample.testing.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.UriBuilder;

import org.apache.wink.json4j.JSONException;
import org.apache.wink.json4j.JSONObject;
import org.eclipse.lyo.oslc4j.provider.json4j.JsonHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.eclipse.lyo.oslc4j.core.OSLC4JUtils;
import org.eclipse.lyo.oslc4j.core.annotation.OslcCreationFactory;
import org.eclipse.lyo.oslc4j.core.annotation.OslcDialog;
import org.eclipse.lyo.oslc4j.core.annotation.OslcDialogs;
import org.eclipse.lyo.oslc4j.core.annotation.OslcQueryCapability;
import org.eclipse.lyo.oslc4j.core.annotation.OslcService;
import org.eclipse.lyo.oslc4j.core.model.Compact;
import org.eclipse.lyo.oslc4j.core.model.OslcConstants;
import org.eclipse.lyo.oslc4j.core.model.OslcMediaType;
import org.eclipse.lyo.oslc4j.core.model.Preview;
import org.eclipse.lyo.oslc4j.core.model.ServiceProvider;
import org.eclipse.lyo.oslc4j.core.model.Link;
import org.eclipse.lyo.oslc4j.core.model.AbstractResource;

import com.sample.testing.TestingToolManager;
import com.sample.testing.TestingToolConstants;
import com.sample.testing.resources.Oslc_qmDomainConstants;
import com.sample.testing.resources.Oslc_qmDomainConstants;
import com.sample.testing.servlet.ServiceProviderCatalogSingleton;
import com.sample.testing.resources.Requirement;
import com.sample.testing.resources.TestScript;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

// Start of user code imports
// End of user code

// Start of user code pre_class_code
// End of user code
@OslcService(Oslc_qmDomainConstants.QUALITY_MANAGEMENT_DOMAIN)
@Path("serviceProviders/{serviceProviderId}/testScripts")
@Api(value = "OSLC Service for {" + Oslc_qmDomainConstants.TESTSCRIPT_LOCALNAME + "}")
public class ServiceProviderService1
{
    @Context private HttpServletRequest httpServletRequest;
    @Context private HttpServletResponse httpServletResponse;
    @Context private UriInfo uriInfo;

    private static final Logger log = LoggerFactory.getLogger(ServiceProviderService1.class);

    // Start of user code class_attributes
    // End of user code

    // Start of user code class_methods
    // End of user code

    public ServiceProviderService1()
    {
        super();
    }

    private void addCORSHeaders (final HttpServletResponse httpServletResponse) {
        //UI preview can be blocked by CORS policy.
        //add select CORS headers to every response that is embedded in an iframe.
        httpServletResponse.addHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.addHeader("Access-Control-Allow-Methods", "GET, OPTIONS, HEAD");
        httpServletResponse.addHeader("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
        httpServletResponse.addHeader("Access-Control-Allow-Credentials", "true");
    }

    @OslcQueryCapability
    (
        title = "QueryCapability",
        label = "QueryCapability",
        resourceShape = OslcConstants.PATH_RESOURCE_SHAPES + "/" + Oslc_qmDomainConstants.TESTSCRIPT_PATH,
        resourceTypes = {Oslc_qmDomainConstants.TESTSCRIPT_TYPE},
        usages = {}
    )
    @GET
    @Path("query")
    @Produces({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_JSON_LD, OslcMediaType.TEXT_TURTLE, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON})
    @ApiOperation(
        value = "Query capability for resources of type {" + Oslc_qmDomainConstants.TESTSCRIPT_LOCALNAME + "}",
        notes = "Query capability for resources of type {" + "<a href=\"" + Oslc_qmDomainConstants.TESTSCRIPT_TYPE + "\">" + Oslc_qmDomainConstants.TESTSCRIPT_LOCALNAME + "</a>" + "}" +
            ", with respective resource shapes {" + "<a href=\"" + "../services/" + OslcConstants.PATH_RESOURCE_SHAPES + "/" + Oslc_qmDomainConstants.TESTSCRIPT_PATH + "\">" + Oslc_qmDomainConstants.TESTSCRIPT_LOCALNAME + "</a>" + "}",
        produces = OslcMediaType.APPLICATION_RDF_XML + ", " + OslcMediaType.APPLICATION_XML + ", " + OslcMediaType.APPLICATION_JSON + ", " + OslcMediaType.TEXT_TURTLE + ", " + MediaType.TEXT_HTML
    )
    public TestScript[] queryTestScripts(
                                                    @PathParam("serviceProviderId") final String serviceProviderId ,
                                                     @QueryParam("oslc.where") final String where,
                                                     @QueryParam("page") final String pageString,
                                                    @QueryParam("limit") final String limitString) throws IOException, ServletException
    {
        int page=0;
        int limit=20;
        if (null != pageString) {
            page = Integer.parseInt(pageString);
        }
        if (null != limitString) {
            limit = Integer.parseInt(limitString);
        }

        // Start of user code queryTestScripts
        // Here additional logic can be implemented that complements main action taken in TestingToolManager
        // End of user code

        final List<TestScript> resources = TestingToolManager.queryTestScripts(httpServletRequest, serviceProviderId, where, page, limit);
        return resources.toArray(new TestScript [resources.size()]);
    }

    @GET
    @Path("query")
    @Produces({ MediaType.TEXT_HTML })
    @ApiOperation(
        value = "Query capability for resources of type {" + Oslc_qmDomainConstants.TESTSCRIPT_LOCALNAME + "}",
        notes = "Query capability for resources of type {" + "<a href=\"" + Oslc_qmDomainConstants.TESTSCRIPT_TYPE + "\">" + Oslc_qmDomainConstants.TESTSCRIPT_LOCALNAME + "</a>" + "}" +
            ", with respective resource shapes {" + "<a href=\"" + "../services/" + OslcConstants.PATH_RESOURCE_SHAPES + "/" + Oslc_qmDomainConstants.TESTSCRIPT_PATH + "\">" + Oslc_qmDomainConstants.TESTSCRIPT_LOCALNAME + "</a>" + "}",
        produces = OslcMediaType.APPLICATION_RDF_XML + ", " + OslcMediaType.APPLICATION_XML + ", " + OslcMediaType.APPLICATION_JSON + ", " + OslcMediaType.TEXT_TURTLE + ", " + MediaType.TEXT_HTML
    )
    public void queryTestScriptsAsHtml(
                                    @PathParam("serviceProviderId") final String serviceProviderId ,
                                       @QueryParam("oslc.where") final String where,
                                       @QueryParam("page") final String pageString,
                                    @QueryParam("limit") final String limitString) throws ServletException, IOException
    {
        int page=0;
        int limit=20;
        if (null != pageString) {
            page = Integer.parseInt(pageString);
        }
        if (null != limitString) {
            limit = Integer.parseInt(limitString);
        }

        // Start of user code queryTestScriptsAsHtml
        // End of user code

        final List<TestScript> resources = TestingToolManager.queryTestScripts(httpServletRequest, serviceProviderId, where, page, limit);

        if (resources!= null) {
            httpServletRequest.setAttribute("resources", resources);
            // Start of user code queryTestScriptsAsHtml_setAttributes
            // End of user code

            httpServletRequest.setAttribute("queryUri",
                    uriInfo.getAbsolutePath().toString() + "?oslc.paging=true");
            if (resources.size() > limit) {
                resources.remove(resources.size() - 1);
                httpServletRequest.setAttribute("nextPageUri",
                        uriInfo.getAbsolutePath().toString() + "?oslc.paging=true&amp;page=" + (page + 1));
            }
            RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/com/sample/testing/testscriptscollection.jsp");
            rd.forward(httpServletRequest,httpServletResponse);
            return;
        }

        throw new WebApplicationException(Status.NOT_FOUND);
    }

    /**
     * Create a single TestScript via RDF/XML, XML or JSON POST
     *
     * @throws IOException
     * @throws ServletException
     */
    @OslcCreationFactory
    (
         title = "CreationFactory",
         label = "",
         resourceShapes = {OslcConstants.PATH_RESOURCE_SHAPES + "/" + Oslc_qmDomainConstants.TESTSCRIPT_PATH},
         resourceTypes = {Oslc_qmDomainConstants.TESTSCRIPT_TYPE},
         usages = {}
    )
    @POST
    @Path("create")
    @Consumes({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_JSON_LD, OslcMediaType.TEXT_TURTLE, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON })
    @Produces({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_JSON_LD, OslcMediaType.TEXT_TURTLE, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON})
    @ApiOperation(
        value = "Creation factory for resources of type {" + Oslc_qmDomainConstants.TESTSCRIPT_LOCALNAME + "}",
        notes = "Creation factory for resources of type {" + "<a href=\"" + Oslc_qmDomainConstants.TESTSCRIPT_TYPE + "\">" + Oslc_qmDomainConstants.TESTSCRIPT_LOCALNAME + "</a>" + "}" +
            ", with respective resource shapes {" + "<a href=\"" + "../services/" + OslcConstants.PATH_RESOURCE_SHAPES + "/" + Oslc_qmDomainConstants.TESTSCRIPT_PATH + "\">" + Oslc_qmDomainConstants.TESTSCRIPT_LOCALNAME + "</a>" + "}",
        produces = OslcMediaType.APPLICATION_RDF_XML + ", " + OslcMediaType.APPLICATION_XML + ", " + OslcMediaType.APPLICATION_JSON + ", " + OslcMediaType.TEXT_TURTLE
    )
    public Response createTestScript(
            @PathParam("serviceProviderId") final String serviceProviderId ,
            final TestScript aResource
        ) throws IOException, ServletException
    {
        TestScript newResource = TestingToolManager.createTestScript(httpServletRequest, aResource, serviceProviderId);
        httpServletResponse.setHeader("ETag", TestingToolManager.getETagFromTestScript(newResource));
        return Response.created(newResource.getAbout()).entity(newResource).header(TestingToolConstants.HDR_OSLC_VERSION, TestingToolConstants.OSLC_VERSION_V2).build();
    }

}
