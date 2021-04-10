package entidade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class PokemonDAO {

	public Connection conn;

	public PokemonDAO() {
		// Driver
		String url = "jdbc:derby:pokedex;create=true";
		try {
			// aqui estamos conectando com o driver
			conn = DriverManager.getConnection(url);
			System.out.println("Conectando na pokedex.....");
		} catch (SQLException e) {
			System.out.println("Conexão com a pokedex inválida....." + e.getMessage());
			e.printStackTrace();
		}
	}

	public void criarPokedex() {
		// Essa função cria a tabela no banco de dados CREATE TABLE
		try {
			String sql = "CREATE TABLE pokedex( " + "numero_da_pokedex Integer not null unique, "
					+ "nome varchar(40) not null unique, " + "tipo varchar(40) not null, "
					+ "hp Integer not null, ataque Integer not null, "
					+ "defesa Integer not null, habilidade varchar(100) not null)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.execute();
			stmt.close();
			System.out.println("Pokedex criada com sucesso...");

		} catch (SQLException e) {
			System.out.println("Não foi possível criar a Pokedex");
			e.printStackTrace();
		}

	}

	public void adiciona(Pokemon p) {
		String sql = "INSERT INTO pokedex(numero_da_pokedex, nome, tipo, hp, ataque, defesa, habilidade)"
				+ "VALUES(?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql); 
			stmt.setInt(1, p.getNumero_da_pokedex());
			stmt.setString(2, p.getNome());
			stmt.setString(3, p.getTipo());
			stmt.setInt(4, p.getHp());
			stmt.setInt(5, p.getAtaque());
			stmt.setInt(6, p.getDefesa());
			stmt.setString(7, p.getHabilidade());
			
			stmt.execute();
			stmt.close();
			System.out.println(p.getNome() + " adicionado a sua pokedex.");
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
	}

	public List<Pokemon> mostrarPokedex() {
		List<Pokemon> pokemons = new LinkedList<Pokemon>();
		String sql = "select * from pokedex";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Pokemon pokemon = new Pokemon();
				pokemon.setNumero_da_pokedex(rs.getInt("numero_da_pokedex"));
				pokemon.setNome(rs.getString("nome"));
				pokemon.setTipo(rs.getString("tipo"));
				pokemon.setHp(rs.getInt("hp"));
				pokemon.setAtaque(rs.getInt("ataque"));
				pokemon.setDefesa(rs.getInt("defesa"));
				pokemon.setHabilidade(rs.getString("habilidade"));
				pokemons.add(pokemon);
			}
			stmt.close();
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return pokemons;
	}
	
	
	public void atualiza(Pokemon p) {
		String sql = "UPDATE pokedex set nome = ?, tipo = ?, hp = ?, ataque = ?, "
				+ "defesa = ?, habilidade = ? where numero_da_pokedex = ? ";				
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, p.getNome());
			stmt.setString(2, p.getTipo());
			stmt.setInt(3, p.getHp());
			stmt.setInt(4, p.getAtaque());
			stmt.setInt(5, p.getDefesa());
			stmt.setString(6, p.getHabilidade());
			stmt.setInt(7, p.getNumero_da_pokedex());
			stmt.execute();
			stmt.close();
			JOptionPane j = new JOptionPane();
			j.showMessageDialog(null, p.getNome() + " atualizado");

			System.out.println(p.getNome() + " atualizado na sua pokedex.");
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
	}

}
