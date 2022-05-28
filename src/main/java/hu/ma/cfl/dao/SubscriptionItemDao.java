package hu.ma.cfl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import hu.ma.cfl.bo.SubscriptionItem;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SubscriptionItemDao implements Dao<SubscriptionItem> {

    public static final String INSERT_INTO_SUBSCRIPTION_ITEM = "insert into subscription_item(product_id, subscription_id) VALUES (?, ?)";
    private final DataSource dataSource;

    @Override
    public SubscriptionItem create(SubscriptionItem entity) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(INSERT_INTO_SUBSCRIPTION_ITEM, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, entity.getProduct().getId());
            ps.setInt(2, entity.getSubscription().getId());

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

    @Override
    public Optional<SubscriptionItem> findById(int id) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public List<SubscriptionItem> findAll() {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public SubscriptionItem update(SubscriptionItem entity) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void deleteById(int id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("delete from subscription_item where id = ?;")) {
            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
