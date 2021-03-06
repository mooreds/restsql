/* Copyright (c) restSQL Project Contributors. Licensed under MIT. */
package org.restsql.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.restsql.core.Config;
import org.restsql.security.SecurityFactory;

/**
 * Provides access to general restSQL, logging and security configuration.
 * 
 * @author Mark Sawers
 */
@Path("conf")
public class ConfResource {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response dumpConfig() {
		return Response.ok(Config.dumpConfig(true)).build();
	}

	@GET
	@Path("log")
	@Produces(MediaType.TEXT_PLAIN)
	public Response dumpLoggingConfig() {
		return Response.ok(Config.dumpLoggingConfig()).build();
	}

	@GET
	@Path("security")
	@Produces(MediaType.TEXT_PLAIN)
	public Response dumpSecurityConfig() {
		return Response.ok(SecurityFactory.getAuthorizer().dumpConfig()).build();
	}
}
