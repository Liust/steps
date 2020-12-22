package com.liust.jd.msb.sysio.single.upgrade;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Server {
    public static final int bufferSize = 4096;
    ServerSocketChannel serverSocketChannel;

    public void init() throws Exception{
        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress("127.0.0.1", 9090));

    }

    public static void main(String[] args) throws Exception{
        try {
            Server server = new Server();
            server.init();

            List<SocketChannel> clientList = new LinkedList<>();

            while (true) {
                final SocketChannel channel = server.serverSocketChannel.accept();
                if (channel != null) {
//                    channel.configureBlocking(true);
                    clientList.add(channel);

                    ByteBuffer buffer = ByteBuffer.allocate(bufferSize);
//                ByteBuffer buffer = ByteBuffer.allocateDirect(bufferSize);

                    for (SocketChannel client: clientList ) {
                        int num = 0;
                        buffer.clear();
                        while ((num = client.read(buffer)) >= 0) {
                            if (num > 0) {
                                buffer.flip();
                                byte[] data = new byte[buffer.limit()];
                                buffer.get(data);
                                String s = new String(data);
                                System.out.println(s + " : from :" + client.socket().getPort());
                                // data
                            } else if (num == 0) {
                                System.out.println(" read over :" + client.socket().getPort());
                                break;

                            } else if (num == -1) {//-1 client closed
                                clientList.remove(client);
                                client.close();
                                System.out.println(" client closed :" + client.socket().getPort());
                                break;
                            }

                        }

                    }

                }

                TimeUnit.SECONDS.sleep(1);
//                System.out.println("-------server round ------------");

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
