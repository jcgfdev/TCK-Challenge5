package co.com.jcgfdev.challenge5.presentation;

import co.com.jcgfdev.challenge5.domain.InventarioService;
import co.com.jcgfdev.challenge5.domain.Producto;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

import static org.mockito.Mockito.when;

@WebFluxTest(ProductoController.class)
class ProductoControllerTest {
    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private InventarioService snventarioService;

    @Test
    void agregarProducto() {
        Producto producto = new Producto();
        producto.setId("1");
        producto.setNombre("Producto1");
        producto.setCantidad(10);

        webTestClient.post().uri("/productos")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(producto)
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void eliminarProducto() {
        webTestClient.delete().uri("/productos/1")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void listarProductos() {
        List<Producto> productos = List.of(new Producto("1", "Producto1", 10));
        when(snventarioService.listarProductos()).thenReturn(productos);

        webTestClient.get().uri("/productos")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Producto.class)
                .isEqualTo(productos);
    }
}