package utils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mostrar implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		FrameTablePokedex f = new FrameTablePokedex();
		f.setVisible(true);
	}
}