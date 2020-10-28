package com.myclass.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.myclass.connection.JDBCConnection;
import com.myclass.entity.Role;

public class RoleDao {

	// Phương thức lấy danh sách
	public List<Role> findAll() {
		List<Role> roles = new ArrayList<Role>();
		try (Connection conn = JDBCConnection.getConnection()){
			// Tạo câu lệnh truy vấn sử dụng PreparedStatement
			PreparedStatement statement = conn.prepareStatement("SELECT * FROM roles");
			// Thực thi câu lệnh truy vấn
			// Tạo đối tượng ResultSet lưu trữ tạm thời dữ liệu lấy ra database
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				// Tạo đối tượng role
				Role role = new Role(); 
				role.setId(resultSet.getInt("id"));
				role.setName(resultSet.getString("name"));
				role.setDescription(resultSet.getString("description"));
				// Thêm vào danh sách
				roles.add(role);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return roles;
	}

	// Phương thức lấy ra đối tượng role theo id
	public Role findById(int id) {
		// Tạo đối tượng role
		Role role = new Role(); 
		try (Connection conn = JDBCConnection.getConnection()){
			// Tạo câu lệnh truy vấn sử dụng PreparedStatement
			PreparedStatement statement = conn.prepareStatement("SELECT * FROM roles WHERE id = ?");
			// Thay thế dấu ? bằng id truyền lên từ servlet
			statement.setInt(1, id);
			// Thực thi câu lệnh truy vấn
			// Tạo đối tượng ResultSet lưu trữ tạm thời dữ liệu lấy ra database
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				role.setId(resultSet.getInt("id"));
				role.setName(resultSet.getString("name"));
				role.setDescription(resultSet.getString("description"));
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return role;
	}

	// Phương thức thêm mới
	public void add(Role role) {
		String query = "INSERT INTO roles(name, description) VALUES (?, ?)";
		try (Connection conn = JDBCConnection.getConnection()){
			// Tạo câu lệnh truy vấn sử dụng PreparedStatement
			PreparedStatement statement = conn.prepareStatement(query);
			// Thay thế dấu ? bằng dữ liệu lấy ra từ đối tượng role
			statement.setString(1, role.getName());
			statement.setString(2, role.getDescription());
			// Thực thi câu lệnh truy vấn
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Phương thức cập nhật
	public void update(Role role) {
		String query = "UPDATE roles SET name = ?, description = ? WHERE id = ?";
		try (Connection conn = JDBCConnection.getConnection()){
			// Tạo câu lệnh truy vấn sử dụng PreparedStatement
			PreparedStatement statement = conn.prepareStatement(query);
			// Thay thế dấu ? bằng dữ liệu lấy ra từ đối tượng role
			statement.setString(1, role.getName());
			statement.setString(2, role.getDescription());
			statement.setInt(3, role.getId());
			// Thực thi câu lệnh truy vấn
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Phương thức xóa đối tượng role theo id
	public void deleteById(int id) {
		String query = "DELETE FROM roles WHERE id = ?";
		try (Connection conn = JDBCConnection.getConnection()){
			// Tạo câu lệnh truy vấn sử dụng PreparedStatement
			PreparedStatement statement = conn.prepareStatement(query);
			// Thay thế dấu ? bằng dữ liệu lấy ra từ đối tượng role
			statement.setInt(1, id);
			// Thực thi câu lệnh truy vấn
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
