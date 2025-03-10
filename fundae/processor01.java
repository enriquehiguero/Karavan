import org.apache.camel.BindToRegistry;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import java.util.HashMap;

@BindToRegistry("processor01")
public class processor01 implements Processor {
    public void process(Exchange exchange) throws Exception {
        // Obtener el cuerpo directamente como HashMap
        HashMap<String, String> body = exchange.getIn().getBody(HashMap.class);
        if (body != null) {
            // Acceder a valores específicos
            String property01 = body.get("property01");
            exchange.setProperty("P_property01", property01);
            String property02 = body.get("property02");
            exchange.setProperty("P_property02", property02);
            // Establecer una nueva propiedad
            exchange.setProperty("Identificator", property01 + "|" + property02);
        } else {
            // Opcional: Manejar el caso cuando body es null
            throw new IllegalArgumentException("Body is null or not a HashMap");
        }
    }
}