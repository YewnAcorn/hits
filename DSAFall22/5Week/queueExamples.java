Stack stack = new Stack();
while (!queue.isEmpty())
	stack.push(queue.dequeue());
while (!stack.isEmpty())
	queue.enqueue(stack.pop());


IntQueue q = new IntQueue();
q.enqueue(0);
q.enqueue(1);
for (int i = 0; i < 10; ++i)
{
	int a = q.dequeue();
	int b = q.dequeue();
	q.enqueue(b);
	q.enqueue(a + b);
	System.out.println(a);
}

