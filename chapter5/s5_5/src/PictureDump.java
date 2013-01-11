/*************************************************************************
 *  Compilation:  javac PictureDump.java
 *  Execution:    java PictureDump width height < file
 *  Dependencies: BinaryStdIn.java Picture.java
 *  Data file:    http://introcs.cs.princeton.edu/stdlib/abra.txt
 *
 *  Reads in a binary file and writes out the bits as w-by-h picture,
 *  with the 1 bits in black and the 0 bits in white.
 *
 *  % more abra.txt
 *  ABRACADABRA!
 *
 *  % java PictureDump 16 6 < abra.txt
 *
 *************************************************************************/
import java.awt.Color;

public class PictureDump {

    public static void main(String[] args) {
        int width = StdIn.readInt();
        int height = StdIn.readInt();
        BinaryIn in = new BinaryIn("binary.txt");
        Picture pic = new Picture(width, height);
        int count = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                pic.set(j, i, Color.RED);
                if (!in.isEmpty()) {
                    count++;
                    boolean bit = in.readBoolean();
                    if (bit) pic.set(j, i, Color.BLACK);
                    else     pic.set(j, i, Color.WHITE);
                }
            }
        }
        pic.show();
        StdOut.println(count + " bits");
    }
}
