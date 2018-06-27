package br.com.fiap.interfaces;

import java.util.List;

public interface ICrud<T> {
	int Insert(T item);
	int Update(T item);
	int Delete(int id);
	List<T> GetAll();
	T GetBy(int id);
}