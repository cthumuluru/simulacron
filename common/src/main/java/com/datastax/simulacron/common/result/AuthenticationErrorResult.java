package com.datastax.simulacron.common.result;

import com.fasterxml.jackson.annotation.JsonProperty;

import static com.datastax.oss.protocol.internal.ProtocolConstants.ErrorCode.AUTH_ERROR;

public class AuthenticationErrorResult extends ErrorResult {

  AuthenticationErrorResult(String errorMessage) {
    this(errorMessage, 0);
  }

  AuthenticationErrorResult(
      @JsonProperty(value = "message", required = true) String errorMessage,
      @JsonProperty("delay_in_ms") long delayInMs) {
    super(AUTH_ERROR, errorMessage, delayInMs);
  }
}
