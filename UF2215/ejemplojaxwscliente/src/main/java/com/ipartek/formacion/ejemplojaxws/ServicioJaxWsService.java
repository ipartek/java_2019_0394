
package com.ipartek.formacion.ejemplojaxws;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "ServicioJaxWsService", targetNamespace = "http://ejemplojaxws.formacion.ipartek.com/", wsdlLocation = "http://localhost:8080/serviciojaxws?wsdl")
public class ServicioJaxWsService
    extends Service
{

    private final static URL SERVICIOJAXWSSERVICE_WSDL_LOCATION;
    private final static WebServiceException SERVICIOJAXWSSERVICE_EXCEPTION;
    private final static QName SERVICIOJAXWSSERVICE_QNAME = new QName("http://ejemplojaxws.formacion.ipartek.com/", "ServicioJaxWsService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/serviciojaxws?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SERVICIOJAXWSSERVICE_WSDL_LOCATION = url;
        SERVICIOJAXWSSERVICE_EXCEPTION = e;
    }

    public ServicioJaxWsService() {
        super(__getWsdlLocation(), SERVICIOJAXWSSERVICE_QNAME);
    }

    public ServicioJaxWsService(WebServiceFeature... features) {
        super(__getWsdlLocation(), SERVICIOJAXWSSERVICE_QNAME, features);
    }

    public ServicioJaxWsService(URL wsdlLocation) {
        super(wsdlLocation, SERVICIOJAXWSSERVICE_QNAME);
    }

    public ServicioJaxWsService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SERVICIOJAXWSSERVICE_QNAME, features);
    }

    public ServicioJaxWsService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ServicioJaxWsService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ServicioJaxWs
     */
    @WebEndpoint(name = "ServicioJaxWsPort")
    public ServicioJaxWs getServicioJaxWsPort() {
        return super.getPort(new QName("http://ejemplojaxws.formacion.ipartek.com/", "ServicioJaxWsPort"), ServicioJaxWs.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ServicioJaxWs
     */
    @WebEndpoint(name = "ServicioJaxWsPort")
    public ServicioJaxWs getServicioJaxWsPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ejemplojaxws.formacion.ipartek.com/", "ServicioJaxWsPort"), ServicioJaxWs.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SERVICIOJAXWSSERVICE_EXCEPTION!= null) {
            throw SERVICIOJAXWSSERVICE_EXCEPTION;
        }
        return SERVICIOJAXWSSERVICE_WSDL_LOCATION;
    }

}
