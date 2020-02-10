// 서버와 입출력 테스트 - byte Stream : 데이터 주고 받기 II
package com.eomcs.net.ex03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client0140 {
  public static void main(String[] args) {
    Scanner keyScan = new Scanner(System.in);
    try (Socket socket = new Socket("localhost", 8888);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        DataInputStream in = new DataInputStream(socket.getInputStream())) {

      System.out.println("서버와 연결되었음!");

      System.out.print(">");
      keyScan.nextLine();

      // 서버에 data 값을 전송
      out.writeInt(1567891234);
      out.writeByte(100);
      out.writeFloat(3.14f);
      out.writeUTF("ABC가각간");
      // out.flush();
      // byte Stream 을 사용할 때는 바로 출력한다.
      // 따라서 flush()를 호출하지 않아도된다

      System.out.println("서버에 데이터를 보냈음!");

      int value = in.readInt();
      byte value2 = in.readByte();
      float value3 = in.readFloat();
      String value4 = in.readUTF();
      System.out.printf("%d %d %f %s\n", value, value2, value3, value4);

    } catch (Exception e) {
      e.printStackTrace();
    }
    keyScan.close();
  }
}


