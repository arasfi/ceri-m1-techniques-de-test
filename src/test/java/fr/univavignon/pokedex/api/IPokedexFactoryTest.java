package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
 
public class IPokedexFactoryTest {

	IPokedexFactory pokedexFactory = new PokedexFactory();
	IPokemonMetadataProvider pokemonMetadataProvider = new PokemonMetadataProvider();
	IPokemonFactory pokemonFactory = new PokemonFactory(); ;
	IPokedex pokedex = new Pokedex(pokemonFactory, pokemonMetadataProvider);
	PokemonMetadata aquali;
	PokemonMetadata pikatchu;
	PokemonMetadata bulbizarre;

	@Before
	public void init() {
		bulbizarre = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
		pikatchu = new PokemonMetadata(0, "Pikatchu", 100, 50, 80);
		aquali = new PokemonMetadata(133, "Aquali", 186, 186, 260);

	}

	@Test
	public void createPokedexTest() {

		Assert.assertEquals(pokedex.getClass(), pokedexFactory
				.createPokedex(pokemonMetadataProvider, pokemonFactory).getClass());
		Assert.assertNotNull(pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory));
		

	}
}
