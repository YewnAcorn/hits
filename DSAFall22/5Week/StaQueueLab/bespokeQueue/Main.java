public class Main
{
	public static void main(String args[])
	{
		myQueue q = new myQueue();
		q.enqueue(0);
		q.enqueue(1);

		for(int i = 0; i < 10; ++i)
		{
			int a = q.dequeue();
			int b = q.dequeue();
			q.enqueue(b);
			q.enqueue(a + b);
			System.out.println(a);

		}
		System.out.println("testing: ");

		StaticQueue sq = new StaticQueue(5);
		sq.enqueue("test1");
		sq.enqueue("test2");
		sq.enqueue("test3");
		sq.enqueue("test4");
		sq.enqueue("test5");
		System.out.println(sq.dequeue());
		System.out.println(sq.dequeue());
		System.out.println(sq.dequeue());
		System.out.println(sq.dequeue());
		sq.clear();
		System.out.println(sq.dequeue());
		System.out.println(sq.isEmpty());
		sq.enqueue("test");
		System.out.println(sq.isEmpty());
		
	}
}


