package com.mktplace.model;

import java.net.URI;
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

/**
 * ProductCreationRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class ProductCreationRequest {

  private String userId;

  private String name;

  private String description;

  private Double basePrice;

  private Long quantityAvailable;

  /**
   * Default constructor
   * @deprecated Use {@link ProductCreationRequest#ProductCreationRequest(String, String, String, Double, Long)}
   */
  @Deprecated
  public ProductCreationRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ProductCreationRequest(String userId, String name, String description, Double basePrice, Long quantityAvailable) {
    this.userId = userId;
    this.name = name;
    this.description = description;
    this.basePrice = basePrice;
    this.quantityAvailable = quantityAvailable;
  }

  public ProductCreationRequest userId(String userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Get userId
   * @return userId
  */
  @NotNull @Size(min = 1, max = 50) 
  @Schema(name = "user_id", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("user_id")
  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public ProductCreationRequest name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @NotNull @Size(min = 1, max = 100) 
  @Schema(name = "name", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ProductCreationRequest description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  */
  @NotNull @Size(min = 1, max = 500) 
  @Schema(name = "description", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ProductCreationRequest basePrice(Double basePrice) {
    this.basePrice = basePrice;
    return this;
  }

  /**
   * Get basePrice
   * @return basePrice
  */
  @NotNull 
  @Schema(name = "base_price", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("base_price")
  public Double getBasePrice() {
    return basePrice;
  }

  public void setBasePrice(Double basePrice) {
    this.basePrice = basePrice;
  }

  public ProductCreationRequest quantityAvailable(Long quantityAvailable) {
    this.quantityAvailable = quantityAvailable;
    return this;
  }

  /**
   * Get quantityAvailable
   * @return quantityAvailable
  */
  @NotNull 
  @Schema(name = "quantity_available", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("quantity_available")
  public Long getQuantityAvailable() {
    return quantityAvailable;
  }

  public void setQuantityAvailable(Long quantityAvailable) {
    this.quantityAvailable = quantityAvailable;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductCreationRequest productCreationRequest = (ProductCreationRequest) o;
    return Objects.equals(this.userId, productCreationRequest.userId) &&
        Objects.equals(this.name, productCreationRequest.name) &&
        Objects.equals(this.description, productCreationRequest.description) &&
        Objects.equals(this.basePrice, productCreationRequest.basePrice) &&
        Objects.equals(this.quantityAvailable, productCreationRequest.quantityAvailable);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, name, description, basePrice, quantityAvailable);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductCreationRequest {\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    basePrice: ").append(toIndentedString(basePrice)).append("\n");
    sb.append("    quantityAvailable: ").append(toIndentedString(quantityAvailable)).append("\n");
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

