package com.gcstudios.world;

import com.gcstudios.entities.Entity;
import com.gcstudios.main.Game;

public class TuboGenerator {
	
	int time = 0;
	int targetTime = 60;
	
	public void tick() {
		time++;
		if(time == targetTime) {
			int altura1 = Entity.rand.nextInt(60 - 30) +30;
			int altura2 = Entity.rand.nextInt(60 - 30) +30;
			
			Tubo tubo1 = new Tubo(Game.WIDTH, 0, 20,altura1,1,Game.spritesheet.getSprite(48, 0, 16, 16));
			Tubo tubo2 = new Tubo(Game.WIDTH, Game.HEIGHT - altura2, 20,altura2,1,Game.spritesheet.getSprite(64, 0, 16, 16));
			Game.entities.add(tubo1);
			Game.entities.add(tubo2);
			time = 0;
		}
		
	}

}
