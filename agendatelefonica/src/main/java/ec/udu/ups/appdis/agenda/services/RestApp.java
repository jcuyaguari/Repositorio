package ec.udu.ups.appdis.agenda.services;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.tags.Tag;

@OpenAPIDefinition(
		servers = {
				@Server(
						description = "Servidor Local",
						url= "/agendatelefonica")
		}
)
@ApplicationPath("/ws")
public class RestApp extends Application{

}

//   ,
//		tags = {
//				@Tag(name = "OWA API", description = "Observatorio de Accesibilidad Web"),
//				@Tag(name = "Tenon API", description = "Tenon IO"),
//				@Tag(name = "AChecker API", description = "Web Accessibility Checker")
//		} 