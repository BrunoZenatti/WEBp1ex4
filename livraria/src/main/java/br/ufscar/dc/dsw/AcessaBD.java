package br.ufscar.dc.dsw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AcessaBD {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/livraria?useTimezone=true&serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";
            Connection con = DriverManager.getConnection(url, "root", "root");

            Statement stmt = con.createStatement();
            String query = "SELECT l.Titulo, l.Autor, e.Nome AS Editora, l.Ano, l.Preco " +
                           "FROM Livro l " +
                           "INNER JOIN Editora e ON l.Editora_id = e.id " +
                           "ORDER BY l.Preco";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.print(rs.getString("Titulo"));
                System.out.print(", " + rs.getString("Autor"));
                System.out.print(", " + rs.getString("Editora"));
                System.out.print(", " + rs.getInt("Ano"));
                System.out.println(" (R$ " + rs.getFloat("Preco") + ")");
            }
            stmt.close();
            con.close();
        } catch (ClassNotFoundException e) {
            System.out.println("A classe do driver de conexão não foi encontrada!");
        } catch (SQLException e) {
            System.out.println("O comando SQL não pode ser executado!");
        }
    }
}
