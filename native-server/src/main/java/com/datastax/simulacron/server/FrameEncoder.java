package com.datastax.simulacron.server;

import com.datastax.oss.protocol.internal.Frame;
import com.datastax.oss.protocol.internal.FrameCodec;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

import java.util.List;

public class FrameEncoder extends MessageToMessageEncoder<Frame> {

  private final FrameCodec<ByteBuf> frameCodec;

  FrameEncoder(FrameCodec<ByteBuf> frameCodec) {
    this.frameCodec = frameCodec;
  }

  @Override
  protected void encode(ChannelHandlerContext ctx, Frame msg, List<Object> out) throws Exception {
    out.add(frameCodec.encode(msg));
  }
}
