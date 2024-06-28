package boundary_of_law.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import boundary_of_law.models.Lawer;

public class LawerRepository {

	//connection
			public static Connection con=null;
			static {
				con=MyConnection.getConnection();		//class level element//connecton chait	
			}
			//crud
			//create//insert
			public int add(Lawer lawer) {
		        int result = 0;
		        String sql = "INSERT INTO lawer(name, email, password, NRC, phone, gender, current_state, price, photo, status, case_type_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		        try {
		            PreparedStatement ps = con.prepareStatement(sql);
		            ps.setString(1, lawer.getName());
		            ps.setString(2, lawer.getEmail());
		            ps.setString(3, lawer.getPassword());
		            ps.setString(4, lawer.getNRC());
		            ps.setString(5, lawer.getPhone());
		            ps.setString(6, lawer.getGender());
		            ps.setString(7, lawer.getCurrent_state());
		            ps.setDouble(8, lawer.getPrice());
		            ps.setString(9, lawer.getPhoto());
		            ps.setString(10, lawer.getStatus());
		            ps.setInt(11, lawer.getCase_type_id());

		            result = ps.executeUpdate();
		        } catch (SQLException e) {
		            System.out.println("lawer insert error: " + e);
		            result = 0;
		        }
		        return result;
		    }
		
			//Update
			public int edit(Lawer lawer) {
				int result=0;
				String sql="UPDATE lawer SET name=?,email=?,password=?,NRC=?,phone=?,gender=?,current_state=?,price=?,photo=?,status=?,case_type_id=? where id=?";
				try {
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setString(1, lawer.getName());
					ps.setString(2, lawer.getEmail());
					ps.setString(3, lawer.getPassword());
					ps.setString(4, lawer.getNRC());
					ps.setString(5, lawer.getPhone());
					ps.setString(6, lawer.getGender());
					ps.setString(7, lawer.getCurrent_state());
					ps.setDouble(8, lawer.getPrice());
					ps.setString(9, lawer.getPhoto());
					ps.setString(10, lawer.getStatus());
					ps.setInt(11, lawer.getCase_type_id());
					
					result=ps.executeUpdate();	
					
				}catch(SQLException e) {
					System.out.println("lawer edit err: "+e);
					result=0;
				}
				return result;
			}
			//delete
			public int delete(int id) {
				int result=0;
				String sql="DELETE FROM lawer WHERE id=?";
				try {
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setInt(1, id);
					result=ps.executeUpdate();
					
					
				}catch(SQLException e) {
					System.out.println("lawer delete err: "+e);
					result=0;
				}
				return result;
			}
			
			//getAll//select
			public List<Lawer> getAll() {
				List<Lawer> lawers = new ArrayList<>();

				String sql = "SELECT l.*,c.name as case_type_name FROM lawer l INNER JOIN case_type c ON l.case_type_id=c.id";
				try {
					PreparedStatement ps = con.prepareStatement(sql);
					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
						Lawer lawer = new Lawer();
						
						lawer.setId(rs.getInt("id"));
						lawer.setName(rs.getString("name"));
						lawer.setEmail(rs.getString("email"));
						lawer.setPassword(rs.getString("password"));
						lawer.setNRC(rs.getString("NRC"));
						lawer.setPhone(rs.getString("phone"));
						lawer.setGender(rs.getString("gender"));
						lawer.setCurrent_state(rs.getString("current_state"));
						lawer.setPrice(rs.getDouble("price"));
						lawer.setPhoto(rs.getString("photo"));
						lawer.setStatus(rs.getString("status"));
						lawer.setCase_type_id(rs.getInt("case_type_id"));
						lawer.setCase_type_name(rs.getString("case_type_name"));
						
						lawers.add(lawer);
					}

				} catch (SQLException e) {
					System.out.println("lawer select err: " + e);
				}

				return lawers;
			}
			//getOne ById//select
			public Lawer getById(int id) {
				Lawer lawer = null;
				String sql = "SELECT * FROM lawer WHERE id=?";
				try {
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setInt(1, id);
					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
						lawer = new Lawer();
						lawer.setId(rs.getInt("id"));
						lawer.setName(rs.getString("name"));
						lawer.setEmail(rs.getString("email"));
						lawer.setPassword(rs.getString("password"));
						lawer.setNRC(rs.getString("NRC"));
						lawer.setPhone(rs.getString("phone"));
						lawer.setGender(rs.getString("gender"));
						lawer.setCurrent_state(rs.getString("current_state"));
						lawer.setPrice(rs.getDouble("price"));
						lawer.setPhoto(rs.getString("photo"));
						lawer.setStatus(rs.getString("status"));
						lawer.setCase_type_id(rs.getInt("case_type_id"));
					

					}

				} catch (SQLException e) {
					lawer = null;
					System.out.println("lawer getById err: " + e);
				}

				return lawer;
			}
}
