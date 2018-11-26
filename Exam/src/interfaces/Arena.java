package interfaces;

import java.util.List;

public interface Arena {
     String getArenaName();
	 boolean isArenaFull();
	 void addHero(ComicCharacter hero);
	 void addAntiHero(ComicCharacter antiHero);
	 boolean fightHeroes();

	List<ComicCharacter> getHeroes();
	List<ComicCharacter> getAntiHeroes();
}
