package mina;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

import org.apache.log4j.Logger;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

/**
 * @author qh
 * 自定义文本编码器 
 */
public class MyTextLineCodecEncoder implements ProtocolEncoder{
	private Logger logger = Logger.getLogger(MyTextLineCodecEncoder.class);
	//字符编码类型
	private Charset charset = Charset.forName("UTF-8");
	@Override
	public void dispose(IoSession arg0) throws Exception {
		
	}

	@Override
	public void encode(IoSession arg0, Object obj, ProtocolEncoderOutput out)
			throws Exception {
		logger.info("开始编码...........");
		IoBuffer io = IoBuffer.allocate(100).setAutoExpand(true);
		CharsetEncoder ce = charset.newEncoder();
		io.putString(obj.toString(), ce);
		io.put((byte)'\r');
		io.put((byte)'\n');
		io.flip();
		out.write(io);
	}

}
