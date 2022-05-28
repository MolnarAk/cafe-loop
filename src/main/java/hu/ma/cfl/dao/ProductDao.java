package hu.ma.cfl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import hu.ma.cfl.bo.Product;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProductDao implements Dao<Product> {

    private static final String INSERT_INTO_PRODUCT = "insert into product(name, price, description, image_path) VALUES(?, ?, ?, ?);";

    private final DataSource dataSource;

    @Override
    public Product create(Product entity) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(INSERT_INTO_PRODUCT, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, entity.getName());
            ps.setInt(2, entity.getPrice());
            ps.setString(3, entity.getDescription());
            ps.setString(4, entity.getImagePath());

            ps.executeUpdate();

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    entity.setId(generatedKeys.getInt(1));
                }
            }

            return entity;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Product extractProduct(ResultSet rs) throws SQLException {
        Product product = new Product();
        product.setId(rs.getInt("id"));
        product.setName(rs.getString("name"));
        product.setPrice(rs.getInt("price"));
        product.setImagePath(rs.getString("image_path"));

        return product;
    }

    @Override
    public Optional<Product> findById(int id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("select * from product where id = ?;")) {
            ps.setInt(1, id);

            try (ResultSet rs =  ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(extractProduct(rs));
                }
            }

            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {

            try (ResultSet rs =  statement.executeQuery("select * from product;")) {
                if (rs.next()) {
                    products.add(extractProduct(rs));
                }
            }

            return products;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Product update(Product entity) {
        // TODO
        return null;
    }

    @Override
    public void deleteById(int id) {
        // TODO
    }
}
