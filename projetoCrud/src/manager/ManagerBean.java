package manager;

import java.util.List;

import entity.Cliente;
import persistence.ClienteDao;

public class ManagerBean {

	private List<Cliente> clientes;
	
	public List<Cliente> getClientes() {
	 
		try {
		     clientes= new ClienteDao().findAll();	
			
		}catch(Exception ex) {
			ex.printStackTrace();
			
		}
		
		return clientes;
		
	}
	
	public void setClientes(List<Cliente> clientes) {
		this.clientes =clientes;
	}
}
