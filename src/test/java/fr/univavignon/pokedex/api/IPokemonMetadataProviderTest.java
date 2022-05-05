package fr.univavignon.pokedex.api;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class IPokemonMetadataProviderTest {

	IPokemonMetadataProvider pokemonMetadataProvider;

	PokemonMetadata aqualiMeta;
	PokemonMetadata pikatchuMeta;
	PokemonMetadata bulbizarreMeta;

	@Before
	public void init() {
		pokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
		bulbizarreMeta = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
		pikatchuMeta = new PokemonMetadata(1, "pikatchu", 187, 187, 261);
		aqualiMeta = new PokemonMetadata(133, "Aquali", 186, 186, 260);
	}

	@Test
	public void getPokemonMetadataTest() throws PokedexException {

		// Mocking result
		Mockito.doReturn(aqualiMeta).when(pokemonMetadataProvider).getPokemonMetadata(133);
		Mockito.doReturn(pikatchuMeta).when(pokemonMetadataProvider).getPokemonMetadata(1);
		Mockito.doReturn(bulbizarreMeta).when(pokemonMetadataProvider).getPokemonMetadata(0);
		// Tests
		Assert.assertEquals(bulbizarreMeta, pokemonMetadataProvider.getPokemonMetadata(0));
		Assert.assertEquals(pikatchuMeta, pokemonMetadataProvider.getPokemonMetadata(1));
		Assert.assertEquals(aqualiMeta, pokemonMetadataProvider.getPokemonMetadata(133));
		
		Mockito.doThrow(new PokedexException("Indice inexistant ")).when(pokemonMetadataProvider)
				.getPokemonMetadata(Mockito.intThat(i -> i < 0 || i > 150));
		Assert.assertThrows(PokedexException.class, () -> pokemonMetadataProvider.getPokemonMetadata(-189));
		Assert.assertThrows(PokedexException.class, () -> pokemonMetadataProvider.getPokemonMetadata(313));
	}

}
