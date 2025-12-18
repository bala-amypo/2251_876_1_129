import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl {
    
    private final ProductRepository productRepository;
    
    // Constructor injection - CRITICAL for tests
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    
    public Product createProduct(Product product) {
        // Validate SKU uniqueness
        if (productRepository.findBySku(product.getSku()).isPresent()) {
            throw new IllegalArgumentException("SKU already exists");
        }
        
        // Validate price is positive
        if (product.getPrice() == null || product.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Price must be positive");
        }
        
        return productRepository.save(product);
    }
    
    public Product updateProduct(Long id, Product product) {
        Product existing = productRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Product not found"));
        
        existing.setName(product.getName());
        existing.setPrice(product.getPrice());
        if (product.getCategory() != null) {
            existing.setCategory(product.getCategory());
        }
        
        return productRepository.save(existing);
    }
    
    public Product getProductById(Long id) {
        return productRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Product not found"));
    }
    
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    
    public void deactivateProduct(Long id) {
        Product product = getProductById(id);
        product.setActive(false);
        productRepository.save(product);
    }
}