import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: ssm
 * @description:
 * @author: liust
 * @create: 2018-11-21 13:17
 **/
public class Service1 {
    @Test
    public void doService1() throws Exception {
        FileInputStream fileInputStream=new FileInputStream("src/nio.txt");
        FileChannel fileChannel=fileInputStream.getChannel();
        ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
        fileChannel.read(byteBuffer);
        byteBuffer.flip();
        while (byteBuffer.hasRemaining()){
            byte b=byteBuffer.get();
            System.out.print((char) b);
        }
    }
    @Test
    public void doService2() {
        System.out.println(3<<1);
    }
}
