package org.foobarspam.main;

import org.foobarspam.item.CompuestoItem;
import org.foobarspam.item.Item;
import org.foobarspam.item.SimpleItem;

import java.awt.*;

/**
 * Created by mariano.palliser on 06/06/2017.
 */
public class Main {

	public static void main(String[] args) {

		System.out.println("\n *** crear item simple y testear su nombre *** \n");

		Item lakers = new SimpleItem("Lakers");
		lakers.setCompuesto(false);

		System.out.println("equipo: " + lakers.getNombre());

		System.out.println("\n *** crear item compuesto y testear su nombre *** \n");

		Item pacific = new CompuestoItem("Pacific");
		pacific.setCompuesto(true);

		System.out.println("división: "+ pacific.getNombre());

		System.out.println("\n *** añadir item simple a compuesto y comprobar nombre *** \n");

		pacific.anhadir(lakers);

		System.out.println("\n *** recorrer un item compuesto mostrando su nombre y el de sus hijos: 1 hijo, profundidad 1 *** \n");

		pacific.iterable();

		System.out.println("\n ***añadir varios hijos desde array de strings y recorrer un item compuesto mostrando su nombre y el de sus hijos: n hijos, profundidad 1 *** \n");

		String[] equiposAtlantic = {"Celtics", "Nets", "Knicks", "76ers", "Raptors"};
		Item atlantic = new CompuestoItem("Atlantic");
		atlantic.setCompuesto(true);
		atlantic.composite(equiposAtlantic);

		atlantic.iterable();

		System.out.println("\n *** recorrer un item compuesto por otros compuestos, mostrando su nombre y el de sus hijos: n hijos, profundidad n *** \n");

		Item nba = new CompuestoItem("NBA");
		nba.setCompuesto(true);

		Item este = new CompuestoItem("Este");
		este.setCompuesto(true);

		este.anhadir(atlantic);
		nba.anhadir(este);

		nba.iterable();

		System.out.println("\n *** crear un elemento compuesto de simples a partir de un array de strings *** \n");

		String[] equiposCentral = {"Bulls", "Cavs", "Pistons", "Pacers", "Bucks"};
		Item central = new CompuestoItem("Central");
		central.setCompuesto(true);

		central.composite(equiposCentral);

		central.iterable();

		System.out.println("\n *** crear un elemento compuesto de elementos compuestos a partir de un array de objetos simples *** \n");

		String[] equiposSouthEast = {"Heat", "Hawks", "Hornets", "Wizzards", "Magic"};
		Item southEast = new CompuestoItem("SouthEast");
		southEast.setCompuesto(true);

		southEast.composite(equiposSouthEast);

		southEast.iterable();

		System.out.println("\n *** crear un elemento compuesto de elementos compuestos a partir de un array de objetos compuestos *** \n");

		Item[] divisiones = {central, southEast};

		este.composite(divisiones);

		este.iterable();

		System.out.println("\n *** eliminar un hijo a profundidad n *** \n");

		este.quitar("Atlantic");
		este.iterable();

		System.out.println("\n *** Liga NBA completa con sus conferencias, divisiones y equipos *** \n");

		Item oeste = new CompuestoItem("Oeste");
		oeste.setCompuesto(true);

		String[] equiposNoroeste = {"Denver", "Minnesota", "Oklahoma", "Portland", "Utah"};
		Item noroeste = new CompuestoItem("Noroeste");
		noroeste.setCompuesto(true);
		noroeste.composite(equiposNoroeste);

		String[] equiposSuroeste = {"Dallas", "Houston", "Memphis", "Pelicans", "Spurs"};
		Item suroeste = new CompuestoItem("Suroeste");
		suroeste.setCompuesto(true);
		suroeste.composite(equiposSuroeste);

		String[] equiposPacifico = {"Warriors", "Clippers", "Lakers", "Suns", "Kings"};
		Item pacifico = new CompuestoItem("Pacifico");
		pacifico.setCompuesto(true);
		pacifico.composite(equiposPacifico);

		Item[] oesteEquipos = {noroeste, suroeste, pacifico};
		oeste.composite(oesteEquipos);

		nba.anhadir(oeste);

		nba.iterable();






	}
}
