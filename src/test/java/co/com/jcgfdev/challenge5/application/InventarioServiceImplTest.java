package co.com.jcgfdev.challenge5.application;

import co.com.jcgfdev.challenge5.domain.Producto;
import co.com.jcgfdev.challenge5.persistence.ProductoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Flux;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class InventarioServiceImplTest {

    @MockBean
    private ProductoRepository productoRepository;

    @Autowired
    private InventarioServiceImpl inventarioService;

    @Test
    void agregarProducto() {
        Producto producto = new Producto();
        producto.setId("1");
        producto.setNombre("Producto1");
        producto.setCantidad(10);

        inventarioService.agregarProducto(producto);
        verify(productoRepository, times(1)).save(producto);
    }

    @Test
    void eliminarProducto() {
        String productoId = "1";
        inventarioService.eliminarProducto(productoId);
        verify(productoRepository, times(1)).deleteById(productoId);
    }

    @Test
    void listarProductos() {
        List<Producto> productos = List.of(new Producto("1", "Producto1", 10));
        when(productoRepository.findAll()).thenReturn(productos);

        List<Producto> resultado = inventarioService.listarProductos();
        assertEquals(productos, resultado);
    }

}