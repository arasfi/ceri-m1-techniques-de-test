package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonTrainerFactoryTest {

	IPokemonTrainerFactory pokemonTrainerFactory;
	PokemonTrainer pokemonTrainer;
	IPokedexFactory pokedexFactory;

	@Before
	public void init() {
		pokemonTrainerFactory = new PokemonTrainerFactory();
		pokedexFactory = new PokedexFactory();
		pokemonTrainer = pokemonTrainerFactory.createTrainer("Equipe 1", Team.MYSTIC, pokedexFactory);
	}
 
	@Test
	public void createTrainerTest() {
		
		Assert.assertEquals(pokemonTrainer.getClass(),
				pokemonTrainerFactory.createTrainer("Equipe 1", Team.MYSTIC, pokedexFactory).getClass());
		
		Assert.assertEquals("Equipe 1", pokemonTrainer.getName());
		Assert.assertEquals(Team.MYSTIC, pokemonTrainer.getTeam());
	
	}
}
