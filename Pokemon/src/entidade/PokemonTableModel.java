 package entidade;

import java.util.Arrays;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import utils.Valida;

public class PokemonTableModel extends AbstractTableModel implements TableModelListener {

	private List<Pokemon> pokemons;
	private List<String> colunas;
	private PokemonDAO dao;

	public PokemonTableModel(PokemonDAO dao) {
		this.dao = dao;
		this.pokemons = dao.mostrarPokedex();
		colunas = Arrays.asList("Numero", "Nome", "Tipo", "HP", "ATK", "DFS", "DESCRI");
		this.addTableModelListener(this);		
	}
	public PokemonTableModel() {
		//sobrecarga
	}
	
	public int getRowCount() {
		return pokemons.size();
	}

	public int getColumnCount() {
		return colunas.size();
	}
	
	public String getColumnName(int i) {
		return colunas.get(i);
	}

	public Object getValueAt(int r, int c) {
		Pokemon pokemon = pokemons.get(r);
		switch (c) {
			case 0:	return pokemon.getNumero_da_pokedex();
			case 1:	return pokemon.getNome();
			case 2:	return pokemon.getTipo();
			case 3:	return pokemon.getHp();
			case 4:	return pokemon.getAtaque();
			case 5:	return pokemon.getDefesa();
			case 6:	return pokemon.getHabilidade();
		}
		return null;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex != 0;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Pokemon pokemon = pokemons.get(rowIndex);
		System.out.println("TO NO setValueAt");
		System.out.println(columnIndex);
		switch (columnIndex) {
			case 0: pokemon.setNumero_da_pokedex((Integer)aValue); break;
			case 1:	pokemon.setNome((String)aValue); break;
			case 2:	pokemon.setTipo((String)aValue); break;
			case 3:	pokemon.setHp(Integer.valueOf((String)aValue)); break;
			case 4:	pokemon.setAtaque(Integer.valueOf((String)aValue)); break;
			case 5:	pokemon.setDefesa(Integer.valueOf((String)aValue)); break;
			case 6:	pokemon.setHabilidade((String)aValue); break;
		}
		fireTableCellUpdated(rowIndex, columnIndex);
		
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		int i = e.getFirstRow();
		Pokemon pokemon = pokemons.get(i);
		System.out.println(pokemon);
		dao.atualiza(pokemon);		
	}
	
	public void addPokemons(Integer numero, String nome, String tipo, Integer hp, Integer atk, Integer def,
			String habilidade) {
		Pokemon p = new Pokemon();
		p.setNumero_da_pokedex(numero);p.setNome(nome);	p.setTipo(tipo);
		p.setHp(hp); p.setAtaque(atk);	p.setDefesa(def);p.setHabilidade(habilidade);

		PokemonDAO dao = new PokemonDAO();
		dao.adiciona(p);
	}
	
	

}
