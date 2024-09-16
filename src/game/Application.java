package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.actors.Player;
import game.grounds.*;
import game.items.Scrap;
import game.utils.FancyMessage;
import game.weapon_items.AttackItem;


/**
 * The main class to start the game.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 * Teo Shi Yang
 *
 */
public class Application {

    public static void main(String[] args) {

        World world = new World(new Display());

        FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(),
                new Wall(), new Floor(), new Puddle(), new Inheritree(), new Crater());

        List<String> map = Arrays.asList(
                        "...~~~~.........~~~...........",
                        "...~~~~.......................",
                        "...~~~........................",
                        ".........................t....",
                        ".............#####............",
                        ".....u.......#___#...........~",
                        ".............#___#..........~~",
                        ".............##_##....u....~~~",
                        ".....u........t..~~........~~~",
                        "......t.........~~~~....u..~~~",
                        ".............~~~~~~~........~~",
                        "......~.....~~~~~~~~.........~",
                        ".....~~~...~~~~~~~~~..........",
                        ".....~~~~~~~~~~~~~~~~........~",
                        ".....~~~~~~~~~~~~~~~~~~~....~~");

        GameMap gameMap = new GameMap(groundFactory, map);
        world.addGameMap(gameMap);

        for (String line : FancyMessage.TITLE.split("\n")) {
            new Display().println(line);
            try {
                Thread.sleep(200);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }



        gameMap.at(15, 9).addItem(new Scrap("Metal Sheet", '%'));
        gameMap.at(15, 10).addItem(new Scrap("Large Bolt", '+'));
        gameMap.at(15,11).addItem(new AttackItem("Metal Pipe", '!', 1, "attacks",20));

        Player player = new Player("Intern", '@', 4);
        world.addPlayer(player, gameMap.at(15, 6));



        world.run();

        for (String line : FancyMessage.YOU_ARE_FIRED.split("\n")) {
            new Display().println(line);
            try {
                Thread.sleep(200);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}
