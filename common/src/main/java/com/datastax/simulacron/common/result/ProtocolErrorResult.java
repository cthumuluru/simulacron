package com.datastax.simulacron.common.result;

import com.fasterxml.jackson.annotation.JsonProperty;

import static com.datastax.oss.protocol.internal.ProtocolConstants.ErrorCode.PROTOCOL_ERROR;

public class ProtocolErrorResult extends ErrorResult {

  ProtocolErrorResult(String errorMessage) {
    this(errorMessage, 0);
  }

  ProtocolErrorResult(
      @JsonProperty(value = "message", required = true) String errorMessage,
      @JsonProperty("delay_in_ms") long delayInMs) {
    super(PROTOCOL_ERROR, errorMessage, delayInMs);
  }
}