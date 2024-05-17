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
 * CheckoutRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class CheckoutRequest {

  private Long buyerId;

  private Long sellerId;

  private Long productId;

  private Double transactionAmount;

  /**
   * Default constructor
   * @deprecated Use {@link CheckoutRequest#CheckoutRequest(Long, Long, Long, Double)}
   */
  @Deprecated
  public CheckoutRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CheckoutRequest(Long buyerId, Long sellerId, Long productId, Double transactionAmount) {
    this.buyerId = buyerId;
    this.sellerId = sellerId;
    this.productId = productId;
    this.transactionAmount = transactionAmount;
  }

  public CheckoutRequest buyerId(Long buyerId) {
    this.buyerId = buyerId;
    return this;
  }

  /**
   * Get buyerId
   * @return buyerId
  */
  @NotNull 
  @Schema(name = "buyer_id", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("buyer_id")
  public Long getBuyerId() {
    return buyerId;
  }

  public void setBuyerId(Long buyerId) {
    this.buyerId = buyerId;
  }

  public CheckoutRequest sellerId(Long sellerId) {
    this.sellerId = sellerId;
    return this;
  }

  /**
   * Get sellerId
   * @return sellerId
  */
  @NotNull 
  @Schema(name = "seller_id", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("seller_id")
  public Long getSellerId() {
    return sellerId;
  }

  public void setSellerId(Long sellerId) {
    this.sellerId = sellerId;
  }

  public CheckoutRequest productId(Long productId) {
    this.productId = productId;
    return this;
  }

  /**
   * Get productId
   * @return productId
  */
  @NotNull 
  @Schema(name = "product_id", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("product_id")
  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public CheckoutRequest transactionAmount(Double transactionAmount) {
    this.transactionAmount = transactionAmount;
    return this;
  }

  /**
   * Get transactionAmount
   * @return transactionAmount
  */
  @NotNull 
  @Schema(name = "transaction_amount", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("transaction_amount")
  public Double getTransactionAmount() {
    return transactionAmount;
  }

  public void setTransactionAmount(Double transactionAmount) {
    this.transactionAmount = transactionAmount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CheckoutRequest checkoutRequest = (CheckoutRequest) o;
    return Objects.equals(this.buyerId, checkoutRequest.buyerId) &&
        Objects.equals(this.sellerId, checkoutRequest.sellerId) &&
        Objects.equals(this.productId, checkoutRequest.productId) &&
        Objects.equals(this.transactionAmount, checkoutRequest.transactionAmount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(buyerId, sellerId, productId, transactionAmount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CheckoutRequest {\n");
    sb.append("    buyerId: ").append(toIndentedString(buyerId)).append("\n");
    sb.append("    sellerId: ").append(toIndentedString(sellerId)).append("\n");
    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
    sb.append("    transactionAmount: ").append(toIndentedString(transactionAmount)).append("\n");
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

