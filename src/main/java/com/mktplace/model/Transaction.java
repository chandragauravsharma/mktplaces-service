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
 * Transaction
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class Transaction {

  private Long id;

  private Long buyerId;

  private Long itemId;

  private Double price;

  private Long transactionDate;

  public Transaction id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Transaction buyerId(Long buyerId) {
    this.buyerId = buyerId;
    return this;
  }

  /**
   * Get buyerId
   * @return buyerId
  */
  
  @Schema(name = "buyerId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("buyerId")
  public Long getBuyerId() {
    return buyerId;
  }

  public void setBuyerId(Long buyerId) {
    this.buyerId = buyerId;
  }

  public Transaction itemId(Long itemId) {
    this.itemId = itemId;
    return this;
  }

  /**
   * Get itemId
   * @return itemId
  */
  
  @Schema(name = "itemId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("itemId")
  public Long getItemId() {
    return itemId;
  }

  public void setItemId(Long itemId) {
    this.itemId = itemId;
  }

  public Transaction price(Double price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * @return price
  */
  
  @Schema(name = "price", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("price")
  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Transaction transactionDate(Long transactionDate) {
    this.transactionDate = transactionDate;
    return this;
  }

  /**
   * Get transactionDate
   * @return transactionDate
  */
  
  @Schema(name = "transactionDate", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("transactionDate")
  public Long getTransactionDate() {
    return transactionDate;
  }

  public void setTransactionDate(Long transactionDate) {
    this.transactionDate = transactionDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Transaction transaction = (Transaction) o;
    return Objects.equals(this.id, transaction.id) &&
        Objects.equals(this.buyerId, transaction.buyerId) &&
        Objects.equals(this.itemId, transaction.itemId) &&
        Objects.equals(this.price, transaction.price) &&
        Objects.equals(this.transactionDate, transaction.transactionDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, buyerId, itemId, price, transactionDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Transaction {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    buyerId: ").append(toIndentedString(buyerId)).append("\n");
    sb.append("    itemId: ").append(toIndentedString(itemId)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    transactionDate: ").append(toIndentedString(transactionDate)).append("\n");
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

