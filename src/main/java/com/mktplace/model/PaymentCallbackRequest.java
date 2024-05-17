package com.mktplace.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * PaymentCallbackRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class PaymentCallbackRequest {

  private Long paymentId;

  private Long bookingId;

  private Double transactionAmount;

  /**
   * Gets or Sets status
   */
  public enum StatusEnum {
    INITIATED("initiated"),
    
    SUCCESS("success"),
    
    FAILED("failed"),
    
    REVERSED("reversed"),
    
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

  /**
   * Default constructor
   * @deprecated Use {@link PaymentCallbackRequest#PaymentCallbackRequest(Long, Long, Double, StatusEnum)}
   */
  @Deprecated
  public PaymentCallbackRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public PaymentCallbackRequest(Long paymentId, Long bookingId, Double transactionAmount, StatusEnum status) {
    this.paymentId = paymentId;
    this.bookingId = bookingId;
    this.transactionAmount = transactionAmount;
    this.status = status;
  }

  public PaymentCallbackRequest paymentId(Long paymentId) {
    this.paymentId = paymentId;
    return this;
  }

  /**
   * Get paymentId
   * @return paymentId
  */
  @NotNull 
  @Schema(name = "payment_id", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("payment_id")
  public Long getPaymentId() {
    return paymentId;
  }

  public void setPaymentId(Long paymentId) {
    this.paymentId = paymentId;
  }

  public PaymentCallbackRequest bookingId(Long bookingId) {
    this.bookingId = bookingId;
    return this;
  }

  /**
   * Get bookingId
   * @return bookingId
  */
  @NotNull 
  @Schema(name = "booking_id", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("booking_id")
  public Long getBookingId() {
    return bookingId;
  }

  public void setBookingId(Long bookingId) {
    this.bookingId = bookingId;
  }

  public PaymentCallbackRequest transactionAmount(Double transactionAmount) {
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

  public PaymentCallbackRequest status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  */
  @NotNull 
  @Schema(name = "status", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("status")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentCallbackRequest paymentCallbackRequest = (PaymentCallbackRequest) o;
    return Objects.equals(this.paymentId, paymentCallbackRequest.paymentId) &&
        Objects.equals(this.bookingId, paymentCallbackRequest.bookingId) &&
        Objects.equals(this.transactionAmount, paymentCallbackRequest.transactionAmount) &&
        Objects.equals(this.status, paymentCallbackRequest.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(paymentId, bookingId, transactionAmount, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentCallbackRequest {\n");
    sb.append("    paymentId: ").append(toIndentedString(paymentId)).append("\n");
    sb.append("    bookingId: ").append(toIndentedString(bookingId)).append("\n");
    sb.append("    transactionAmount: ").append(toIndentedString(transactionAmount)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

