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
	
	// 대출상품 조회
	public List<LoanProductDto> findAll() {
		List<LoanProductDto> loanProduct = new ArrayList<LoanProductDto>();

		String selectQuery = "SELECT lp.id, lp.name, lp.loan_limit, lp.interest_rate, cg.type "
                + "FROM loan_product lp "
                + "JOIN credit_grade cg ON lp.credit_grade_id = cg.id";
		
		try (
			Connection connection = DBUtil.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(selectQuery);
			) {
			
			while(resultSet.next()) {
				long id = resultSet.getLong("id");
				String name = resultSet.getString("name");
				int loan_limit = resultSet.getInt("loan_limit");
				float interest_rate = resultSet.getFloat("interest_rate");
				String minimumCreditGrade = resultSet.getString("type");
		
				loanProduct.add(new LoanProductDto(id, name, loan_limit, interest_rate, minimumCreditGrade));
			}
						
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return loanProduct;
	}
	
	
	// 대출상품 추가
	@Override
	public void createLoanProduct(String name, int loanLimit, float interestRate, String minimumCreditGrade) {
		String insertQuery = "INSERT INTO loan_product (name, loan_limit, interest_rate, credit_grade_id) VALUES (?, ?, ?, ?)";
        
        try (
    		// DB 연결
            Connection connection = DBUtil.getConnection();
            // 쿼리를 실행할 PreparedStatement 준비
            PreparedStatement statement = connection.prepareStatement(insertQuery);
            ) {
            
            statement.setString(1, name);
            statement.setInt(2, loanLimit);
            statement.setFloat(3, interestRate);
            
            // credit_grade를 숫자로 변환
            String creditGrade = minimumCreditGrade;
            long creditGradeId;
            switch (creditGrade) {
                case "A":
                    creditGradeId = 1;
                    break;
                case "B":
                    creditGradeId = 2;
                    break;
                case "C":
                    creditGradeId = 3;
                    break;
                case "D":
                    creditGradeId = 4;
                    break;
                case "E":
                    creditGradeId = 5;
                    break;    
                default:
                    throw new IllegalArgumentException("Invalid credit grade: " + creditGrade);
            }

            statement.setLong(4, creditGradeId);
            statement.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

		
	}


	@Override
	public LoanProductDto findById(long arg0) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<LoanProductDto> recommend(String creditGrade, int count) {
		List<LoanProductDto> loanProduct = new ArrayList<LoanProductDto>();

	    // credit_grade를 숫자로 변환
	    long creditGradeId;
	    switch (creditGrade) {
	        case "A":
	            creditGradeId = 1;
	            break;
	        case "B":
	            creditGradeId = 2;
	            break;
	        case "C":
	            creditGradeId = 3;
	            break;
	        case "D":
	            creditGradeId = 4;
	            break;
	        case "E":
	            creditGradeId = 5;
	            break;    
	        default:
	            throw new IllegalArgumentException("Invalid credit grade: " + creditGrade);
	    }

	    String selectQuery = "SELECT lp.id, lp.name, lp.loan_limit, lp.interest_rate, cg.type "
	            + "FROM loan_product lp "
	            + "JOIN credit_grade cg ON lp.credit_grade_id = cg.id "
	            + "WHERE cg.id >= ? "
	            + "ORDER BY cg.id ASC, lp.interest_rate ASC, lp.loan_limit DESC "
	            + "LIMIT ?";

	    try (
	        // DB 연결
	        Connection connection = DBUtil.getConnection();
	        // 쿼리를 실행할 PreparedStatement 준비
	        PreparedStatement statement = connection.prepareStatement(selectQuery);
	        ) {

	        statement.setLong(1, creditGradeId);
	        statement.setInt(2, count);

	        ResultSet resultSet = statement.executeQuery();

	        while(resultSet.next()) {
	            long id = resultSet.getLong("id");
	            String name = resultSet.getString("name");
	            int loan_limit = resultSet.getInt("loan_limit");
	            float interest_rate = resultSet.getFloat("interest_rate");
	            String minimumCreditGrade = resultSet.getString("type");

	            loanProduct.add(new LoanProductDto(id, name, loan_limit, interest_rate, minimumCreditGrade));
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return loanProduct;
	}


	@Override
	public void updateLoanProduct(long arg0, String arg1, int arg2, float arg3, String arg4) {
		// TODO Auto-generated method stub
		
	}
}
