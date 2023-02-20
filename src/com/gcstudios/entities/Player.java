package com.gcstudios.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.gcstudios.main.Game;
import com.gcstudios.world.World;

public class Player extends Entity {

	public static boolean isPressed = false;

	public Player(int x, int y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);

	}

	public void tick() {
		depth = 2;
		if (!isPressed) {
			y += 2;

		} else {
			if (y > 0) {
				y -= 2;
			}
		}
		if (y > Game.HEIGHT) {
			World.restartGame();
			return;
		}

		for (int i = 0; i < Game.entities.size(); i++) {
			Entity e = Game.entities.get(i);
			if (e != this) {
				if (Entity.isColidding(this, e)) {
					World.restartGame();
					return;
				}

			}

		}

	}

	public void render(Graphics g) {
		// teste de mascara
		/*
		 * g.setColor(Color.red); g.fillRect(this.getX(), this.getY(), 16, 16);
		 */
		if (!isPressed) {
			g.drawImage(BIRDDOWN, this.getX(), this.getY(), null);

		} else {
			g.drawImage(BIRDFLY, this.getX(), this.getY(), null);
		}
	}

}
