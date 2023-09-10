public class GenericExample<T>
{
	private T typeObj;
	{
	}

	GenericExample(T newObj)
	{
		typeObj = newObj;
	}

	public T getObject()
	{
		return typeObj;
	}

	public void setObject(T newObj)
	{
		typeObj = newObj;
	}
}

