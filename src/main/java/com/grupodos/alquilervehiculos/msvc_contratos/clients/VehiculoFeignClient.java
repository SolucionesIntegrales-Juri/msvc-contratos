package com.grupodos.alquilervehiculos.msvc_contratos.clients;

import com.grupodos.alquilervehiculos.msvc_contratos.dto.CambioEstadoVehDto;
import com.grupodos.alquilervehiculos.msvc_contratos.dto.VehiculoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@FeignClient(
        name = "msvc-vehiculos",
        url = "${MSVC_VEHICULOS_URL:http://138.68.2.13:8083}"
)
public interface VehiculoFeignClient {

    @GetMapping("/api/vehiculos/contratos/{id}")
    VehiculoDto obtenerVehiculoPorId(@PathVariable UUID id);

    @PutMapping("/api/vehiculos/{id}/estado")
    void actualizarEstado(@PathVariable UUID id, @RequestBody CambioEstadoVehDto request);
}