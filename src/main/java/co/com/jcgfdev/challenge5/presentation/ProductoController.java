package co.com.jcgfdev.challenge5.presentation;

import co.com.jcgfdev.challenge5.domain.InventarioService;
import co.com.jcgfdev.challenge5.domain.Producto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    private final InventarioService inventarioService;

    private ProductoController(InventarioService inventarioService){
        this.inventarioService = inventarioService;
    }

    @PostMapping
    public Mono<ResponseEntity<Void>> agregarProducto(@RequestBody @Validated Producto producto) {
        return Mono.fromRunnable(() -> inventarioService.agregarProducto(producto))
                .then(Mono.just(ResponseEntity.ok().build()));
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> eliminarProducto(@PathVariable String id) {
        return Mono.fromRunnable(() -> inventarioService.eliminarProducto(id))
                .then(Mono.just(ResponseEntity.ok().build()));
    }

    @GetMapping
    public Flux<Producto> listarProductos() {
        return Flux.fromIterable(inventarioService.listarProductos());
    }
}
