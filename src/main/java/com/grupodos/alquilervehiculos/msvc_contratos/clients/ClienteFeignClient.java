package com.grupodos.alquilervehiculos.msvc_contratos.clients;

import com.grupodos.alquilervehiculos.msvc_contratos.dto.ClienteDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(
        name = "msvc-clientes",
        url = "${MSVC_CLIENTES_URL:http://138.68.2.13:8082}"
)
public interface ClienteFeignClient {

    @GetMapping("/api/clientes/contratos/{id}")
    ClienteDto obtenerClientePorId(@PathVariable("id") UUID id);
}