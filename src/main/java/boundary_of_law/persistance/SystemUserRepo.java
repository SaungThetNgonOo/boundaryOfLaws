package boundary_of_law.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import boundary_of_law.models.SystemUser;

public class SystemUserRepo {
	public static Connection con = null;
	static {
		con = MyConnection.getConnection();
	}
	//insert
	public int add(SystemUser systemuser) {
		int result=0;
		String sql="INSERT INTO systemUser(id,name,password,email,phone) VALUES (?,?,?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,systemuser.getId());
			ps.setString(2, systemuser.getName());
			ps.setString(3, systemuser.getPassword());
			ps.setString(4, systemuser.getEmail());
			ps.setString(5, systemuser.getPhone());
			result=ps.executeUpdate();
		}catch(SQLException e) {
			result=0;
			System.out.println("systemUser insert err: "+e);
		}
		return result;
	}
	
	//update
	public int edit(SystemUser systemuser) {
		int result=0;
		String sql="UPDATE systemUser SET name=?, password=?, email=?, phone=? WHERE id=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, systemuser.getName());
			ps.setString(2, systemuser.getPassword());
			ps.setString(3, systemuser.getEmail());
			ps.setString(4, systemuser.getPhone());
			
			ps.setInt(5, systemuser.getId());
			
			result=ps.executeUpdate();
		}catch(SQLException e) {
			result=0;
			System.out.println("systemUser edit err: "+e);
		}
		return result;
	}
	
	//delete
		public int delete(int id) {
			int result=0;
			String sql="DELETE FROM systemUser WHERE id=?";
			try {
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setInt(1, id);
				result=ps.executeUpdate();
				
			}catch(SQLException e) {
				result=0;
				System.out.println("systemUser delete err: "+e);
			}
			return result;
		}
		
		//getAll
		public List<SystemUser>getAll(){
			List<SystemUser> systemusers=new ArrayList<>();
			String sql="SELECT * FROM systemUser";
			try {
				PreparedStatement ps=con.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					SystemUser systemuser=new SystemUser();
					systemuser.setId(rs.getInt("id"));
					systemuser.setName(rs.getString("name"));
					systemuser.setPassword(rs.getString("password"));
					systemuser.setEmail(rs.getString("email"));
					systemuser.setPhone(rs.getString("phone"));
					systemusers.add(systemuser);
				}
				
			}catch(SQLException e) {
				System.out.println("systemUser selec err: "+e);
			}
			return systemusers;
		}
		
		//getByCode == getOne
		public SystemUser getById(int id) {
			SystemUser systemuser=null;//initially null
			String sql="SELECT * FROM systemUser WHERE id=?";
			try {
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setInt(1, id);
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					systemuser=new SystemUser();
					systemuser.setId(rs.getInt("id"));
					systemuser.setName(rs.getString("name"));
					systemuser.setPassword(rs.getString("password"));
					systemuser.setEmail(rs.getString("email"));
					systemuser.setPhone(rs.getString("phone"));
				}
				
			}catch(SQLException e) {
				System.out.println("systemUser getByCode err: "+e);
			}
			return systemuser;
		}
		//GetNameByBookCode
//		public List<Author> getAuthorsByBookCode(String code) {
//			List<Author> authors=new ArrayList<>();
//			String sql="SELECT a.* FROM author a inner join book_has_author ba on a.id=ba.author_id where ba.book_code=?";
//			try {
//				PreparedStatement ps=con.prepareStatement(sql);
//				ps.setString(1, code);
//				ResultSet rs=ps.executeQuery();
//				while(rs.next()) {
//					Author author=new Author();
//					author.setId(rs.getInt("id"));
//					author.setName(rs.getString("name"));
//					author.setAddress(rs.getString("address"));
//					author.setCopyright_contact(rs.getString("copyright_contact"));
//					author.setContact_email(rs.getString("contact_email"));
//					authors.add(author);
//				}
//				
//			}catch(SQLException e) {
//				System.out.println("author getAuthorsByBookCode err: "+e);
//			}
//			return authors;
//		}
}
