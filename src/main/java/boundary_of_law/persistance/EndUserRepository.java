package boundary_of_law.persistance;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import boundary_of_law.models.EndUser;


public class EndUserRepository {

	
	public static Connection con = null;
	static {
		con = MyConnection.getConnection();
	}

	// insert
	public int add(EndUser enduser) {
		int result = 0;
		String sql = "INSERT INTO enduser(name,email,password,phone,NRC,current_state,gender,status)VALUES(?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, enduser.getName());
			ps.setString(2,  enduser.getEmail());
			ps.setString(3,  enduser.getPassword());
			ps.setString(4,  enduser.getPhone());
			ps.setString(5, enduser.getNRC());
			ps.setString(6, enduser.getCurrent_state());
			ps.setString(7, enduser.getGender());
			ps.setString(8, enduser.getStatus());
			

			result = ps.executeUpdate();

		} catch (SQLException e) {
			result = 0;
			System.out.println("enduser insert error :  " + e);
		}
		return result;

	}

	// Update
	public int edit(EndUser enduser) {
		int result = 0;
		String sql = "UPDATE  enduser SET name=?,email=?,password=?,phone=?,NRC=?,current_state=?,gender?,cases=?,type=?,where id=";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, enduser.getName());
			ps.setString(2,  enduser.getEmail());
			ps.setString(3,  enduser.getPassword());
			ps.setString(4,  enduser.getPhone());
			ps.setString(5, enduser.getNRC());
			ps.setString(6, enduser.getCurrent_state());
			ps.setString(7, enduser.getGender());
			
			
			ps.setInt(10, enduser.getId());
			
			

			result = ps.executeUpdate();

		} catch (SQLException e) {
			result = 0;
			System.out.println("enduser edit error :  " + e);
		}
		return result;

	}

//delete
	public int delete(int id) {
		int result = 0;
		String sql = "DELETE FROM endUser WHERE id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			result = ps.executeUpdate();

		} catch (SQLException e) {
			result = 0;

		}
		return result;

	}// getAll

	public List<EndUser> getAll() {
		
		List<EndUser> endusers = new ArrayList<>();
		String sql = "SELECT *FROM endUser";

		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				EndUser enduser= new EndUser();
				enduser.setId(rs.getInt("id"));
				enduser.setName(rs.getString("name"));
				enduser.setEmail(rs.getString("email"));
				enduser.setPassword(rs.getString("password"));
				enduser.setPhone(rs.getString("phone"));
				enduser.setNRC(rs.getString("NRC"));
				enduser.setCurrent_state(rs.getString("current_state"));
				enduser.setGender(rs.getString("gender"));
				
				
				endusers.add(enduser);
			}
		} catch (SQLException e) {
			System.out.println("enduser select error :  " + e);
			return endusers;
		}
		return endusers;
	}
	
	// getone

	public EndUser getById(int id) {
		EndUser enduser = null;
		String sql = "SELECT *FROM endUser WHERE id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				 enduser= new EndUser();
				enduser.setId(rs.getInt("id"));
				enduser.setName(rs.getString("name"));
				enduser.setEmail(rs.getString("email"));
				enduser.setPassword(rs.getString("password"));
				enduser.setPhone(rs.getString("phone"));
				enduser.setNRC(rs.getString("NRC"));
				enduser.setCurrent_state(rs.getString("current_state"));
				enduser.setGender(rs.getString("gender"));
		

			}
		} catch (SQLException e) {
			enduser = null;

			System.out.println("enduser getByCode error :  " + e);

		}
		return enduser;

	}
	}


