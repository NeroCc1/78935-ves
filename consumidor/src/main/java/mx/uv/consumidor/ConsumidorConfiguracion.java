package mx.uv.consumidor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class ConsumidorConfiguracion {
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("mx.xlp");
        return marshaller;
    }

    @Bean
    public SaludosCliente saludosCliente(Jaxb2Marshaller mar) {
        SaludosCliente sCliente = new SaludosCliente();
        sCliente.setDefaultUri("http://ip172-18-0-68-ch06818sf2q000dg1240-8081.direct.labs.play-with-docker.com/ws");
        sCliente.setMarshaller(mar);
        sCliente.setUnmarshaller(mar);
        return sCliente;
    }
}
