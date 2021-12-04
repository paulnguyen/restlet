package helloworld ;

/**
 * Copyright 2005-2012 Restlet S.A.S.
 * 
 * The contents of this file are subject to the terms of one of the following
 * open source licenses: Apache 2.0 or LGPL 3.0 or LGPL 2.1 or CDDL 1.0 or EPL
 * 1.0 (the "Licenses"). You can select the license that you prefer but you may
 * not use this file except in compliance with one of these Licenses.
 * 
 * You can obtain a copy of the Apache 2.0 license at
 * http://www.opensource.org/licenses/apache-2.0
 * 
 * You can obtain a copy of the LGPL 3.0 license at
 * http://www.opensource.org/licenses/lgpl-3.0
 * 
 * You can obtain a copy of the LGPL 2.1 license at
 * http://www.opensource.org/licenses/lgpl-2.1
 * 
 * You can obtain a copy of the CDDL 1.0 license at
 * http://www.opensource.org/licenses/cddl1
 * 
 * You can obtain a copy of the EPL 1.0 license at
 * http://www.opensource.org/licenses/eclipse-1.0
 * 
 * See the Licenses for the specific language governing permissions and
 * limitations under the Licenses.
 * 
 * Alternatively, you can obtain a royalty free commercial license with less
 * limitations, transferable or non-transferable, directly at
 * http://www.restlet.com/products/restlet-framework
 * 
 * Restlet is a registered trademark of Restlet S.A.S.
 */


import org.restlet.Application;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.Server;
import org.restlet.data.MediaType;
import org.restlet.data.Protocol;

/**
 * Setting basic application properties.
 */
public class EchoServer extends Application {

    /**
     * Launches the application with an HTTP server.
     * 
     * @param args
     *            The arguments.
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Server server = new Server(Protocol.HTTP, 8111);
        server.setNext(new EchoServer());
        server.start();
    }

    /**
     * Constructor.
     */
    public EchoServer() {
        setName("RESTful Echo Server");
        setDescription("Example from Restlet in Action");
        setOwner("Restlet S.A.S.");
        setAuthor("The Restlet Team");
    }

    /**
     * Creates a root Restlet to trace requests.
     */
    @Override
    public Restlet createInboundRoot() {
        return new Restlet() {
            @Override
            public void handle(Request request, Response response) {
                String entity = "Method       : " + request.getMethod()
                        + "\nResource URI : " + request.getResourceRef()
                        + "\nIP address   : "
                        + request.getClientInfo().getAddress()
                        + "\nAgent name   : "
                        + request.getClientInfo().getAgentName()
                        + "\nAgent version: "
                        + request.getClientInfo().getAgentVersion();
                response.setEntity(entity, MediaType.TEXT_PLAIN);
            }
        };
    }
}
