package co.com.jcgfdev.challenge5.application;
import co.com.jcgfdev.challenge5.domain.Producto;
import co.com.jcgfdev.challenge5.domain.InventarioService;
import co.com.jcgfdev.challenge5.persistence.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventarioServiceImpl implements InventarioService {
    private final ProductoRepository productoRepository;

    public InventarioServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public void agregarProducto(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public void eliminarProducto(String productoId) {
        productoRepository.deleteById(productoId);
    }

    @Override
    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }
}

