package refactoring.console;

public interface Input<T> {
	public boolean isValid();
	public T asObject();
}
