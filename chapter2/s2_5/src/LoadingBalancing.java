import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-13
 * Time: 下午4:18
 * To change this template use File | Settings | File Templates.
 */
public class LoadingBalancing {
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
    private static class Process implements Comparable<Process>
    {
        public double time;
        public int compareTo(Process that)
        {
            if(time < that.time)
                return -1;
            else if(time > that.time)
                return 1;
            else
                return 0;
        }
        public void add(Job job)
        {
            time += job.time;
        }
        public String toString()
        {
            return time + "";
        }
    }
    public static void main(String[] args)
    {
        int M = StdIn.readInt();
        MinPQ<Process> pq =new MinPQ<Process>(M);
        for(int i =0 ; i < M; ++i)
            pq.insert(new Process());
        int N = StdIn.readInt();
        Job[] jobs = new Job[N];
        for(int i = 0; i < N; ++i)
        {
            String name = StdIn.readString();
            double time = StdIn.readDouble();
            jobs[i] = new Job(name, time);
        }
        Arrays.sort(jobs);
        for(int i = N - 1; i >= 0; --i)
        {
            Process p = pq.delMin();
            p.add(jobs[i]);
            pq.insert(p);
        }
        while(!pq.isEmpty())
        {
            StdOut.println(pq.delMin());
        }
    }
}
