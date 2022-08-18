package org.charles.dubbo.api.service;

import org.charles.dubbo.api.pojo.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
public interface UserService {

    @GET
    @Path("/getUserById")
    User getUserById(long id);
}
