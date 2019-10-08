/**
 * CalculadoraServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package DefaultNamespace;

public class CalculadoraServiceServiceLocator extends org.apache.axis.client.Service implements DefaultNamespace.CalculadoraServiceService {

    public CalculadoraServiceServiceLocator() {
    }


    public CalculadoraServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CalculadoraServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CalculadoraService
    private java.lang.String CalculadoraService_address = "http://localhost:8080/WebServiceProject/services/CalculadoraService";

    public java.lang.String getCalculadoraServiceAddress() {
        return CalculadoraService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CalculadoraServiceWSDDServiceName = "CalculadoraService";

    public java.lang.String getCalculadoraServiceWSDDServiceName() {
        return CalculadoraServiceWSDDServiceName;
    }

    public void setCalculadoraServiceWSDDServiceName(java.lang.String name) {
        CalculadoraServiceWSDDServiceName = name;
    }

    public DefaultNamespace.CalculadoraService getCalculadoraService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CalculadoraService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCalculadoraService(endpoint);
    }

    public DefaultNamespace.CalculadoraService getCalculadoraService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            DefaultNamespace.CalculadoraServiceSoapBindingStub _stub = new DefaultNamespace.CalculadoraServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getCalculadoraServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCalculadoraServiceEndpointAddress(java.lang.String address) {
        CalculadoraService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (DefaultNamespace.CalculadoraService.class.isAssignableFrom(serviceEndpointInterface)) {
                DefaultNamespace.CalculadoraServiceSoapBindingStub _stub = new DefaultNamespace.CalculadoraServiceSoapBindingStub(new java.net.URL(CalculadoraService_address), this);
                _stub.setPortName(getCalculadoraServiceWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("CalculadoraService".equals(inputPortName)) {
            return getCalculadoraService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://DefaultNamespace", "CalculadoraServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://DefaultNamespace", "CalculadoraService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("CalculadoraService".equals(portName)) {
            setCalculadoraServiceEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
