package com.wow.botservice.dao;

import com.wow.botservice.exception.CompareException;
import com.wow.botservice.model.PurchaseOrder;
import com.wow.botservice.model.SearchCriteria;
import com.wow.botservice.model.ValueObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.RowSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CompareDAO implements ICompareDAO {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public SearchCriteria getInitialData() throws CompareException {

        SearchCriteria sc = new SearchCriteria();
        return sc;

    }

    @Override
    public Map<String, ArrayList<ValueObject>> getData(String query, String refInstance,
                                                       List<String> pKeyList, List<String> colList) {
        return null;
    }

    @Override
    public PurchaseOrder getPurchaseOrder(PurchaseOrder po) throws CompareException {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("poNbr", po.getPoNbr());
        String sql = "SELECT * FROM purchase_order WHERE po_nbr= :poNbr";
        SqlRowSet rs  = namedParameterJdbcTemplate.queryForRowSet(sql, params);
        po = new PurchaseOrder();
        while(rs.next()) {
            //PurchaseOrder po = new PurchaseOrder();
            po.setPoNbr(rs.getString("po_nbr"));
            po.setStatus(rs.getString("status"));
        }
        return po;
    }

    public String addPurchaseOrder(PurchaseOrder po) throws CompareException {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("poNbr", po.getPoNbr());
        params.addValue("status", po.getStatus());
        String sql = "INSERT INTO purchase_order Values(:poNbr, :status);";
        int count = namedParameterJdbcTemplate.update(sql, params);
        return ( count > 0 ? "success": "error" );
    }
}
