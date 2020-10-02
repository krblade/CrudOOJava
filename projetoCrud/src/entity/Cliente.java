package entity;

import java.io.Serializable;

public class Cliente implements Serializable{


	private static final long serialVersionUID = 1L;
		private Integer id;
		private String nome;
		private String email;
		private String image;
		
		
		public Cliente() {
			// TODO Auto-generated constructor stub
		}
		
		
		
		
		public Cliente(Integer id, String nome, String email, String image) {
			super();
			this.id = id;
			this.nome = nome;
			this.email = email;
			this.image = image;
		}




		@Override
		public String toString() {
			return "Cliente [id=" + id + ", nome=" + nome + ", email=" + email + ", image=" + image + "]";
		}




		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}
		
		
		
	
	
}
