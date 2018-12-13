package br.com.maikelfenner.demoLiquiBase.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_parent_product")
    private Product parentProduct;

    @OneToMany(mappedBy = "parentProduct", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Product> subProducts;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Image> images;

    public Product() {
        subProducts = new HashSet<>();
        images = new HashSet<>();
    }

    public void addSubProduct(Product product) {
        if(product != null) {
            this.subProducts.add(product);
            product.setParentProduct(this);
        }
    }

    public void addImage(Image image) {
        if(image != null) {
            this.images.add(image);
            image.setProduct(this);
        }
    }
}
