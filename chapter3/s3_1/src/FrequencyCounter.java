/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-12-16
 * Time: 下午1:18
 * To change this template use File | Settings | File Templates.
 */
public class FrequencyCounter {
    public static void main(String[] args)
    {
        int minlen = Integer.parseInt(args[0]);
        SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
        In in = new In(args[1]);
        String lastWord = "";
        int num = 0, count = 0;
        while (!in.isEmpty())
        {
            String word = in.readString();
            count++;
            if(word.length() < minlen) continue;
            if(st.contains(word)) st.put(word, st.get(word) + 1);
            else {
                st.put(word, 1);
                lastWord = word;
                num = count;
            }
        }
        String max = "";
        st.put(max, 0);
        for(String word: st.keys())
            if(st.get(word) > st.get(max))
                max = word;

        for(String word: st.keys())
            if(st.get(word) == st.get(max))
                StdOut.println(word);
        StdOut.println(num + "/" + count + " " + lastWord);
    }
}
