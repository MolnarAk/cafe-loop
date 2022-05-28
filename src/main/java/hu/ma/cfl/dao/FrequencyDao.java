package hu.ma.cfl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import hu.ma.cfl.bo.Frequency;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FrequencyDao implements Dao<Frequency> {

    private final DataSource dataSource;

    @Override
    public Frequency create(Frequency entity) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("insert into frequency(name) values(?);", Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, entity.getName());

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
    public Optional<Frequency> findById(int id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement("select * from frequency where id = ?;")) {
            ps.setInt(1, id);

            try (ResultSet rs =  ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(extractFrequency(rs));
                }
            }

            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Frequency extractFrequency(ResultSet rs) throws SQLException {
        Frequency frequency = new Frequency();
        frequency.setId(rs.getInt("id"));
        frequency.setName(rs.getString("name"));

        return frequency;
    }

    @Override
    public List<Frequency> findAll() {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public Frequency update(Frequency entity) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void deleteById(int id) {
        throw new UnsupportedOperationException("Not implemented");
    }

}
