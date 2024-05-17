package com.mktplace.api;

import com.mktplace.model.BookingRequest;
import com.mktplace.model.BookingResponse;
import com.mktplace.model.CheckoutRequest;
import com.mktplace.model.CheckoutResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@Controller
@RequestMapping("${openapi.mktplaceAppAPIs.base-path:/api/v1}")
public class BookingApiController implements BookingApi {

    private final BookingApiDelegate delegate;

    public BookingApiController(@Autowired(required = false) BookingApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new BookingApiDelegate() {});
    }

    @Override
    public BookingApiDelegate getDelegate() {
        return delegate;
    }

}
