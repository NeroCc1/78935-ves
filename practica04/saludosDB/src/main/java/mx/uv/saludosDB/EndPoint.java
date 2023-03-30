package mx.uv.saludosDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import https.t4is_uv_mx.saludos.BusquedaIDRequest;
import https.t4is_uv_mx.saludos.BusquedaIDResponse;
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

    @PayloadRoot(namespace = "https://t4is.uv.mx/saludos",localPart = "BusquedaIDRequest")

    public BusquedaIDResponse Buscar(@RequestPayload BusquedaIDRequest peticion) {
        
        BusquedaIDResponse response = new BusquedaIDResponse(); 
        Saludador saludador = new Saludador();
        //saludador = iSaludador.findById(peticion.getId()).getId();
        response.setRespuesta(saludador.getNombre());
        return response;
        
    } 
}


