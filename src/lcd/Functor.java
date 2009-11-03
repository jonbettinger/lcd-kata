package lcd;

public interface Functor<I, O> {
	O invoke(I input);
}
