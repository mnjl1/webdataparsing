package webdata;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

import java.util.Objects;

@XStreamAlias("offer")
public class Offer {
    @XStreamAlias("articleID")
    @XStreamAsAttribute
    private String articleId;

    @XStreamAlias("product name")
    @XStreamAsAttribute
    private String productName;

    @XStreamAlias("brand")
    @XStreamAsAttribute
    private String brand;

    @XStreamAlias("color")
    @XStreamAsAttribute
    private String color;

    @XStreamAlias("price")
    @XStreamAsAttribute
    private String price;

    @XStreamAlias("initialPrice")
    @XStreamAsAttribute
    private String initialPrice;

    @XStreamAlias("description")
    @XStreamAsAttribute
    private String description;
    private String shippingPrice;

    public Offer(){
    }


    public Offer(String articleId, String productName, String brand, String color, String price,
                 String initialPrice, String description) {
        this.articleId = articleId;
        this.productName = productName;
        this.brand = brand;
        this.color = color;
        this.price = price;
        this.initialPrice = initialPrice;
        this.description = description;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(String initialPrice) {
        this.initialPrice = initialPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShippingPrice() {
        return shippingPrice;
    }

    public void setShippingPrice(String shippingPrice) {
        this.shippingPrice = shippingPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Offer)) return false;
        Offer offer = (Offer) o;
        return Objects.equals(articleId, offer.articleId) &&
                Objects.equals(productName, offer.productName) &&
                Objects.equals(brand, offer.brand) &&
                Objects.equals(color, offer.color) &&
                Objects.equals(price, offer.price) &&
                Objects.equals(initialPrice, offer.initialPrice) &&
                Objects.equals(description, offer.description) &&
                Objects.equals(shippingPrice, offer.shippingPrice);
    }

    @Override
    public int hashCode() {

        return Objects.hash(articleId, productName, brand, color, price, initialPrice, description, shippingPrice);
    }

    @Override
    public String toString() {
        return "Offer{" +
                "articleId='" + articleId + '\'' +
                ", productName='" + productName + '\'' +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", price='" + price + '\'' +
                ", initialPrice=" + initialPrice +
                ", description='" + description + '\'' +
                ", shippingPrice=" + shippingPrice +
                '}';
    }
}
