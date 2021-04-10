package interfaceProgramas;



import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import utils.Finaliza;
import utils.Limpar;
import utils.Mostrar;
import utils.Valida;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Main() {
		// Criando meus labels
		JLabel lNumero = new JLabel("Nº: ");
		lNumero.setBounds(20, 15, 60, 20);
		JLabel lNome = new JLabel("Nome: ");
		lNome.setBounds(120, 15, 60, 20);
		JLabel lTipo = new JLabel("Tipo: ");
		lTipo.setBounds(20, 45, 60, 20);
		JLabel lHp = new JLabel("Hp: ");
		lHp.setBounds(145, 45, 60, 20);
		JLabel lAtk = new JLabel("Atk: ");
		lAtk.setBounds(230, 45, 60, 20);
		JLabel lDefs = new JLabel("Def: ");
		lDefs.setBounds(320, 45, 60, 20);
		JLabel lHab = new JLabel("Habilidade: ");
		lHab.setBounds(20, 75, 80, 20);

		add(lNumero);
		add(lNome);
		add(lTipo);
		add(lHp);
		add(lAtk);
		add(lDefs);
		add(lHab);

		// Criando os inputs
		JTextField txtNumero = new JTextField();
		txtNumero.setBounds(55, 15, 50, 20);
		JTextField txtNome = new JTextField();
		txtNome.setBounds(170, 15, 230, 20);
		JTextField txtTipo = new JTextField();
		txtTipo.setBounds(55, 45, 75, 20);
		JTextField txtHp = new JTextField();
		txtHp.setBounds(170, 45, 50, 20);
		JTextField txtAtk = new JTextField();
		txtAtk.setBounds(260, 45, 50, 20);
		JTextField txtDef = new JTextField();
		txtDef.setBounds(350, 45, 50, 20);
		JTextField txtHab = new JTextField();
		txtHab.setBounds(90, 75, 310, 20);

		add(txtNumero);
		add(txtNome);
		add(txtTipo);
		add(txtHp);
		add(txtAtk);
		add(txtDef);
		add(txtHab);
		
		
		// Criando os botões
		JButton btCadastrar = new JButton("Cadastrar");
		btCadastrar.setBounds(20, 115, 95, 30);
		btCadastrar.addActionListener(new Valida(txtNumero, txtNome, txtTipo, txtHp, 
																txtAtk,txtDef, txtHab, this));
		
		JButton btPokedex = new JButton("Pokedex");
		btPokedex.setBounds(130, 115, 95, 30);
		btPokedex.addActionListener(new Mostrar());
		
		JButton btLimpar = new JButton("Limpar");
		btLimpar.setBounds(240, 115, 75, 30);
		btLimpar.addActionListener(new Limpar(this));

		JButton btSair = new JButton("Sair");
		btSair.setBounds(340, 115, 60, 30);
		btSair.addActionListener(new Finaliza());

		add(btCadastrar);
		add(btPokedex);
		add(btLimpar);
		add(btSair);

		setLayout(null);
		setSize(430, 200);
		setResizable(false); // deixar a janela sempre do mesmo tamanho
		setLocation(483, 284); // Posição configurada para o monitor 1366x768 px
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// frame.getContentPane().setBackground(Color.GRAY);
	}

	public static void main(String[] args) {

		new Main();
	}
	
}
