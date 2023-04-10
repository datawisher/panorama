package cn.datawisher.cyder.io;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AIOExample {

    public static void main(String[] args) throws Exception {
        Path path = Paths.get("test.txt");

        // 基于回调
        AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        long position = 0;
        fileChannel.read(buffer, position, buffer, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                System.out.println("Read " + result + " bytes");
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                System.out.println("Read failed: " + exc.getMessage());
            }
        });

        // 使用Future来等待异步读取完成
        Future<Integer> futureResult = fileChannel.read(buffer, position);
        try {
            Integer result = futureResult.get();
            System.out.println("Read " + result + " bytes");
        } catch (ExecutionException | InterruptedException e) {
            System.out.println("Read failed: " + e.getMessage());
        }
    }
}
