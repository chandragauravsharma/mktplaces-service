package com.mktplace.model.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Booking
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@Table(name = "booking")
public class BookingDTO {

  @Id
  private Long bookingId;

  private Long buyerId;

  private Long sellerId;

  private Long productId;

  private Double transactionAmount;

  private Long paymentId;

  /**
   * Gets or Sets status
   */
  public enum StatusEnum {
    CREATED("created"),
    
    HOLD("hold"),
    
    BOOKED("booked"),
    
    CANCELLED("cancelled"),
    
    REFUNDED("refunded");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String value) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equalsIgnoreCase(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private StatusEnum status;

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;

  public BookingDTO bookingId(Long bookingId) {
    this.bookingId = bookingId;
    return this;
  }

  /**
   * Get bookingId
   * @return bookingId
  */
  
  @Schema(name = "booking_id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("booking_id")
  public Long getBookingId() {
    return bookingId;
  }

  public void setBookingId(Long bookingId) {
    this.bookingId = bookingId;
  }

  public BookingDTO buyerId(Long buyerId) {
    this.buyerId = buyerId;
    return this;
  }

  /**
   * Get buyerId
   * @return buyerId
  */
  
  @Schema(name = "buyer_id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("buyer_id")
  public Long getBuyerId() {
    return buyerId;
  }

  public void setBuyerId(Long buyerId) {
    this.buyerId = buyerId;
  }

  public BookingDTO sellerId(Long sellerId) {
    this.sellerId = sellerId;
    return this;
  }

  /**
   * Get sellerId
   * @return sellerId
  */
  
  @Schema(name = "seller_id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("seller_id")
  public Long getSellerId() {
    return sellerId;
  }

  public void setSellerId(Long sellerId) {
    this.sellerId = sellerId;
  }

  public BookingDTO productId(Long productId) {
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

  public BookingDTO transactionAmount(Double transactionAmount) {
    this.transactionAmount = transactionAmount;
    return this;
  }

  /**
   * Get transactionAmount
   * @return transactionAmount
  */
  
  @Schema(name = "transaction_amount", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("transaction_amount")
  public Double getTransactionAmount() {
    return transactionAmount;
  }

  public void setTransactionAmount(Double transactionAmount) {
    this.transactionAmount = transactionAmount;
  }

  public BookingDTO paymentId(Long paymentId) {
    this.paymentId = paymentId;
    return this;
  }

  /**
   * Get paymentId
   * @return paymentId
  */
  
  @Schema(name = "payment_id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("payment_id")
  public Long getPaymentId() {
    return paymentId;
  }

  public void setPaymentId(Long paymentId) {
    this.paymentId = paymentId;
  }

  public BookingDTO status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  */
  
  @Schema(name = "status", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("status")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public BookingDTO createdAt(LocalDateTime createdAt) {
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

  public BookingDTO updatedAt(LocalDateTime updatedAt) {
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
    BookingDTO booking = (BookingDTO) o;
    return Objects.equals(this.bookingId, booking.bookingId) &&
        Objects.equals(this.buyerId, booking.buyerId) &&
        Objects.equals(this.sellerId, booking.sellerId) &&
        Objects.equals(this.productId, booking.productId) &&
        Objects.equals(this.transactionAmount, booking.transactionAmount) &&
        Objects.equals(this.paymentId, booking.paymentId) &&
        Objects.equals(this.status, booking.status) &&
        Objects.equals(this.createdAt, booking.createdAt) &&
        Objects.equals(this.updatedAt, booking.updatedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bookingId, buyerId, sellerId, productId, transactionAmount, paymentId, status, createdAt, updatedAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Booking {\n");
    sb.append("    bookingId: ").append(toIndentedString(bookingId)).append("\n");
    sb.append("    buyerId: ").append(toIndentedString(buyerId)).append("\n");
    sb.append("    sellerId: ").append(toIndentedString(sellerId)).append("\n");
    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
    sb.append("    transactionAmount: ").append(toIndentedString(transactionAmount)).append("\n");
    sb.append("    paymentId: ").append(toIndentedString(paymentId)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

