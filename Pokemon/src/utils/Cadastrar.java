package utils;

import entidade.Pokemon;
import entidade.PokemonDAO;

public class Cadastrar {

	
	public void addPokemons(Integer numero, String nome, String tipo, Integer hp, 
							Integer atk, Integer def, String habilidade) {
		
		Pokemon p = new Pokemon();
		p.setNumero_da_pokedex(numero);p.setNome(nome);	p.setTipo(tipo);
		p.setHp(hp); p.setAtaque(atk);	p.setDefesa(def);p.setHabilidade(habilidade);

		PokemonDAO dao = new PokemonDAO();
		dao.adiciona(p);
	}
	
}
