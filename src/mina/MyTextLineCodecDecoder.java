package mina;
import java.nio.charset.Charset;

import org.apache.log4j.Logger;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;


/**
 * @author qh
 * 自定义文本解码器 
 */
public class MyTextLineCodecDecoder implements ProtocolDecoder{
   
	private Logger logger = Logger.getLogger(MyTextLineCodecDecoder.class);
	//字符编码类型
	private Charset charset = Charset.forName("UTF-8");
	//设置数据存放的IoBuffer大小
	private IoBuffer ioBuffer = IoBuffer.allocate(1024).setAutoExpand(true);
	@Override
	public void decode(IoSession session, IoBuffer in, ProtocolDecoderOutput out)
			throws Exception {
		logger.info("开始解码...........");
		while(in.hasRemaining()){
			byte by = in.get();
			//将数据存放到IoBuffer中
			ioBuffer.put(by);
			//数据解码结束标记
			if(by == '\n'){
				ioBuffer.flip();
				byte[] b = new byte[ioBuffer.limit()];
				ioBuffer.get(b);
				String msg = new String(b,charset);
				//重置ioBuffer
				ioBuffer = IoBuffer.allocate(100).setAutoExpand(true);
				out.write(msg);
			}
		}
	}

	@Override
	public void dispose(IoSession arg0) throws Exception {		
	}

	@Override
	public void finishDecode(IoSession arg0, ProtocolDecoderOutput arg1)
			throws Exception {
		logger.info("解码已完成......");
	}

}
