package repository;

import domain.Entity;

public interface IRepository<TEntity extends Entity> {
	public void add(TEntity entity);
	public void delete(TEntity entity);

}
