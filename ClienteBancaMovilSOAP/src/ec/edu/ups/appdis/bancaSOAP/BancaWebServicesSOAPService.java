package ec.edu.ups.appdis.bancaSOAP;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.7.11
 * 2020-06-24T13:36:29.409-05:00
 * Generated source version: 2.7.11
 * 
 */
@WebServiceClient(name = "BancaWebServicesSOAPService", 
                  wsdlLocation = "http://localhost:8080/BancaMovil/BancaWebServicesSOAP?wsdl",
                  targetNamespace = "http://servis.proyecto.ups.edu.ec/") 
public class BancaWebServicesSOAPService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://servis.proyecto.ups.edu.ec/", "BancaWebServicesSOAPService");
    public final static QName BancaWebServicesSOAPPort = new QName("http://servis.proyecto.ups.edu.ec/", "BancaWebServicesSOAPPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8080/BancaMovil/BancaWebServicesSOAP?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(BancaWebServicesSOAPService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:8080/BancaMovil/BancaWebServicesSOAP?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public BancaWebServicesSOAPService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public BancaWebServicesSOAPService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public BancaWebServicesSOAPService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public BancaWebServicesSOAPService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public BancaWebServicesSOAPService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public BancaWebServicesSOAPService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns BancaWebServicesSOAP
     */
    @WebEndpoint(name = "BancaWebServicesSOAPPort")
    public BancaWebServicesSOAP getBancaWebServicesSOAPPort() {
        return super.getPort(BancaWebServicesSOAPPort, BancaWebServicesSOAP.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns BancaWebServicesSOAP
     */
    @WebEndpoint(name = "BancaWebServicesSOAPPort")
    public BancaWebServicesSOAP getBancaWebServicesSOAPPort(WebServiceFeature... features) {
        return super.getPort(BancaWebServicesSOAPPort, BancaWebServicesSOAP.class, features);
    }

}
