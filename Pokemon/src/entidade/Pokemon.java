package entidade;

public class Pokemon {

	private Integer numero_da_pokedex;
	private String nome;
	private String tipo;
	private Integer hp;
	private Integer ataque;
	private Integer defesa;
	private String habilidade;

	public Pokemon() {
		// construtor vazio
	}

	public Pokemon(Integer numero_da_pokedex, String nome, String tipo, Integer hp, Integer ataque, Integer defesa,
			String habilidade) {
		this.setNumero_da_pokedex(numero_da_pokedex);
		this.setNome(nome);
		this.setTipo(tipo);
		this.setHp(hp);
		this.setAtaque(ataque);
		this.setDefesa(defesa);
		this.setHabilidade(habilidade);
	}

	public Integer getNumero_da_pokedex() {
		return numero_da_pokedex;
	}

	public void setNumero_da_pokedex(Integer numero_da_pokedex) {
		this.numero_da_pokedex = numero_da_pokedex;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getHp() {
		return hp;
	}

	public void setHp(Integer hp) {
		this.hp = hp;
	}

	public Integer getAtaque() {
		return ataque;
	}

	public void setAtaque(Integer ataque) {
		this.ataque = ataque;
	}

	public Integer getDefesa() {
		return defesa;
	}

	public void setDefesa(Integer defesa) {
		this.defesa = defesa;
	}

	public String getHabilidade() {
		return habilidade;
	}

	public void setHabilidade(String habilidade) {
		this.habilidade = habilidade;
	}

	@Override
	public String toString() {
		return "Pokemon [numero_da_pokedex=" + numero_da_pokedex + ", nome=" + nome + ", tipo=" + tipo + ", hp=" + hp
				+ ", ataque=" + ataque + ", defesa=" + defesa + ", habilidade=" + habilidade + "]";
	}

}
