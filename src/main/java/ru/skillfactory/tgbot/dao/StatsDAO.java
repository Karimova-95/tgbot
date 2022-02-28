package ru.skillfactory.tgbot.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class StatsDAO {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public Integer getCountIncomesThatGreaterThan(BigDecimal amount) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("amount", amount);
        return namedParameterJdbcTemplate.queryForObject("select count(*) as ROW_COUNT from incomes where income > :amount", parameters, new StatsRowMapper());
    }

    public Integer getCountIncomesThatLessThan(BigDecimal amount) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("amount", amount);
        return namedParameterJdbcTemplate.queryForObject("select count(*) as ROW_COUNT from incomes where income < :amount", parameters, new StatsRowMapper());
    }

    private static final class StatsRowMapper implements RowMapper<Integer> {
        @Override
        public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
            return rs.getInt("ROW_COUNT");
        }
    }
}
