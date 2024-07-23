package co.com.jcgfdev.challenge5.domain;

import java.util.List;

public interface InventarioService {
    void agregarProducto(Producto producto);
    void eliminarProducto(String productoId);
    List<Producto> listarProductos();
}
