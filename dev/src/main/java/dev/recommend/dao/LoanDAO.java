package dev.recommend.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.loan.dto.LoanProductDto;
import com.loan.service.LoanProductService;

import dev.recommend.util.DBUtil;

public class LoanDAO implements LoanProductService {

	@Override
	public List<LoanProductDto> findAll() {
		List<LoanProductDto> loanProducts = new ArrayList<>();

		String selectQuery = "SELECT * " + "FROM loan_product A " + "INNER JOIN credit_grade B "
				+ "on A.credit_grade_id = B.id " + "ORDER BY A.id ";

		try (Connection connection = DBUtil.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(selectQuery);) {
			while (resultSet.next()) {
				long id = resultSet.getLong("id");
				String name = resultSet.getString("name");
				int loan_limit = resultSet.getInt("loan_limit");
				float interest_rate = resultSet.getFloat("interest_rate");
				String type = resultSet.getString("type");

				loanProducts.add(new LoanProductDto(id, name, loan_limit, interest_rate, type));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return loanProducts;

	}

	@Override
	public void createLoanProduct(String arg0, int arg1, float arg2, String arg3) {
		// TODO Auto-generated method stub

	}

	@Override
	public LoanProductDto findById(long id) {

		String selectQuery = "SELECT * " + "FROM loan_product " + "WHERE id = ? ";

		try (Connection connection = DBUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(selectQuery);) {

			statement.setLong(1, id);

			ResultSet resultSet = statement.executeQuery();

			resultSet.next();

			long loan_product = resultSet.getLong("id");
			String name = resultSet.getString("name");
			int loan_limit = resultSet.getInt("loan_limit");
			float interest_rate = resultSet.getFloat("interest_rate");
			String credit_grade_id = resultSet.getString("credit_grade_id");

			return new LoanProductDto(loan_product, name, loan_limit, interest_rate, credit_grade_id);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<LoanProductDto> recommend(String arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateLoanProduct(long id, String name, int loanLimit, float interestRate, String minimumCreditGrade) {
		String updateQuery = "UPDATE loan_product "
				+ "SET name = ?, loan_limit = ?, interest_rate = ? , credit_grade_id = ? " + "WHERE id = ? ";

		long credit_grade_id = 0L;

		switch (minimumCreditGrade) {
		case "A":
			credit_grade_id = 1L;
			break;
		case "B":
			credit_grade_id = 2L;
			break;
		case "C":
			credit_grade_id = 3L;
			break;
		case "D":
			credit_grade_id = 4L;
			break;
		case "E":
			credit_grade_id = 5L;
			break;
		default:
			break;
		}

		try (Connection connection = DBUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement(updateQuery);) {

			statement.setString(1, name);
			statement.setInt(2, loanLimit);
			statement.setFloat(3, interestRate);
			statement.setLong(4, credit_grade_id);
			statement.setLong(5, id);

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
