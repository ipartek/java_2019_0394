
package com.ipartek.formacion.ejemplojaxws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ServicioJaxWs", targetNamespace = "http://ejemplojaxws.formacion.ipartek.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ServicioJaxWs {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "saludar", targetNamespace = "http://ejemplojaxws.formacion.ipartek.com/", className = "com.ipartek.formacion.ejemplojaxws.Saludar")
    @ResponseWrapper(localName = "saludarResponse", targetNamespace = "http://ejemplojaxws.formacion.ipartek.com/", className = "com.ipartek.formacion.ejemplojaxws.SaludarResponse")
    @Action(input = "http://ejemplojaxws.formacion.ipartek.com/ServicioJaxWs/saludarRequest", output = "http://ejemplojaxws.formacion.ipartek.com/ServicioJaxWs/saludarResponse")
    public String saludar(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}