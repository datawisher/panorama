package cn.datawisher.design.pattern.state;

import cn.datawisher.design.pattern.state.ui.Player;
import cn.datawisher.design.pattern.state.ui.UI;

/**
 * Demo class. Everything comes together here.
 */
public class Client {
    public static void main(String[] args) {
        Player player = new Player();
        UI ui = new UI(player);
        ui.init();
    }
}
