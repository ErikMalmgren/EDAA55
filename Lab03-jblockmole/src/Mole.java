public class Mole {

	private Graphics g = new Graphics(30, 50, 10);

	public static void main(String[] args) {
		Mole m = new Mole();
		m.drawWorld();
		m.dig();
	}

	public void drawWorld() {
		g.rectangle(0, 15, 30, 35, Colors.SOIL);
		g.rectangle(0, 14, 30, 1, Colors.GRASS);
		g.rectangle(0, 0, 30, 14, Colors.SKY);

	}

	public void dig() {
		int x = g.getWidth() / 2;
		int y = g.getHeight() / 2;

		while (true) {
			g.block(x, y, Colors.MOLE);
			char key = g.waitForKey();
			if (key == 'w') {
				if (y == 14) {					// kolla om mullvaden når himmeln
					g.block(x, y, Colors.MOLE);
				} else {
					g.block(x, y, Colors.TUNNEL);
					y--;
					g.block(x, y, Colors.MOLE);
				}

			} else if (key == 'a') {
				if (x == 0) { 					// Kolla om mullvaden slår i vänsterkant
					g.block(x, y, Colors.MOLE);
				} else {
					if (y == 14) {				// Gräset i vänsterled
						g.block(x, y, Colors.GRASS);

					} else {
						g.block(x, y, Colors.TUNNEL);

					}
					x--;
					g.block(x, y, Colors.MOLE);
				}
			} else if (key == 's') {
				if (y == 49) {					//Kolla om mullvaden slår i botten
					g.block(x, y, Colors.MOLE);
				} else {
					if (y == 14) {				// Gräset i höjdled
						g.block(x, y, Colors.GRASS);
					} else {
						g.block(x, y, Colors.TUNNEL);
					}
					y++;
					g.block(x, y, Colors.MOLE);
				}

			} else if (key == 'd') {
				if (x == 29) {					// Kolla om mullvaden slår i högerkanten
					g.block(x, y, Colors.MOLE);
				} else {

					if (y == 14) {				//Gräset i högerled
						g.block(x, y, Colors.GRASS);
					} else {
						g.block(x, y, Colors.TUNNEL);

					}
					x++;
					g.block(x, y, Colors.MOLE);
				}

			}

		}
	}
}
