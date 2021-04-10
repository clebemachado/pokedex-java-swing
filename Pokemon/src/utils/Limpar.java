package utils;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextField;


public class Limpar implements ActionListener {
	
	private JFrame f;

	@Override
	public void actionPerformed(ActionEvent e) {
		// Deixei a limpeza no construtor. Tenho que limpar os campos quando adicionar for 
		// Sucesso
		limparTela();
	}
	
	public Limpar(JFrame f) {
		this.f = f;
		limparTela();

	}
	
	public void limparTela() {
		for (int i = 0; i < this.f.getContentPane().getComponentCount(); i++) {
			Component comp = this.f.getContentPane().getComponent(i);
			if (comp instanceof JTextField) {
				//System.out.println(((JTextField) comp).getText());
				JTextField campo = (JTextField) comp;
				campo.setText("");
			}
		}
	}
	
}
