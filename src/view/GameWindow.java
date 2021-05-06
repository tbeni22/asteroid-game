package view;

import control.Game;
import map.asteroid.Asteroid;
import map.asteroid.BaseAsteroid;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * The game's main window.
 */
public class GameWindow extends JFrame {
    /**
     * The instance of the singleton GameWindow class.
     */
    private static final GameWindow instance = new GameWindow();

    private SettlerActionsView actionsView;
    private SettlerInventoryView inventoryView;
    private AsteroidStatusView asteroidStatusView;

    /*
        private GameStatusView gameStatusView;
        private MapView mapView;
        private AsteroidStatusView asteroidStatusView;
        private SettlerActionsView settlerActionView; // TODO: docsban actionView-ként szerepel
        private SettlerInventoryView settlerInventoryView;
     */

    /**
     * Creates a GameWindow object.
     */
    private GameWindow() {
        super("Asteroid mining game");
        Dimension windowSize = new Dimension(1280, 720);
        this.setPreferredSize(windowSize);
        this.setMinimumSize(windowSize); // TODO: teszteléshez ezt majd lehet célszerű kikommentezni
        this.setLocationRelativeTo(null); // place the window in the center of the screen
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        JScrollPane scrollPane = new JScrollPane(panel);


        this.add(scrollPane, BorderLayout.CENTER);

        actionsView = new SettlerActionsView();
        this.add(actionsView, BorderLayout.SOUTH);

        inventoryView = new SettlerInventoryView();
        this.add(inventoryView, BorderLayout.WEST);

        asteroidStatusView = new AsteroidStatusView();
        this.add(asteroidStatusView, BorderLayout.EAST);

        // TODO: ezt majd ki kell venni
        AsteroidView av = new AsteroidView(Game.getInstance().getMap().getBaseAsteroid());
        av.setStatusView(asteroidStatusView);
        panel.add(av);
//        panel.add(new AsteroidView(new BaseAsteroid()));
//        panel.add(new AsteroidView(new Asteroid("Asteroid1", false, 2, 1)));
//        panel.add(new AsteroidView(new Asteroid("Asteroid2", false, 3, 1)));
//        panel.add(new AsteroidView(new Asteroid("Asteroid3", false, 6, 1)));

        // TODO: initialize views, set layout
        this.pack();
    }

    /**
     * Starts the game.
     *
     * @param names A list containing the players' names.
     */
    public static void init(ArrayList<String> names) {
        Game.start(names);
    }

    /**
     * This method can be used to access the main window object outside this class.
     *
     * @return The instance of this singleton class.
     */
    public static GameWindow getInstance() {
        return instance;
    }
}
