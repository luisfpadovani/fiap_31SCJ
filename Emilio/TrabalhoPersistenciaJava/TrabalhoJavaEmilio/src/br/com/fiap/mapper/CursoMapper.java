package br.com.fiap.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.fiap.entidade.Curso; 

public class CursoMapper implements RowMapper<Curso> {

	@Override
	public Curso mapRow(ResultSet rs, int arg1) throws SQLException {
		Curso curso = new Curso();
		curso.setId(rs.getInt("ID"));
		curso.setDescricao(rs.getString("DESCRICAO"));
		curso.setNome(rs.getString("NOME"));
		return curso;
	}

}