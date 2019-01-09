import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


/**
 * @program: ssm
 * @description:
 * @author: liust
 * @create: 2018-11-21 13:17
 **/
public class Service1 {
    @Test
    public void doService1() throws Exception {
        try(RandomAccessFile ra=new RandomAccessFile("src/nio.txt","rw"); FileChannel fc=ra.getChannel();
        ){
            ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
            String data="New String to write to file..." + System.currentTimeMillis();
            byteBuffer.put(data.getBytes());
            byteBuffer.flip();
            fc.write(byteBuffer);

            while (fc.read(byteBuffer)!=-1) {
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()){
                    System.out.print((char) byteBuffer.get());
                }
                byteBuffer.clear();
            }
        }
    }
    @Test
    public void doService2() {
        try(FileInputStream fileInputStream=new FileInputStream("src/nio.txt"); FileWriter fileWriter=new FileWriter("src/qqq.txt")){
            InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
            char[] chars=new char[2];
            while (inputStreamReader.read(chars)!=-1){
                for (char c:chars){
                    fileWriter.write(c);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
