package feng.Q_IO.H_标准IO;

import java.io.IOException;
import java.io.PrintWriter;

public class ChangeSystemOut {
    public static void main(String[] args)  throws IOException {
        PrintWriter out = new PrintWriter(System.out, true);
        out.println("Hello , World");

    }
}
