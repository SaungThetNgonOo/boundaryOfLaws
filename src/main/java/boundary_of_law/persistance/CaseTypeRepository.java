package boundary_of_law.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import boundary_of_law.models.CaseType;

public class CaseTypeRepository {

	public static Connection con=null;
	static {
		con=MyConnection.getConnection();		//class level element//connecton chait	
	}
	//getAll//select
			public List<CaseType> getAll() {
				List<CaseType> caseTypes = new ArrayList<>();

				String sql = "SELECT * FROM case_type";
				try {
					PreparedStatement ps = con.prepareStatement(sql);
					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
						CaseType caseType = new CaseType();
						caseType.setId(rs.getInt("id"));
						caseType.setName(rs.getString("name"));
						
						caseTypes.add(caseType);
					}

				} catch (SQLException e) {
					System.out.println("casetype select err: " + e);
				}

				return caseTypes;
			}

			//getOne ByCode//select
			public CaseType getById(int id) {
				CaseType caseType = null;
				String sql = "SELECT * FROM case_type WHERE id=?";
				try {
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setInt(1, id);
					ResultSet rs = ps.executeQuery();
					while (rs.next()) {
						caseType = new CaseType();
						caseType.setId(rs.getInt("id"));
						caseType.setName(rs.getString("name"));

						
					}

				} catch (SQLException e) {
					caseType = null;
					System.out.println("casetype getByCode err: " + e);
				}

				return caseType;
			}
	
}
