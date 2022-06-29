package org.example.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "products")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long brand_id;
    private Long product_type_id;
    private Long category_id;
    private Double price;

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(Long brand_id) {
        this.brand_id = brand_id;
    }

    public Long getProduct_type_id() {
        return product_type_id;
    }

    public void setProduct_type_id(Long product_type_id) {
        this.product_type_id = product_type_id;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != null ? !id.equals(product.id) : product.id != null) return false;
        if (brand_id != null ? !brand_id.equals(product.brand_id) : product.brand_id != null) return false;
        if (product_type_id != null ? !product_type_id.equals(product.product_type_id) : product.product_type_id != null)
            return false;
        if (category_id != null ? !category_id.equals(product.category_id) : product.category_id != null) return false;
        return price != null ? price.equals(product.price) : product.price == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (brand_id != null ? brand_id.hashCode() : 0);
        result = 31 * result + (product_type_id != null ? product_type_id.hashCode() : 0);
        result = 31 * result + (category_id != null ? category_id.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", brand_id=" + brand_id +
                ", product_type_id=" + product_type_id +
                ", category_id=" + category_id +
                ", price=" + price +
                '}';
    }
}
