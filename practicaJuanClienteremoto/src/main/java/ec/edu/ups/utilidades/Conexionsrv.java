package ec.edu.ups.utilidades;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

import ec.edu.ups.negocios.HospitalOnRemoto;


public class Conexionsrv {
	
	public HospitalOnRemoto hospitalremoto;
	public HospitalOnRemoto intanciarONRemoto() throws Exception {
		try {  
            final Hashtable<String, Comparable> jndiProperties =  
                    new Hashtable<String, Comparable>();  
            jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY,  
                    "org.wildfly.naming.client.WildFlyInitialContextFactory");  
            jndiProperties.put("jboss.naming.client.ejb.context", true);  
              
            jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");  
            jndiProperties.put(Context.SECURITY_PRINCIPAL, "ejb01");  
            jndiProperties.put(Context.SECURITY_CREDENTIALS, "ejb01");  
              
            final Context context = new InitialContext(jndiProperties);  
              
            final String lookupName = "ejb:/practicaJuan/HospitalON!ec.edu.ups.negocios.HospitalOnRemoto";
              
            this.hospitalremoto = (HospitalOnRemoto) context.lookup(lookupName);  
              
        } catch (Exception ex) {  
            ex.printStackTrace();  
            throw ex;  
        }  
		return hospitalremoto;
	}
}
