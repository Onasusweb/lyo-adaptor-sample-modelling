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
package com.sample.testing.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.text.SimpleDateFormat;
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
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.UriBuilder;

import org.apache.wink.json4j.JSONObject;
import org.eclipse.lyo.oslc4j.provider.json4j.JsonHelper;
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
import com.sample.testing.resources.Oslc_qmConstants;
import com.sample.testing.resources.Oslc_qmConstants;
import com.sample.testing.servlet.ServiceProviderCatalogSingleton;
import com.sample.testing.resources.Requirement;
import com.sample.testing.resources.TestScript;

// Start of user code imports
// End of user code

// Start of user code pre_class_code
// End of user code
@OslcService(Oslc_qmConstants.QUALITY_MANAGEMENT_DOMAIN)
@Path("serviceProviders/{serviceProviderId}/testScripts")
public class ServiceProviderService1
{
    @Context private HttpServletRequest httpServletRequest;
    @Context private HttpServletResponse httpServletResponse;
    @Context private UriInfo uriInfo;

    // Start of user code class_attributes
    // End of user code

    // Start of user code class_methods
    // End of user code

    public ServiceProviderService1()
    {
        super();
    }

    @OslcQueryCapability
    (
        title = "QueryCapability",
        label = "QueryCapability",
        resourceShape = OslcConstants.PATH_RESOURCE_SHAPES + "/" + Oslc_qmConstants.PATH_TESTSCRIPT,
        resourceTypes = {Oslc_qmConstants.TYPE_TESTSCRIPT},
        usages = {}
    )
    @GET
    @Path("query")
    @Produces({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON, OslcMediaType.TEXT_TURTLE})
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
    public Response queryTestScriptsAsHtml(
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
         resourceShapes = {OslcConstants.PATH_RESOURCE_SHAPES + "/" + Oslc_qmConstants.PATH_TESTSCRIPT},
         resourceTypes = {Oslc_qmConstants.TYPE_TESTSCRIPT},
         usages = {}
    )
    @POST
    @Path("create")
    @Consumes({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON, OslcMediaType.TEXT_TURTLE})
    @Produces({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON, OslcMediaType.TEXT_TURTLE})
    public Response createTestScript(
            @PathParam("serviceProviderId") final String serviceProviderId ,
            final TestScript aResource
        ) throws IOException, ServletException
    {
        try {
            TestScript newResource = TestingToolManager.createTestScript(httpServletRequest, aResource, serviceProviderId);
            httpServletResponse.setHeader("ETag", TestingToolManager.getETagFromTestScript(newResource));
            return Response.created(newResource.getAbout()).entity(newResource).header(TestingToolConstants.HDR_OSLC_VERSION, TestingToolConstants.OSLC_VERSION_V2).build();
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebApplicationException(e);
        }
    }

    @GET
    @Path("{testScriptId}")
    @Produces({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON, OslcMediaType.TEXT_TURTLE})
    public TestScript getTestScript(
                @PathParam("serviceProviderId") final String serviceProviderId, @PathParam("testScriptId") final String testScriptId
        ) throws IOException, ServletException, URISyntaxException
    {
        // Start of user code getResource_init
        // End of user code

        final TestScript aTestScript = TestingToolManager.getTestScript(httpServletRequest, serviceProviderId, testScriptId);

        if (aTestScript != null) {
            // Start of user code getTestScript
            // End of user code
            httpServletResponse.addHeader(TestingToolConstants.HDR_OSLC_VERSION, TestingToolConstants.OSLC_VERSION_V2);
            return aTestScript;
        }

        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @GET
    @Path("{testScriptId}")
    @Produces({ MediaType.TEXT_HTML })
    public Response getTestScriptAsHtml(
        @PathParam("serviceProviderId") final String serviceProviderId, @PathParam("testScriptId") final String testScriptId
        ) throws ServletException, IOException, URISyntaxException
    {
        // Start of user code getTestScriptAsHtml_init
        // End of user code

        final TestScript aTestScript = TestingToolManager.getTestScript(httpServletRequest, serviceProviderId, testScriptId);

        if (aTestScript != null) {
            httpServletRequest.setAttribute("aTestScript", aTestScript);
            // Start of user code getTestScriptAsHtml_setAttributes
            // End of user code

            RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/com/sample/testing/testscript.jsp");
            rd.forward(httpServletRequest,httpServletResponse);
        }

        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @GET
    @Path("{testScriptId}")
    @Produces({OslcMediaType.APPLICATION_X_OSLC_COMPACT_XML})
    public Compact getTestScriptCompact(
        @PathParam("serviceProviderId") final String serviceProviderId, @PathParam("testScriptId") final String testScriptId
        ) throws ServletException, IOException, URISyntaxException
    {
        String iconUri = OSLC4JUtils.getPublicURI() + "/images/ui_preview_icon.gif";
        String smallPreviewHintHeight = "10em";
        String smallPreviewHintWidth = "45em";
        String largePreviewHintHeight = "20em";
        String largePreviewHintWidth = "45em";

        // Start of user code getTestScriptCompact_init
        //TODO: adjust the preview height & width values from the default values provided above.
        // End of user code

        final TestScript aTestScript = TestingToolManager.getTestScript(httpServletRequest, serviceProviderId, testScriptId);

        if (aTestScript != null) {
            final Compact compact = new Compact();

            compact.setAbout(aTestScript.getAbout());
            compact.setTitle(aTestScript.toString());

            compact.setIcon(new URI(iconUri));

            //Create and set attributes for OSLC preview resource
            final Preview smallPreview = new Preview();
            smallPreview.setHintHeight(smallPreviewHintHeight);
            smallPreview.setHintWidth(smallPreviewHintWidth);
            smallPreview.setDocument(UriBuilder.fromUri(aTestScript.getAbout()).path("smallPreview").build());
            compact.setSmallPreview(smallPreview);

            //Use the HTML representation of a change request as the large preview as well
            final Preview largePreview = new Preview();
            largePreview.setHintHeight(largePreviewHintHeight);
            largePreview.setHintWidth(largePreviewHintWidth);
            largePreview.setDocument(aTestScript.getAbout());
            compact.setLargePreview(largePreview);
            httpServletResponse.addHeader(TestingToolConstants.HDR_OSLC_VERSION, TestingToolConstants.OSLC_VERSION_V2);
            return compact;
        }
        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @GET
    @Path("{testScriptId}/smallPreview")
    @Produces({ MediaType.TEXT_HTML })
    public void getTestScriptAsHtmlSmallPreview(
        @PathParam("serviceProviderId") final String serviceProviderId, @PathParam("testScriptId") final String testScriptId
        ) throws ServletException, IOException, URISyntaxException
    {
        // Start of user code getTestScriptAsHtmlSmallPreview_init
        // End of user code

        final TestScript aTestScript = TestingToolManager.getTestScript(httpServletRequest, serviceProviderId, testScriptId);

        if (aTestScript != null) {
            httpServletRequest.setAttribute("aTestScript", aTestScript);
            // Start of user code getTestScriptAsHtmlSmallPreview_setAttributes
            // End of user code

            RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/com/sample/testing/testscriptsmallpreview.jsp");
            httpServletResponse.addHeader(TestingToolConstants.HDR_OSLC_VERSION, TestingToolConstants.OSLC_VERSION_V2);
            rd.forward(httpServletRequest, httpServletResponse);
        }

        throw new WebApplicationException(Status.NOT_FOUND);
    }
}
