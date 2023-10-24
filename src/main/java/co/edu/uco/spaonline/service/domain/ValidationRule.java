package co.edu.uco.spaonline.service.domain;

public interface ValidationRule<T> {
	void validar (T dato);
}
