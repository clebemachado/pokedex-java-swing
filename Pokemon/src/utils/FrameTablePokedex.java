package utils;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import entidade.PokemonDAO;
import entidade.PokemonTableModel;

public class FrameTablePokedex extends JFrame{
	
	private static final long serialVersionUID = 1L;

	public FrameTablePokedex() {
		super("Pokemon");
		PokemonDAO dao = new PokemonDAO();
		PokemonTableModel tmp = new PokemonTableModel(dao);
		JTable t = new JTable(tmp);
		
		
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(t);
		this.add(scroll);
		this.setSize(550, 200);
		this.setLocation(0,0);
	}
	
	public static void main(String[] args) {
		
	}
}
