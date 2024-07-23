package co.com.jcgfdev.challenge5.persistence;

import co.com.jcgfdev.challenge5.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, String> {
}
