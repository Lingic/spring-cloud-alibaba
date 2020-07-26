//package cn.test;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//import org.junit.jupiter.api.Test;
//
//class TestAccess {
//
////	@Test
//	void test() throws Exception {
//
//		
//		
//        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
//        //与数据库连接
//        Connection con = DriverManager.getConnection("jdbc:odbc:Access");
//        if(con!=null){
//            System.out.println("成功。。。。。。。。。");
//        }
//	}
//	
//	
////	@Test
//	public void testUcanaccess() {
//		Connection conn = null;
//		
//		try {
//			String className = "net.ucanaccess.jdbc.UcanaccessDriver";
//			String url = "jdbc:ucanaccess://D:\\\\Likui\\rfics\\ITCClient.mdb";
//			
//			Class.forName(className);
//			conn = DriverManager.getConnection(url);
//			
//			if (conn != null) {
//				System.out.println("Success...");
//			}
//			
//			//Statement stmt = conn.createStatement();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if (conn != null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//	}
//	
//	
////	@Test
//	public void testUcanaccess2() {
//		Connection conn = null;
//		Statement stmt = null;
//		ResultSet rs = null;
//		
//		try {
//			String className = "net.ucanaccess.jdbc.UcanaccessDriver";
//			String url = "jdbc:ucanaccess://D:\\\\Likui\\rfics\\ITCClient.mdb";
//			
//			Class.forName(className);
//			conn = DriverManager.getConnection(url);
//			stmt = conn.createStatement();
//			
//			String sql = "SELECT * FROM MVC_DATA";
//			rs = stmt.executeQuery(sql);
//			
//			int columnCount = rs.getMetaData().getColumnCount();
//			while (rs.next()) {
//				for (int i = 0; i < columnCount; i++) {
//					System.out.print(rs.getString(i+1) + "\n");
//				}
//				System.out.println("");
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if (stmt != null) {
//				try {
//					stmt.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if (conn != null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//	}
//	
////	@Test
//	public void testUcanaccess3() {
//		Connection conn = null;
//		Statement stmt = null;
//		ResultSet rs = null;
//		
//		try {
//			String className = "net.ucanaccess.jdbc.UcanaccessDriver";
//			String url = "jdbc:ucanaccess://D:\\\\Likui\\rfics\\ITCClient.mdb";
//			
//			Class.forName(className);
//			conn = DriverManager.getConnection(url);
//			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
//			
//			String sql = "SELECT * FROM MVC_DATA";
//			rs = stmt.executeQuery(sql);
//			
//			int columnCount = rs.getMetaData().getColumnCount();
//			while (rs.next()) {
//				for (int i = 0; i < columnCount; i++) {
//					System.out.print(rs.getString(i+1) + "\n");
//				}
//				System.out.println("");
//			}
//			
//			rs.last();
//			int rows = rs.getRow();
//			System.out.println(rows);
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if (stmt != null) {
//				try {
//					stmt.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if (conn != null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//	}
//
//}
