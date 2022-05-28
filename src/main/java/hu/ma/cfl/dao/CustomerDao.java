package hu.ma.cfl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import hu.ma.cfl.bo.Customer;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CustomerDao implements Dao<Customer> {

    private final DataSource dataSource;

	private static final String INSERT_SQL = "INSERT INTO customer(email, name, pw, salt) values(?, ?, ?, ?);";

	public Customer create(Customer entity) {
		try (Connection connection = dataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
			ps.setString(1, entity.getEmail());
			ps.setString(2, entity.getName());
			ps.setString(3, entity.getPassword());
			ps.setString(4, entity.getSalt());

			int updatedRows = ps.executeUpdate();

			try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					int generatedId = generatedKeys.getInt(1);
					entity.setId(generatedId);
				}
			}

			return entity;

		} catch (SQLException e) {// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	public Optional<Customer> findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Customer> findAll() {

		// TODO Auto-generated method stub
		return null;
	}

	public Customer update(Customer entity) {
		try (Connection connection = dataSource.getConnection();
				PreparedStatement ps = connection
						.prepareStatement("update customer set email = ?, name = ?, pw = ? where id = ?;")) {
			ps.setString(1, entity.getEmail());
			ps.setString(2, entity.getName());
			ps.setString(3, entity.getPassword());
			ps.setInt(4, entity.getId());

			// Itt lehetne ellenőrizni, hogy megfelelően updatelődött egy sor
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return entity;
	}

	public void deleteById(int id) {
		// TODO Auto-generated method stub

	}

	private Customer extractCustomer(ResultSet rs) throws SQLException {
		Customer customer = new Customer();
		customer.setId(rs.getInt("id"));
		customer.setEmail(rs.getString("email"));
		customer.setName(rs.getString("name"));
		customer.setPassword(rs.getString("pw"));
		customer.setSalt(rs.getString("salt"));

		return customer;
	}

	public Optional<Customer> getCustomerByEmail(String email) throws SQLException {
		try (Connection connection = dataSource.getConnection();
				PreparedStatement ps = connection.prepareStatement("select * from customer where email = ?;")) {

			ps.setString(1, email);

			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return Optional.of(extractCustomer(rs));
				}
			}
		}

		return Optional.empty();
	}

}