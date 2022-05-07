package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonFactoryTest {

	// On mock la classe pokemonFactory
	IPokemonFactory pokemonFactory = Mockito.mock(IPokemonFactory.class);
	// On declare trois variables de type Pokemon qui seront utilisées pour les tests
	Pokemon bulbizarre;
	Pokemon aquali;
	Pokemon pikachu;
 
	@Before
	public void init() {
		// On instancie trois objets Pokemon
		bulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56.0);
		aquali = new Pokemon(133, "Aquali", 186, 186, 260, 2729, 202, 5000, 4, 100.0);
		pikachu = new Pokemon(120, "Pikachu", 342, 344, 100, 324, 45, 1000, 6, 40.0);
	}

	@Test
	public void createPokemonTest() {
		Mockito.when(pokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(bulbizarre);
		Mockito.when(pokemonFactory.createPokemon(133, 2729, 202, 5000, 4)).thenReturn(aquali);
		Mockito.when(pokemonFactory.createPokemon(6, 324, 45, 1000, 6)).thenReturn(pikachu);
		Assert.assertEquals(bulbizarre, pokemonFactory.createPokemon(0, 613, 64, 4000, 4));
		Assert.assertEquals(aquali, pokemonFactory.createPokemon(133, 2729, 202, 5000, 4));
		Assert.assertEquals(pikachu, pokemonFactory.createPokemon(6, 324, 45, 1000, 6));
	}

}
