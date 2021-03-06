package br.com.fiap.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.fiap.viewmodel.EscolaCurso;

public class EscolaCursoMapper  implements RowMapper<EscolaCurso>{
	@Override
	public EscolaCurso mapRow(ResultSet rs, int arg1) throws
	SQLException {
		EscolaCurso vm = new EscolaCurso();
	 vm.setDescricao(rs.getString("DESCRICAO"));
	 vm.setNumCursos(rs.getInt("NUMCURSOS"));
	 return vm;
	 } 

}
