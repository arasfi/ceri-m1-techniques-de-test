package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonTrainerFactoryTest {

	IPokedex pokedex;
	IPokemonTrainerFactory pokemonTrainerFactory;
	PokemonTrainer pokemonTrainer;
	IPokedexFactory pokemonFactory;

	@Before
	public void init() {
		pokedex = Mockito.mock(IPokedex.class);
		pokemonTrainerFactory = Mockito.mock(IPokemonTrainerFactory.class);
		pokemonFactory = Mockito.mock(IPokedexFactory.class);
		pokemonTrainer = new PokemonTrainer("Equipe 1", Team.MYSTIC, pokedex);

	}

	@Test
	public void createTrainerTest() {
		Mockito.doReturn(pokemonTrainer).when(pokemonTrainerFactory).createTrainer("Equipe 1", Team.MYSTIC, pokemonFactory);
		Assert.assertEquals(pokemonTrainer.getClass(),
				pokemonTrainerFactory.createTrainer("Equipe 1", Team.MYSTIC, pokemonFactory).getClass());
		Assert.assertEquals(pokemonTrainer, pokemonTrainerFactory.createTrainer("Equipe 1", Team.MYSTIC, pokemonFactory));
		Assert.assertEquals("Equipe 1",
				pokemonTrainerFactory.createTrainer("Equipe 1", Team.MYSTIC, pokemonFactory).getName());
		Assert.assertEquals(Team.MYSTIC,
				pokemonTrainerFactory.createTrainer("Equipe 1", Team.MYSTIC, pokemonFactory).getTeam());
		Assert.assertEquals(pokedex,
				pokemonTrainerFactory.createTrainer("Equipe 1", Team.MYSTIC, pokemonFactory).getPokedex());
		Assert.assertEquals(pokedex.size(),
				pokemonTrainerFactory.createTrainer("Equipe 1", Team.MYSTIC, pokemonFactory).getPokedex().size());
	}
}
