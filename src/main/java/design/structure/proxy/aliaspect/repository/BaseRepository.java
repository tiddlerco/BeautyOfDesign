package design.structure.proxy.aliaspect.repository;

public interface BaseRepository<T, PK> {

	void add(T t) throws Exception;
	
	void update(T t) throws Exception;
	
	void remove(T t);
	
}
