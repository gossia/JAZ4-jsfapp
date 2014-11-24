package repositories;

import java.util.List;
import domain.Entity;

public interface IRepository<TEntity extends Entity> {
	
	public void add(TEntity entity);
	public void update(TEntity entity);
	public void delete(TEntity entity);
	public TEntity get(int id);
	public List<TEntity> getAll();
	
}
