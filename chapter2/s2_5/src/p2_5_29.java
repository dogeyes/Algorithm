import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-14
 * Time: 下午1:21
 * To change this template use File | Settings | File Templates.
 */
public class p2_5_29 {
    public static void main(String[] args)
    {
        File f = new File(args[0]);
        if(f.isDirectory())
        {
            File[] fs = f.listFiles();
            Arrays.sort(fs, new SizeAscendCompator());
            for(File ff : fs)
            {
                StdOut.println(ff + " " + ff.length());
            }
        }
    }
}

class SizeDescendCompator implements Comparator<File>
{
    public int compare(File f1, File f2)
    {
        if(f1.length() < f2.length())
            return  - 1;
        if(f1.length() > f2.length())
            return 1;
        return 0;
    }
}
class SizeAscendCompator implements Comparator<File>
{
    public int compare(File f1, File f2)
    {
        if(f1.length() > f2.length())
            return  - 1;
        if(f1.length() < f2.length())
            return 1;
        return 0;
    }
}
class DateDescendCompator implements Comparator<File>
{
    public int compare(File f1, File f2)
    {
        if(f1.lastModified() > f2.lastModified())
            return 1;
        if(f1.lastModified() < f2.lastModified())
            return -1;
        return 0;
    }
}
class DateAscendCompator implements Comparator<File>
{
    public int compare(File f1, File f2)
    {
        if(f1.lastModified() < f2.lastModified())
            return 1;
        if(f1.lastModified() > f2.lastModified())
            return -1;
        return 0;
    }
}
