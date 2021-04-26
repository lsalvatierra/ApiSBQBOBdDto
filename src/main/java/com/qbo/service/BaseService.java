package com.qbo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public interface BaseService<E> {
	
    public List<E> obtenerTodo();
    public Optional<E> obtenerPorId(Long id);
    public E guardar(E entity);
    public HashMap<String, String> eliminarPorId(Long id);
}
