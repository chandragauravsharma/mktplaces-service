package com.mktplace.model.dto;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 * Product
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@Table(name = "products")
public class ProductDTO {

  @Id
  private Long productId;

  private Long userId;

  private String name;

  private String description;

  private Double basePrice;

  private Long quantityAvailable;

  private Long quantitySold;

  private Long quantityOnHold;

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;

  public ProductDTO productId(Long productId) {
    this.productId = productId;
    return this;
  }

  /**
   * Get productId
   * @return productId
   */

  @Schema(name = "product_id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("product_id")
  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public ProductDTO userId(Long userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Get userId
   * @return userId
   */
  @Size(min = 1, max = 50)
  @Schema(name = "user_id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("user_id")
  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public ProductDTO name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   */
  @Size(min = 1, max = 100)
  @Schema(name = "name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ProductDTO description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
   */
  @Size(min = 1, max = 500)
  @Schema(name = "description", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ProductDTO basePrice(Double basePrice) {
    this.basePrice = basePrice;
    return this;
  }

  /**
   * Get basePrice
   * @return basePrice
   */

  @Schema(name = "base_price", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("base_price")
  public Double getBasePrice() {
    return basePrice;
  }

  public void setBasePrice(Double basePrice) {
    this.basePrice = basePrice;
  }

  public ProductDTO quantityAvailable(Long quantityAvailable) {
    this.quantityAvailable = quantityAvailable;
    return this;
  }

  /**
   * Get quantityAvailable
   * @return quantityAvailable
   */

  @Schema(name = "quantity_available", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("quantity_available")
  public Long getQuantityAvailable() {
    return quantityAvailable;
  }

  public void setQuantityAvailable(Long quantityAvailable) {
    this.quantityAvailable = quantityAvailable;
  }

  public ProductDTO quantitySold(Long quantitySold) {
    this.quantitySold = quantitySold;
    return this;
  }

  /**
   * Get quantitySold
   * @return quantitySold
   */

  @Schema(name = "quantity_sold", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("quantity_sold")
  public Long getQuantitySold() {
    return quantitySold;
  }

  public void setQuantitySold(Long quantitySold) {
    this.quantitySold = quantitySold;
  }

  public ProductDTO quantityOnHold(Long quantityOnHold) {
    this.quantityOnHold = quantityOnHold;
    return this;
  }

  /**
   * Get quantityOnHold
   * @return quantityOnHold
   */

  @Schema(name = "quantity_on_hold", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("quantity_on_hold")
  public Long getQuantityOnHold() {
    return quantityOnHold;
  }

  public void setQuantityOnHold(Long quantityOnHold) {
    this.quantityOnHold = quantityOnHold;
  }

  public ProductDTO createdAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * Get createdAt
   * @return createdAt
   */

  @Schema(name = "createdAt", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("createdAt")
  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public ProductDTO updatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

  /**
   * Get updatedAt
   * @return updatedAt
   */

  @Schema(name = "updatedAt", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("updatedAt")
  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductDTO product = (ProductDTO) o;
    return Objects.equals(this.productId, product.productId) &&
            Objects.equals(this.userId, product.userId) &&
            Objects.equals(this.name, product.name) &&
            Objects.equals(this.description, product.description) &&
            Objects.equals(this.basePrice, product.basePrice) &&
            Objects.equals(this.quantityAvailable, product.quantityAvailable) &&
            Objects.equals(this.quantitySold, product.quantitySold) &&
            Objects.equals(this.quantityOnHold, product.quantityOnHold) &&
            Objects.equals(this.createdAt, product.createdAt) &&
            Objects.equals(this.updatedAt, product.updatedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productId, userId, name, description, basePrice, quantityAvailable, quantitySold, quantityOnHold, createdAt, updatedAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Product {\n");
    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    basePrice: ").append(toIndentedString(basePrice)).append("\n");
    sb.append("    quantityAvailable: ").append(toIndentedString(quantityAvailable)).append("\n");
    sb.append("    quantitySold: ").append(toIndentedString(quantitySold)).append("\n");
    sb.append("    quantityOnHold: ").append(toIndentedString(quantityOnHold)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

