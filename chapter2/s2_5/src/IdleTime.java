import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-13
 * Time: 下午8:21
 * To change this template use File | Settings | File Templates.
 */
public class IdleTime {
    private static class Job implements Comparable<Job>
    {
        int startTime;
        int endTime;
        public Job(int s, int e)
        {
            startTime = s;
            endTime = e;
        }
        public int compareTo(Job that)
        {
            return startTime - that.startTime;
        }
        public String toString()
        {
            return startTime + " " + endTime;
        }
    }
    public static void main(String[] args)
    {
        int N = StdIn.readInt();
        Job[] jobs = new Job[N];
        for (int i = 0; i < N; ++i)
        {
            int s = StdIn.readInt();
            int e = StdIn.readInt();
            jobs[i] = new Job(s, e);
        }
        Arrays.sort(jobs);
        StdOut.println(Arrays.toString(jobs));
        int maxIdle = 0;
        int maxBusy = 0;
        int bS = 0;
        int bE = 0;
        for(int i = 0; i < N; ++i)
        {
            if(jobs[i].startTime > bE)
            {
                if(bE - bS > maxBusy)
                    maxBusy = bE - bS;
                if(jobs[i].startTime - bE > maxIdle)
                    maxIdle = jobs[i].startTime -bE;
                bS = jobs[i].startTime;
                bE = jobs[i].endTime;
            }else if(jobs[i].endTime > bE)
            {
                bE = jobs[i].endTime;
            }
        }
        if(maxBusy < bE - bS)
            maxBusy = bE - bS;
        StdOut.println(maxBusy + " " + maxIdle);
    }
}
