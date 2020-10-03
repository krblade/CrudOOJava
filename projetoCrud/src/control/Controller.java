package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Cliente;
import persistence.ClienteDao;


@WebServlet("/Controller")
public class Controller extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
 
  //Link <a href=
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	   if(request.getParameter("cmd")!=null) {
		   String cmd = request.getParameter("cmd");
		   if(cmd.equals("excluir")) {
			   excluir(request, response);   
		   }
		   else if(cmd.equals("editar")) {
			   editar(request,response);
		   }
	   }
	   
	
	}

	
	
	
	
	
	//Formulario é push
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String cmd = request.getParameter("cmd");
		
	    if(cmd.equals("gravar")) {
	    	gravar(request,response);
	    }else if(cmd.equals("alterar")){
	    	alterar(request, response);
	    }
	}
	
	
	
     protected void gravar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  //aqui será feito o gravar...
		 Cliente c = new Cliente(null,
				 request.getParameter("nome"),
				 request.getParameter("email"),
				 request.getParameter("imagem")
				 );
    	 try {
    		 new ClienteDao().create(c);
    		 request.setAttribute("msg", "Dados Gravados");
    		 
    	 }catch (Exception ex) {
    		 request.setAttribute("msg", "Error:" + ex.getMessage());
    	 }
    	 request.getRequestDispatcher("sistema.jsp").forward(request, response);
	}

     protected void excluir (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		
    	 try {
  	       Integer id= new Integer(request.getParameter("id"));
  	       new ClienteDao().delete(id);
  	       
  	       request.setAttribute("msg", "Dados Excluidos");
    	 }catch(Exception ex){
    	 request.setAttribute("msg", "Error:" + ex.getMessage());
    	 }
  	     request.getRequestDispatcher("sistema.jsp").forward(request, response);
  	}
     
     
 	protected void alterar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
 		Cliente c = new Cliente( 
 				new Integer(request.getParameter("id")),
 		request.getParameter("nome"), 
 		request.getParameter("email"), 
 		request.getParameter("imagem")); 
 		   try { new ClienteDao().update(c); 
 		       request.setAttribute("msg", "Dados Alterados"); 
 		   }catch (Exception ex) { 
 			   ex.printStackTrace();
 			   request.setAttribute("msg", "Error:" + ex.getMessage());
 		 }
 		   request.getRequestDispatcher("sistema.jsp"). forward(request, response);
   	
     
     
    }
 	
 	protected void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
 		try {
 			Integer id = new Integer(request.getParameter("id"));
 			Cliente c = new ClienteDao().findByCode(id);
 			request.setAttribute("cliente", c);
 		}catch (Exception ex) {
 			request.setAttribute("msg", "Error:" +ex.getMessage());
 		}
 		request.getRequestDispatcher("editar.jsp").forward(request, response);
	
 	
}
}