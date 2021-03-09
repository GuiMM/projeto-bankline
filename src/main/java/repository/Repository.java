package repository;

import java.util.List;

public interface Repository <E> {
	public void save(E e);
	public void update(E e);
	public void delete(Integer id);
	public List<E> list();
	public E find(Integer id);
}
