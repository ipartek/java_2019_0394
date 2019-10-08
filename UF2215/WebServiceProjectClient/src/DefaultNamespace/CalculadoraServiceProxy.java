package DefaultNamespace;

public class CalculadoraServiceProxy implements DefaultNamespace.CalculadoraService {
  private String _endpoint = null;
  private DefaultNamespace.CalculadoraService calculadoraService = null;
  
  public CalculadoraServiceProxy() {
    _initCalculadoraServiceProxy();
  }
  
  public CalculadoraServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initCalculadoraServiceProxy();
  }
  
  private void _initCalculadoraServiceProxy() {
    try {
      calculadoraService = (new DefaultNamespace.CalculadoraServiceServiceLocator()).getCalculadoraService();
      if (calculadoraService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)calculadoraService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)calculadoraService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (calculadoraService != null)
      ((javax.xml.rpc.Stub)calculadoraService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public DefaultNamespace.CalculadoraService getCalculadoraService() {
    if (calculadoraService == null)
      _initCalculadoraServiceProxy();
    return calculadoraService;
  }
  
  public int sumar(int a, int b) throws java.rmi.RemoteException{
    if (calculadoraService == null)
      _initCalculadoraServiceProxy();
    return calculadoraService.sumar(a, b);
  }
  
  
}