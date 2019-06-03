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
 *     Russell Boykin       - initial API and implementation
 *     Alberto Giammaria    - initial API and implementation
 *     Chris Peters         - initial API and implementation
 *     Gianluca Bernardini  - initial API and implementation
 *     Michael Fiedler      - Bugzilla adapter implementation
 *     Jad El-khoury        - initial implementation of code generator (https://bugs.eclipse.org/bugs/show_bug.cgi?id=422448)
 *     Matthieu Helleboid   - Allow Service Provider Factory class to be specific for each defined ServiceProvider
 *     Anass Radouani       - Allow Service Provider Factory class to be specific for each defined ServiceProvider
 *
 * This file is generated by org.eclipse.lyo.oslc4j.codegenerator
 *******************************************************************************/
// End of user code

package com.sample.rm.servlet;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.UriBuilder;

import org.eclipse.lyo.oslc4j.core.exception.OslcCoreApplicationException;
import org.eclipse.lyo.oslc4j.core.model.OslcConstants;
import org.eclipse.lyo.oslc4j.core.model.PrefixDefinition;
import org.eclipse.lyo.oslc4j.core.model.Publisher;
import org.eclipse.lyo.oslc4j.core.model.ServiceProvider;
import org.eclipse.lyo.oslc4j.core.model.ServiceProviderFactory;
import org.eclipse.lyo.oslc4j.core.OSLC4JUtils;

import com.sample.rm.ServiceProvider2Info;

import com.sample.rm.resources.FoafDomainConstants;
import com.sample.rm.resources.DctermsDomainConstants;
import com.sample.rm.resources.Oslc_rmDomainConstants;
import com.sample.rm.services.ServiceProvider2Service1;

// Start of user code imports
// End of user code

public class ServiceProvider2sFactory
{
    private static Class<?>[] RESOURCE_CLASSES =
    {
        ServiceProvider2Service1.class
    };

    private ServiceProvider2sFactory()
    {
        super();
    }

    public static URI constructURI(final String id1, final String id2)
    {
        String basePath = OSLC4JUtils.getServletURI();
        Map<String, Object> pathParameters = new HashMap<String, Object>();
        pathParameters.put("id1", id1);

        pathParameters.put("id2", id2);
        String instanceURI = "serviceProviders2/id1/{id1}/id2/{id2}";

        final UriBuilder builder = UriBuilder.fromUri(basePath);
        return builder.path(instanceURI).buildFromMap(pathParameters);
    }

    public static URI constructURI(final ServiceProvider2Info serviceProviderInfo)
    {
        return constructURI(serviceProviderInfo.id1, serviceProviderInfo.id2);
    }

    public static String constructIdentifier(final String id1, final String id2)
    {
        return id1 + "/" + id2;
    }

    public static String constructIdentifier(final ServiceProvider2Info serviceProviderInfo)
    {
        return constructIdentifier(serviceProviderInfo.id1, serviceProviderInfo.id2);
    }

    public static ServiceProvider createServiceProvider(final ServiceProvider2Info serviceProviderInfo) 
            throws OslcCoreApplicationException, URISyntaxException, IllegalArgumentException {
        // Start of user code init
        // End of user code
        URI serviceProviderURI = constructURI(serviceProviderInfo);
        String identifier = constructIdentifier(serviceProviderInfo);
        String basePath = OSLC4JUtils.getServletURI();
        String title = String.format("Service Provider '%s'", serviceProviderInfo.name);
        String description = String.format("%s (id: %s; kind: %s)",
            "Service Provider 2",
            identifier,
            "Service Provider 2");
        Publisher publisher = null;
        Map<String, Object> parameterMap = new HashMap<String, Object>();
        parameterMap.put("id1", serviceProviderInfo.id1);

        parameterMap.put("id2", serviceProviderInfo.id2);

        ServiceProvider serviceProvider = ServiceProviderFactory.createServiceProvider(basePath,
                                                    "",
                                                    title,
                                                    description,
                                                    publisher,
                                                    RESOURCE_CLASSES,
                                                    parameterMap);

        final PrefixDefinition[] prefixDefinitions =
        {
            new PrefixDefinition(OslcConstants.DCTERMS_NAMESPACE_PREFIX, new URI(OslcConstants.DCTERMS_NAMESPACE)),
            new PrefixDefinition(OslcConstants.OSLC_CORE_NAMESPACE_PREFIX, new URI(OslcConstants.OSLC_CORE_NAMESPACE)),
            new PrefixDefinition(OslcConstants.OSLC_DATA_NAMESPACE_PREFIX, new URI(OslcConstants.OSLC_DATA_NAMESPACE)),
            new PrefixDefinition(OslcConstants.RDF_NAMESPACE_PREFIX, new URI(OslcConstants.RDF_NAMESPACE)),
            new PrefixDefinition(OslcConstants.RDFS_NAMESPACE_PREFIX, new URI(OslcConstants.RDFS_NAMESPACE)),
            new PrefixDefinition(FoafDomainConstants.FOAF_NAMSPACE_PREFIX, new URI(FoafDomainConstants.FOAF_NAMSPACE))
,
            new PrefixDefinition(DctermsDomainConstants.DUBLIN_CORE_NAMSPACE_PREFIX, new URI(DctermsDomainConstants.DUBLIN_CORE_NAMSPACE))
,
            new PrefixDefinition(Oslc_rmDomainConstants.REQUIREMENTS_MANAGEMENT_NAMSPACE_PREFIX, new URI(Oslc_rmDomainConstants.REQUIREMENTS_MANAGEMENT_NAMSPACE))
        };
        serviceProvider.setPrefixDefinitions(prefixDefinitions);

        serviceProvider.setAbout(serviceProviderURI);
        serviceProvider.setIdentifier(identifier);
        serviceProvider.setCreated(new Date());
        serviceProvider.setDetails(new URI[] {serviceProviderURI});

        // Start of user code finalize
        // End of user code
        return serviceProvider;
    }
}
