package persistence;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import entity.Cliente;

public class ClienteDao extends Dao{
	
	
	public void create (Cliente c) throws Exception{
		open();
		stmt = con.prepareStatement
		("insert into cliente values(null,?,?,?)",
		PreparedStatement.RETURN_GENERATED_KEYS);
		stmt.setString(1, c.getNome());
		stmt.setString(2, c.getEmail());
		stmt.setString(3, c.getImage());
		stmt.executeUpdate();
		rs= stmt.getGeneratedKeys();
		rs.next();
		int chave = rs.getInt(1);
	  //cliente seta a chave primária para Atualizar
		c.setId(chave);
		close();
	}
	
	public List<Cliente> findAll() throws Exception {
		open();
		stmt = con.prepareStatement("select * from cliente");
		List<Cliente> lista = new ArrayList<Cliente>();
		rs= stmt.executeQuery();
		
		while(rs.next()) {
			Cliente c = new Cliente(rs.getInt(1),
			rs.getString(2),
			rs.getString(3),
			rs.getString(4));
		lista.add(c);
			
	}
		close();
		return lista;
	}

	public Cliente findByCode(Integer cod) throws Exception {
		open();
		stmt = con.prepareStatement
				("select * from cliente where id=?");
		stmt.setInt(1, cod);
	    rs = stmt.executeQuery();
		 Cliente c = null;
		if(rs.next()) {
			c = new Cliente(rs.getInt(1),
			rs.getString(2),
			rs.getString(3),
			rs.getString(4));
		
			
	}
		close();
		return c;
	}
	
	
	public void update (Cliente c) throws Exception{
		open();
		stmt = con.prepareStatement
	("update cliente set nome=?,email=?,imagem=? where id=?");
		
		stmt.setString(1, c.getNome());
		stmt.setString(2, c.getEmail());
		stmt.setString(3, c.getImage());
		stmt.setInt(4, c.getId());
		stmt.executeUpdate();	
		close();
	}
		
	
	public void delete(Integer id) throws Exception {
		open();
		stmt= con.prepareStatement
	    ("delete from cliente where id=?");
					stmt.setInt(1, id);
					stmt.execute();
					close();
	}
	
	
	
}
