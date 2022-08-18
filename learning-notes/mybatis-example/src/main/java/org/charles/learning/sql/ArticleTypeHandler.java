package org.charles.learning.sql;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(value = ArticleTypeEnum.class)
public class ArticleTypeHandler extends BaseTypeHandler<ArticleTypeEnum> {

  @Override
  public void setNonNullParameter(PreparedStatement ps, int i, ArticleTypeEnum parameter, JdbcType jdbcType)
    throws SQLException {
    ps.setInt(i, parameter.code());
  }

  @Override
  public ArticleTypeEnum getNullableResult(ResultSet rs, String columnName) throws SQLException {
    int code = rs.getInt(columnName);
    return ArticleTypeEnum.find(code);
  }

  @Override
  public ArticleTypeEnum getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
    int code = rs.getInt(columnIndex);
    return ArticleTypeEnum.find(code);
  }

  @Override
  public ArticleTypeEnum getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
    int code = cs.getInt(columnIndex);
    return ArticleTypeEnum.find(code);
  }
}
