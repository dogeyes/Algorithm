import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-13
 * Time: 下午4:10
 * To change this template use File | Settings | File Templates.
 *
 * shortest processing time first rule
 */
public class Scheduling {
    private static class Job implements Comparable<Job>
    {
        private String name;
        private double time;
        public Job(String name, double time)
        {
            this.name = name;
            this.time = time;
        }
        public int compareTo(Job that)
        {
            if(time < that.time)
                return -1;
            else if(time > that.time)
                return 1;
            else
                return 0;
        }
        public String toString()
        {
            return name + " : " + time;
        }
    }
    public static void main(String[] args)
    {
        int N = StdIn.readInt();
        Job[] jobs = new Job[N];
        for(int i = 0; i < N; ++i)
        {
            String name = StdIn.readString();
            double time = StdIn.readDouble();
            jobs[i] = new Job(name, time);
        }
        Arrays.sort(jobs);
        double sum = 0;
        for(int i = 0; i < N; ++i)
        {
            sum += sum + jobs[i].time;
        }
        StdOut.println(Arrays.toString(jobs));
        StdOut.println(sum / N);
    }
}
