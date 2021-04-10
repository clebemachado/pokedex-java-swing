package utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class Finaliza implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		int confirm = JOptionPane.showConfirmDialog (null,
				"Deseja Realmente sair?",
				"Sair - Confirmação",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE);
				if (confirm == JOptionPane.YES_OPTION) {
					System.exit(1);
				}
	}
}
