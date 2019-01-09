import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Scanner;

/**
 * @program: ssm
 * @description:
 * @author: zx
 * @create: 2019-01-09 15:33
 **/
public class Client {
    public static void main(String[] args){
        System.out.println("客户端已启动...");
        try(SocketChannel socketChannel=SocketChannel.open(new InetSocketAddress("127.0.0.1",9999))) {
            socketChannel.configureBlocking(false);
            ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
            Scanner scanner=new Scanner(System.in);
            System.out.println("请输入内容:");
            while (scanner.hasNext()){
                System.out.println("请输入内容：");
                String data=new Date().toString()+" "+scanner.next();
                byteBuffer.put(data.getBytes());
                byteBuffer.flip();
                socketChannel.write(byteBuffer);
                byteBuffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
