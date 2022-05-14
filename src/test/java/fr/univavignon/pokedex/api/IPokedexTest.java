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
	Pokemon pikatchu;
	Pokemon aquali;

	IPokedexFactory pokedexFactory;
	IPokemonMetadataProvider metadataProvider;
	IPokemonFactory pokemonFactory;

	@Before
	public void init() {
		pokedexFactory = new PokedexFactory();
		metadataProvider = new PokemonMetadataProvider();
		pokemonFactory = new PokemonFactory();
		pokedex = pokedexFactory.createPokedex(metadataProvider, pokemonFactory);
		

		pikatchu = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
		aquali = pokemonFactory.createPokemon(133, 2729, 202, 5000, 4);
		pokedex.addPokemon(pikatchu);
		pokedex.addPokemon(aquali);


	}

	@Test
	public void sizeTest() {
		assertEquals(2, pokedex.size());
	}

	@Test
	public void addPokemonTest() {
		assertEquals(2, pokedex.addPokemon(pikatchu));
	}

	@Test
	public void getPokemonTest() throws PokedexException {
		assertEquals(pikatchu, pokedex.getPokemon(0));
		assertEquals(aquali, pokedex.getPokemon(1));
		
		assertThrows(PokedexException.class, () -> pokedex.getPokemon(-1));

	}

	@Test
	public void getPokemonsTest() {
		assertEquals(2, pokedex.getPokemons().size());
		assertEquals(pikatchu, pokedex.getPokemons().get(0));
		assertEquals(aquali, pokedex.getPokemons().get(1));
	}
	 
	@Test
	public void getPokemonsCompTest() {
		assertEquals(pikatchu, pokedex.getPokemons(PokemonComparators.INDEX).get(0));
		assertEquals(aquali, pokedex.getPokemons(PokemonComparators.INDEX).get(1));

		assertEquals(pikatchu, pokedex.getPokemons(PokemonComparators.CP).get(0));
		assertEquals(aquali, pokedex.getPokemons(PokemonComparators.CP).get(1));

		
		assertEquals(aquali, pokedex.getPokemons(PokemonComparators.NAME).get(0));
		assertEquals(pikatchu, pokedex.getPokemons(PokemonComparators.NAME).get(1));
	}

}