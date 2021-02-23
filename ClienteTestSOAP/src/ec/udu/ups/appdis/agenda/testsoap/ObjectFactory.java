
package ec.udu.ups.appdis.agenda.testsoap;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ec.udu.ups.appdis.agenda.testsoap package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Deposito_QNAME = new QName("http://services.agenda.appdis.ups.udu.ec/", "deposito");
    private final static QName _SaludarResponse_QNAME = new QName("http://services.agenda.appdis.ups.udu.ec/", "saludarResponse");
    private final static QName _ListaPersonasResponse_QNAME = new QName("http://services.agenda.appdis.ups.udu.ec/", "listaPersonasResponse");
    private final static QName _Saludar_QNAME = new QName("http://services.agenda.appdis.ups.udu.ec/", "saludar");
    private final static QName _ListaPersonas_QNAME = new QName("http://services.agenda.appdis.ups.udu.ec/", "listaPersonas");
    private final static QName _DepositoResponse_QNAME = new QName("http://services.agenda.appdis.ups.udu.ec/", "depositoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ec.udu.ups.appdis.agenda.testsoap
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DepositoResponse }
     * 
     */
    public DepositoResponse createDepositoResponse() {
        return new DepositoResponse();
    }

    /**
     * Create an instance of {@link ListaPersonas }
     * 
     */
    public ListaPersonas createListaPersonas() {
        return new ListaPersonas();
    }

    /**
     * Create an instance of {@link ListaPersonasResponse }
     * 
     */
    public ListaPersonasResponse createListaPersonasResponse() {
        return new ListaPersonasResponse();
    }

    /**
     * Create an instance of {@link Saludar }
     * 
     */
    public Saludar createSaludar() {
        return new Saludar();
    }

    /**
     * Create an instance of {@link SaludarResponse }
     * 
     */
    public SaludarResponse createSaludarResponse() {
        return new SaludarResponse();
    }

    /**
     * Create an instance of {@link Deposito }
     * 
     */
    public Deposito createDeposito() {
        return new Deposito();
    }

    /**
     * Create an instance of {@link Persona }
     * 
     */
    public Persona createPersona() {
        return new Persona();
    }

    /**
     * Create an instance of {@link Telefono }
     * 
     */
    public Telefono createTelefono() {
        return new Telefono();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Deposito }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.agenda.appdis.ups.udu.ec/", name = "deposito")
    public JAXBElement<Deposito> createDeposito(Deposito value) {
        return new JAXBElement<Deposito>(_Deposito_QNAME, Deposito.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaludarResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.agenda.appdis.ups.udu.ec/", name = "saludarResponse")
    public JAXBElement<SaludarResponse> createSaludarResponse(SaludarResponse value) {
        return new JAXBElement<SaludarResponse>(_SaludarResponse_QNAME, SaludarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListaPersonasResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.agenda.appdis.ups.udu.ec/", name = "listaPersonasResponse")
    public JAXBElement<ListaPersonasResponse> createListaPersonasResponse(ListaPersonasResponse value) {
        return new JAXBElement<ListaPersonasResponse>(_ListaPersonasResponse_QNAME, ListaPersonasResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Saludar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.agenda.appdis.ups.udu.ec/", name = "saludar")
    public JAXBElement<Saludar> createSaludar(Saludar value) {
        return new JAXBElement<Saludar>(_Saludar_QNAME, Saludar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListaPersonas }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.agenda.appdis.ups.udu.ec/", name = "listaPersonas")
    public JAXBElement<ListaPersonas> createListaPersonas(ListaPersonas value) {
        return new JAXBElement<ListaPersonas>(_ListaPersonas_QNAME, ListaPersonas.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DepositoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.agenda.appdis.ups.udu.ec/", name = "depositoResponse")
    public JAXBElement<DepositoResponse> createDepositoResponse(DepositoResponse value) {
        return new JAXBElement<DepositoResponse>(_DepositoResponse_QNAME, DepositoResponse.class, null, value);
    }

}
