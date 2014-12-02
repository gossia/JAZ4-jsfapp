package repositories.impl;

import java.sql.*;

import domain.Language;
import domain.Student;

public class LanguageBuilder implements IEntityBuilder<Language> {

	@Override
	public Language build(ResultSet rs) throws SQLException {
		
		Language language = new Language();
		language.setId(rs.getInt("id"));
		language.setName(rs.getString("name"));
		language.setLevel(rs.getString("level"));
		return language;
	}

}
