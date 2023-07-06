package mx.uv.Perreria;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import https.perrerialomos_uv_mx.lomitos.ModificarRegisRequest;
import https.perrerialomos_uv_mx.lomitos.ModificarRegisResponse;
//import https.perrerialomos_uv_mx.saludos.SaludarPeRequest;
//import https.perrerialomos_uv_mx.saludos.SaludarPeResponse;


@Endpoint
public class EndPoint {
    @Autowired
    private ISaludadores isaludador;
/*
    @PayloadRoot(namespace = "https://perreriaLomos.uv.mx/saludos", localPart = "SaludarPeRequest")
    @ResponsePayload
    public SaludarPeResponse Saludar(@RequestPayload SaludarPeRequest peticion) {
        SaludarPeResponse respuesta = new SaludarPeResponse();
        respuesta.setRespuesta("Hola " + peticion.getNombre());

        Saludador saludador = new Saludador();
        saludador.setNombre(peticion.getNombre());
        isaludador.save(saludador);       
        return respuesta;
    }
*/
    @PayloadRoot(namespace = "https://perreriaLomos.uv.mx/lomitos", localPart = "ModificarRegisRequest")
    @ResponsePayload
    public ModificarRegisResponse Actualizar(@RequestPayload ModificarRegisRequest peticion) {
        ModificarRegisResponse respuesta = new ModificarRegisResponse();

        Optional<Saludador> resultado = isaludador.findById(peticion.getId());

        if(!resultado.isPresent()) {
            respuesta.setRespuesta("Lomito no encontrado no encontrado");

            return respuesta;
        }
        
        Saludador saludador = resultado.get();
        saludador.setNombre(peticion.getNombre());
        saludador.setRaza(peticion.getRaza());
        saludador.setEdad(peticion.getEdad());

        isaludador.save(saludador);
        respuesta.setRespuesta("Actualización realizada con éxito");

        return respuesta;
    }
} 
