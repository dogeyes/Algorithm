/*************************************************************************
 *  Compilation:  javac BinaryDump.java
 *  Execution:    java BinaryDump N < file
 *  Dependencies: BinaryStdIn.java
 *  Data file:    http://introcs.cs.princeton.edu/stdlib/abra.txt
 *
 *  Reads in a binary file and writes out the bits, N per line.
 *
 *  % more abra.txt 
 *  ABRACADABRA!
 *
 *  % java BinaryDump 16 < abra.txt
 *  0100000101000010
 *  0101001001000001
 *  0100001101000001
 *  0100010001000001
 *  0100001001010010
 *  0100000100100001
 *  96 bits
 *
 *************************************************************************/

public class BinaryDump {

    public static void main(String[] args) {
        int BITS_PER_LINE = StdIn.readInt();

        BinaryIn in = new BinaryIn("binary.txt");
        int count;
        for (count = 0; !in.isEmpty(); count++) {
            if (BITS_PER_LINE == 0) { in.readBoolean(); continue; }
            else if (count != 0 && count % BITS_PER_LINE == 0) StdOut.println();
            if (in.readBoolean()) StdOut.print(1);
            else                           StdOut.print(0);
        }
        if (BITS_PER_LINE != 0) StdOut.println();
        StdOut.println(count + " bits");
    }
}
