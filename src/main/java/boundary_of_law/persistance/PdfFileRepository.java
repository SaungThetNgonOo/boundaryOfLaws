package boundary_of_law.persistance;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import boundary_of_law.models.PDFFile;

public class PdfFileRepository {
	public static Connection con = null;

	static {
		con = MyConnection.getConnection();
	}

	public byte[] getFileContent(int id) {
		String sql = "SELECT content FROM pdf_files WHERE id = ?";
		byte[] fileContent = null;

		try (PreparedStatement statement = con.prepareStatement(sql)) {

			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				fileContent = resultSet.getBytes("content");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return fileContent;
	}

	public PDFFile saveFile(PDFFile pdfFile) throws SQLException {
		String sql = "INSERT INTO pdf_files (name, content) VALUES (?, ?)";
		try (PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {
			ps.setString(1, pdfFile.getName());
			ps.setBytes(2, pdfFile.getContent());
			int affectedRows = ps.executeUpdate();
			if (affectedRows == 0) {
				throw new SQLException("Creating PDF file failed, no rows affected.");
			}
			try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					pdfFile.setId(generatedKeys.getLong(1));
				} else {
					throw new SQLException("Creating PDF file failed, no ID obtained.");
				}
			}
		}
		return pdfFile;
	}

	public PDFFile getFile(Long id) throws SQLException {
		String sql = "SELECT * FROM pdf_files WHERE id = ?";
		try (PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setLong(1, id);
			try (ResultSet resultSet = ps.executeQuery()) {
				if (resultSet.next()) {
					PDFFile pdfFile = new PDFFile();
					pdfFile.setId(resultSet.getLong("id"));
					pdfFile.setName(resultSet.getString("name"));
					pdfFile.setContent(resultSet.getBytes("content"));
					return pdfFile;
				}
			}
		}
		return null;
	}

	public List<PDFFile> getAllFiles() throws SQLException {
		String sql = "SELECT * FROM pdf_files";
		List<PDFFile> files = new ArrayList<>();
		try (Statement statement = con.createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {
			while (resultSet.next()) {
				PDFFile pdfFile = new PDFFile();
				pdfFile.setId(resultSet.getLong("id"));
				pdfFile.setName(resultSet.getString("name"));
				pdfFile.setContent(resultSet.getBytes("content"));
				files.add(pdfFile);
			}
		}
		return files;
	}

	public PDFFile updateFile(PDFFile pdfFile) throws SQLException {
		String sql = "UPDATE pdf_files SET name = ?, content = ? WHERE id = ?";
		try (PreparedStatement statement = con.prepareStatement(sql)) {
			statement.setString(1, pdfFile.getName());
			statement.setBytes(2, pdfFile.getContent());
			statement.setLong(3, pdfFile.getId());
			statement.executeUpdate();
		}
		return pdfFile;
	}

	public void deleteFile(Long id) throws SQLException {
		String sql = "DELETE FROM pdf_files WHERE id = ?";
		try (PreparedStatement statement = con.prepareStatement(sql)) {
			statement.setLong(1, id);
			statement.executeUpdate();
		}
	}
}
