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

	Pokemon bulbizarre;
 
	@Before
	public void init() {
		IPokemonFactory pokemonFactory = new PokemonFactory();
		bulbizarre = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);
	}

	@Test
	public void createPokemonTest() {
		
		assertEquals(0, bulbizarre.getIndex());
		assertEquals(613, bulbizarre.getCp());
		assertEquals(64, bulbizarre.getHp());
		assertEquals(4000, bulbizarre.getDust());
		assertEquals(4, bulbizarre.getCandy());
		assertEquals("Bulbizarre", bulbizarre.getName());
		assertEquals(126, bulbizarre.getAttack());
		assertEquals(126, bulbizarre.getDefense());
		assertEquals(90, bulbizarre.getStamina());
	}

}
