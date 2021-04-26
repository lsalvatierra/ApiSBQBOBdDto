package com.qbo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.qbo.model.security.*;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@Query(value = "{call sp_AutenticarUsuario(:usuario, :password)}",
			nativeQuery = true)
	public Optional<Usuario> autenticarUsuario(
			@Param("usuario")String usuario,
			@Param("password")String password);
	
}
