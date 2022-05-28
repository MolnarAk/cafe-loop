package hu.ma.cfl.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import hu.ma.cfl.bo.Customer;
import hu.ma.cfl.bo.Frequency;
import hu.ma.cfl.bo.Subscription;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SubscriptionDao implements Dao<Subscription> {

    private static final String INSERT_INTO_SUBSCRIPTION = "insert into subscription(customer_id, frequency_id, subscription_date) VALUES(?, ?, ?)";

    private final DataSource dataSource;

    @Override
    public Subscription create(Subscription entity) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(INSERT_INTO_SUBSCRIPTION, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, entity.getCustomer().getId());
            ps.setInt(2, entity.getFrequency().getId());
            ps.setDate(3, Date.valueOf(LocalDate.now()));

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
    public Optional<Subscription> findById(int id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("select * from subscription where id = ?;")) {
            ps.setInt(1, id);

            try (ResultSet rs =  ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(extractSubscription(rs));
                }
            }

            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private Subscription extractSubscription(ResultSet rs) throws SQLException {
        Subscription subscription = new Subscription();
        subscription.setId(rs.getInt("id"));
        subscription.setSubscriptionDate(rs.getDate("subscription_date").toLocalDate());

        Customer customer = new Customer();
        customer.setId(rs.getInt("customer_id"));

        subscription.setCustomer(customer);

        Frequency frequency = new Frequency();
        frequency.setId(rs.getInt("frequency_id"));

        subscription.setFrequency(frequency);

        return subscription;
    }

    @Override
    public List<Subscription> findAll() {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public Subscription update(Subscription entity) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void deleteById(int id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("delete from subscription where id = ?;")) {
            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}