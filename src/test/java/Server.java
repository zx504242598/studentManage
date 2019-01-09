import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @program: ssm
 * @description:
 * @author: zx
 * @create: 2019-01-09 15:14
 **/
public class Server {
    public static void main(String[] args){
        try(ServerSocketChannel serverSocketChannel=ServerSocketChannel.open()){
            System.out.println("服务器已启动...");
            serverSocketChannel.socket().bind(new InetSocketAddress(9999));
            serverSocketChannel.configureBlocking(false);
            Selector selector=Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            while (selector.select()>0){
                Iterator<SelectionKey> iterator=selector.selectedKeys().iterator();
                while (iterator.hasNext()){
                    SelectionKey key=iterator.next();
                    if (key.isAcceptable()){
                        SocketChannel socketChannel=serverSocketChannel.accept();
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector,SelectionKey.OP_READ);
                    }else if (key.isReadable()){
                        SocketChannel socketChannel=(SocketChannel) key.channel();
                        ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
                        int len=0;
                        while ((len=socketChannel.read(byteBuffer))!=-1){
                            byteBuffer.flip();
                            System.out.println(new String(byteBuffer.array(),0,len));
                            byteBuffer.clear();
                        }
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
