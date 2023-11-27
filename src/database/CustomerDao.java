package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.dbObjects.Customer;
import pwdconv.PwdChange;

public class CustomerDao {

   public int chkReservation(String reservation_number) {
      int re = -1;
      try (Connection conn = DBConnection.getConnection();) {

         String sql = "SELECT * FROM reservation WHERE reservation_number LIKE ?";
         try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + reservation_number);
            try (ResultSet rs = pstmt.executeQuery()) {
               if (rs.next() == true) {
                  re = 1;
               }
            }
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return re;
   }

   public boolean getFindemail(String name, String phoneNum) {
      boolean re = true;
      try (Connection conn = DBConnection.getConnection();) {

         String sql = "select customer_email from customer where customer_phone_number = ? AND customer_name =?";
         try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, phoneNum);
            pstmt.setString(2, name);
            try (ResultSet rs = pstmt.executeQuery()) {
               System.out.println(sql);
               if (rs.next() == true) {
                  re = true;
               } else {
                  re = false;
               }
            }
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return re;
   }

   public boolean getFindpwd(String name, String email) {
      boolean re = true;
      try (Connection conn = DBConnection.getConnection();) {
         String sql = "select * from customer where customer_name=? AND customer_email=?";
         try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next() == true) {
               re = true;
            } else {
               re = false;
            }
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
      return re;
   }

   public String randomPWD() {// 임시비밀번호 계산
      String repwd = "";
      for (int i = 0; i < 6; i++) {
         char p01 = (char) (Math.random() * 26 + 97);
         if (i % 2 == 0) {
            repwd += (int) (Math.random() * 10);
         } else {
            repwd += p01;
         }
      }
      return repwd;
   }// randomPWD()

   public int getUpdatePWD(Customer custom) {
      int re = -1;
      try (Connection conn = DBConnection.getConnection();) {
         String sql = "update customer set customer_password =? where customer_email =?";
         try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, PwdChange.getPassWordToXEMD5String(custom.getCustomer_password()));
            pstmt.setString(2, custom.getCustomer_email());

            re = pstmt.executeUpdate();
         }
         return re;
      } // getUpdatePWD
      catch (SQLException e) {
         e.printStackTrace();
      }
      return re;
   }

   public List<String> getIdList(String name, String phoneNum) {
      List<String> getlist = new ArrayList<>();
      try (Connection conn = DBConnection.getConnection();) {
         String sql = "select customer_email from customer where customer_name=? AND customer_phone_number=?";
         try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, phoneNum);
            pstmt.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
               getlist.add(rs.getString("customer_email"));
            }

         }
      } catch (Exception e) {
         e.printStackTrace();
      }
      return getlist;

   }

   public boolean pwdCheck(String email, String password) {
      boolean re = true;
      try (Connection conn = DBConnection.getConnection();) {
         String sql = "select customer_password from customer where customer_email =?";
         try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            pstmt.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next() == true) {
               return re;
            } else {
               re = false;
            }
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }

      return re;
   }

   // 비밀번호 변경
   public int getUpdatePWDChange( String email, String password) {
      System.out.println(password);
      int re = -1;
      try (Connection conn = DBConnection.getConnection();) {
         String sql = "update customer set customer_password =? where customer_email =?";
         try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, PwdChange.getPassWordToXEMD5String(password));
            pstmt.setString(2, email);

            re = pstmt.executeUpdate();
            
         }
         System.out.println("리턴값:"+re);

         return re;
      } // getUpdatePWD
      catch (SQLException e) {
         e.printStackTrace();
      }
      System.out.println("리턴값:"+re);
      return re;
   }
}