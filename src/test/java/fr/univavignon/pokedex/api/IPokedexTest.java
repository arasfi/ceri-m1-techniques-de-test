package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import org.junit.Assert;

public class IPokedexTest {

	IPokedex pokedex;
	Pokemon bulbizarre;
	Pokemon pikatchu;
	Pokemon aquali;
	ArrayList<Pokemon> pokemons;

	@Before
	public void init() {

		pokedex = Mockito.mock(IPokedex.class);
		pokemons = new ArrayList<>();
		bulbizarre = new Pokemon(1, "Bulbizarre", 100, 12, 9, 13, 4, 200, 5, 66.0);
		pikatchu = new Pokemon(0, "Pikatchu", 126, 126, 90, 613, 64, 4000, 4, 56.0);
		aquali = new Pokemon(133, "Aquali", 186, 186, 260, 2729, 202, 5000, 4, 100.0);
		pokemons.add(bulbizarre);
		pokemons.add(pikatchu);
		pokemons.add(aquali);


	}

	@Test
	public void sizeTest() {
		Mockito.doReturn(pokemons.size()).when(pokedex).size();
		Assert.assertEquals(3, pokedex.size());
	}

	@Test
	public void addPokemonTest() {
		Mockito.doReturn(pikatchu.getIndex()).when(pokedex).addPokemon(pikatchu);
		Assert.assertEquals(0, pokedex.addPokemon(pikatchu));
	}

	@Test
	public void getPokemonTest() throws PokedexException {
		Mockito.doReturn(aquali).when(pokedex).getPokemon(133);
		Mockito.doReturn(pikatchu).when(pokedex).getPokemon(0);
		Mockito.doReturn(bulbizarre).when(pokedex).getPokemon(1);
		Assert.assertEquals(bulbizarre, pokedex.getPokemon(1));
		Assert.assertEquals(pikatchu, pokedex.getPokemon(0));
		Assert.assertEquals(aquali, pokedex.getPokemon(133));

		Mockito.doThrow(new PokedexException("Index du pokemon introuvable")).when(pokedex)
				.getPokemon(Mockito.intThat(i -> i < 0 || i > 150));
		Assert.assertThrows(PokedexException.class, () -> pokedex.getPokemon(300));
		Assert.assertThrows(PokedexException.class, () -> pokedex.getPokemon(-2));

	}

	@Test
	public void getPokemonsTest() {
		List<Pokemon> pokemonList = Collections.unmodifiableList(pokemons);
		Mockito.doReturn(pokemonList).when(pokedex).getPokemons();
		Assert.assertEquals(pokemons.size(), pokedex.getPokemons().size());
		Assert.assertEquals(pokemons, pokedex.getPokemons());
		Assert.assertEquals(bulbizarre, pokedex.getPokemons().get(0));
		Assert.assertEquals(pikatchu, pokedex.getPokemons().get(1));
		Assert.assertEquals(aquali, pokedex.getPokemons().get(2));
		Assert.assertEquals(pokemonList.getClass(), pokedex.getPokemons().getClass());

	}
	
	@Test
	public void getPokemonsCompTest() {
		
		List<Pokemon> pokemonsParIndex = List.of(pikatchu, aquali);
		List<Pokemon> pokemonsParCp = List.of(pikatchu, aquali);
		List<Pokemon> pokemonsParName = List.of(aquali, pikatchu);
		
		IPokedex pokedex = Mockito.mock(IPokedex.class);
		
		Mockito.doReturn(pokemonsParIndex).when(pokedex).getPokemons(PokemonComparators.INDEX);
		Mockito.doReturn(pokemonsParCp).when(pokedex).getPokemons(PokemonComparators.CP);
		Mockito.doReturn(pokemonsParName).when(pokedex).getPokemons(PokemonComparators.NAME);
		
		
		Assert.assertEquals(pokemonsParIndex, pokedex.getPokemons(PokemonComparators.INDEX));
		Assert.assertEquals(pokemonsParCp, pokedex.getPokemons(PokemonComparators.CP));
		Assert.assertEquals(pokemonsParName, pokedex.getPokemons(PokemonComparators.NAME));
	}

}