package utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidade.PokemonTableModel;

public class Valida implements ActionListener{
	private final JTextField numero;
	private final JTextField nome;
	private JTextField tipo;
	private JTextField healthPower;
	private JTextField ataque;
	private JTextField defesa;
	private JTextField habilidade;
	private JFrame frame; 
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane j = new JOptionPane();
		try {
			Integer num = Integer.parseInt(this.numero.getText());
			String nom = this.nome.getText();
			String tip = this.tipo.getText();
			Integer hp = Integer.parseInt(healthPower.getText());
			Integer atk =Integer.parseInt(this.ataque.getText());
			Integer def = Integer.parseInt(this.defesa.getText());
			String hab = this.habilidade.getText();
			
			Cadastrar cadast = new Cadastrar();
			
			cadast.addPokemons(num, nom, tip, hp, atk, def, hab);
			j.showMessageDialog(null, nom + " adicionado com sucesso");
			new Limpar(this.frame);
			
		} catch (NumberFormatException  nb){
			j.showMessageDialog(null, "Os dados informados são inválidos");
		}
						
	}

	
	public Valida(JTextField numero, JTextField nome, JTextField tipo, JTextField hp, 
									JTextField atk, JTextField def, JTextField hab, JFrame f ) {
		this.numero = numero;
		this.nome = nome;
		this.tipo = tipo;
		this.healthPower = hp;
		this.ataque = atk;
		this.defesa = def;
		this.habilidade = hab;
		this.frame = f;
		
	}
	
}
