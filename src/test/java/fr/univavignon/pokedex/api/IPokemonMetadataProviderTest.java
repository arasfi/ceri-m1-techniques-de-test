package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonMetadataProviderTest {

	IPokemonMetadataProvider pokemonMetadataProvider;
	PokemonMetadata bulbizarreMeta;

	@Before
	public void init() {
		pokemonMetadataProvider = new PokemonMetadataProvider();
	}
 
	@Test
	public void getPokemonMetadataTest() throws PokedexException {
		bulbizarreMeta = pokemonMetadataProvider.getPokemonMetadata(0);
		Assert.assertEquals("Bulbizarre", bulbizarreMeta.getName());
		Assert.assertEquals(126, bulbizarreMeta.getAttack());
		Assert.assertEquals(126, bulbizarreMeta.getDefense());
		Assert.assertEquals(90, bulbizarreMeta.getStamina());
		Assert.assertThrows(PokedexException.class, () -> pokemonMetadataProvider.getPokemonMetadata(-189));
		Assert.assertThrows(PokedexException.class, () -> pokemonMetadataProvider.getPokemonMetadata(313));
	}

}
