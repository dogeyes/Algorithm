/**
 * Created with IntelliJ IDEA.
 * User: dexctor
 * Date: 12-11-25
 * Time: 下午1:16
 * To change this template use File | Settings | File Templates.
 */
public class p1_3_49 {
    public static void main(String[] args)
    {
        QueueWithStacks<Integer> queue = new QueueWithStacks<Integer>();
        for(int i = 0; i < 10; ++i)
        {
            queue.enqueue(i);
        }
        for(int i = 0; i < 5; i++)
            StdOut.print(queue.dequeue() + " ");
        for(int i = 10; i < 20; ++i)
            queue.enqueue(i);
        for(int i = 0; i < 10; ++i)
            StdOut.print(queue.dequeue() + " ");
        for(int i = 20; i < 40; ++i)
            queue.enqueue(i);
        while (!queue.isEmpty())
            StdOut.print(queue.dequeue() + " ");
    }
}

class QueueWithStacks<Item>
{
    private Stack<Item> stack1;
    private Stack<Item> stack2;
    public QueueWithStacks()
    {
        stack1 = new Stack<Item>();
        stack2 = new Stack<Item>();
    }
    public boolean isEmpty()
    {
        return stack1.isEmpty() && stack2.isEmpty();
    }
    public int size()
    {
        return stack1.size() + stack2.size();
    }
    public Item dequeue()
    {
        if(isEmpty())
            return null;
        if(stack2.isEmpty())
        {
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
    public void enqueue(Item item)
    {
        stack1.push(item);
    }

}
