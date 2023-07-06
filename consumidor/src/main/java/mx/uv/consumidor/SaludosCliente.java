package mx.uv.consumidor;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import mx.xlp.SaludarRequest;
import mx.xlp.SaludarResponse;


public class SaludosCliente extends WebServiceGatewaySupport {
    
    public SaludarResponse saludar(String nombre) {
        SaludarRequest sr = new SaludarRequest();
        sr.setNombre(nombre);
        System.out.println(getDefaultUri());
        SaludarResponse saludarResponse = (SaludarResponse) getWebServiceTemplate().marshalSendAndReceive("http://ip172-18-0-68-ch06818sf2q000dg1240-8081.direct.labs.play-with-docker.com/ws/saludos", sr);
        return saludarResponse;
    }
}
