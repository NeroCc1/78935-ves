package mx.uv.saludosDB;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import https.t4is_uv_mx.saludos.ModificarRegisRequest;
import https.t4is_uv_mx.saludos.ModificarRegisResponse;
import https.t4is_uv_mx.saludos.SaludarRequest;
import https.t4is_uv_mx.saludos.SaludarResponse;


@Endpoint
public class EndPoint {
    @Autowired
    private ISaludador iSaludador;



    @PayloadRoot(namespace = "https://t4is.uv.mx/saludos",localPart = "SaludarRequest")

    @ResponsePayload
    public SaludarResponse Saludar(@RequestPayload SaludarRequest peticion){
        SaludarResponse respuesta = new SaludarResponse();
        respuesta.setRespuesta("Hola "+ peticion.getNombre());

        Saludador saludador = new Saludador();
        saludador.setNombre((peticion.getNombre()));
        iSaludador.save(saludador);
        return respuesta;
    }

    @PayloadRoot(namespace = "https://t4is.uv.mx/saludos", localPart = "ModificarRegisRequest")
    @ResponsePayload
    public ModificarRegisResponse Actualizar(@RequestPayload ModificarRegisRequest peticion) {
        ModificarRegisResponse respuesta = new ModificarRegisResponse();

        Optional<Saludador> resultado = iSaludador.findById(peticion.getId());

        if(!resultado.isPresent()) {
            respuesta.setRespuesta("Saludo no encontrado no encontrado");

            return respuesta;
        }
        
        Saludador saludador = resultado.get();
        saludador.setNombre(peticion.getNombre());

        iSaludador.save(saludador);
        respuesta.setRespuesta("Actualización realizada con éxito");

        return respuesta;
    }
}


