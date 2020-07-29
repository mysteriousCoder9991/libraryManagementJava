package helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbmsHelper {

	static Connection con;
	static Statement stmt;

	static void init() {
		/*
		 * try { Class.forName("com.mysql.jdbc.Driver"); } catch (ClassNotFoundException
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); }//loading of
		 * the class file
		 * 
		 */try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryManagementJava", "root", "root");
			System.out.println("Connection to MySQL Server  Successful ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	static void createTable() {
		init();
		System.out.println("Now creating tables");
		String booktc = "CREATE TABLE `libraryManagementJava`.`books` ( `Acc_No` INT NOT NULL, `Title` VARCHAR(45) NOT NULL,`Author` VARCHAR(45) NULL DEFAULT 'NA',"
				+ "`Publisher` VARCHAR(45) NOT NULL, `noca` VARCHAR(45) NOT NULL, PRIMARY KEY (`Acc_No`));";
		String alterBook = "ALTER TABLE `libraryManagementJava`.`books` \r\n"
				+ "CHANGE COLUMN `Title` `Title` VARCHAR(100) NOT NULL ,\r\n"
				+ "CHANGE COLUMN `Publisher` `Publisher` VARCHAR(150) NOT NULL ;";
		String memTc = "CREATE TABLE `libraryManagementJava`.`members` (\r\n"
				+ "  `ID` INT NOT NULL AUTO_INCREMENT,\r\n" + "  `email` VARCHAR(45) NULL,\r\n"
				+ "  `first_name` VARCHAR(50) NULL,\r\n" + "  `last_name` VARCHAR(45) NULL,\r\n"
				+ "  `password` VARCHAR(20) NOT NULL,\r\n" + "  `read_books` VARCHAR(1500) NULL,\r\n"
				+ "  PRIMARY KEY (`ID`),\r\n" + "  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE);\r\n";
		String issueTableQ = "CREATE TABLE `libraryManagementJava`.`issue_table` (\r\n"
				+ "  `issue_id` INT NOT NULL AUTO_INCREMENT,\r\n" + "  `accNo` INT NULL,\r\n"
				+ "  `member_id` INT NOT NULL,\r\n" + "  `dbi` DATE NOT NULL,\r\n" + "  `dtbr` DATE NOT NULL,\r\n"
				+ "  `odbr` DATE NULL,\r\n" + "  `fines` DOUBLE NULL DEFAULT 0,\r\n" + "  PRIMARY KEY (`issue_id`),\r\n"
				+ "  INDEX `accNo_idx` (`accNo` ASC) VISIBLE,\r\n" + "  CONSTRAINT `accNo`\r\n"
				+ "    FOREIGN KEY (`accNo`)\r\n" + "    REFERENCES `libraryManagementJava`.`books` (`Acc_No`)\r\n"
				+ "    ON DELETE RESTRICT\r\n" + "    ON UPDATE NO ACTION);";
		String booksReadQ = "CREATE TABLE `libraryManagementJava`.`books_read` (\r\n"
				+ "  `member_id` INT NOT NULL,\r\n" + "  `acc_No` INT NULL,\r\n" + "  PRIMARY KEY (`member_id`),\r\n"
				+ "  INDEX `accessionNumber_idx` (`acc_No` ASC) VISIBLE,\r\n" + "  CONSTRAINT `accessionNumber`\r\n"
				+ "    FOREIGN KEY (`acc_No`)\r\n"
				+ "    REFERENCES `libraryManagementJava`.`issue_table` (`accNo`)\r\n" + "    ON DELETE NO ACTION\r\n"
				+ "    ON UPDATE NO ACTION)\r\n" + "ENGINE = InnoDB;";
		String followerQ = "CREATE TABLE `libraryManagementJava`.`followers` (\r\n" + "  `member_id` INT NOT NULL,\r\n"
				+ "  `following` VARCHAR(150) NULL DEFAULT 0,\r\n" + "  `followers` VARCHAR(150) NULL DEFAULT 0,\r\n"
				+ "  PRIMARY KEY (`member_id`));";
		try {

			stmt.execute(booktc);
			System.out.println("Book table created");
			stmt.execute(alterBook);
			System.out.println("Book table altered");
			stmt.execute(memTc);
			System.out.println("Member table created");
			stmt.execute(issueTableQ);
			System.out.println("Issue Books  table created");
			stmt.execute(booksReadQ);
			System.out.println("Books Read table created");
			stmt.execute(followerQ);
			System.out.println("Followers table created");
			System.out.println("Tables are ready ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String agrs[]) {
		// DbmsHelper obj = new DbmsHelper();
		DbmsHelper.createTable();
	}
}
