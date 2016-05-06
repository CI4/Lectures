package vn.edu.techkids.controllers;

import vn.edu.techkids.models.Bullet;
import vn.edu.techkids.models.GameConfig;
import vn.edu.techkids.views.ImageDrawer;

/**
 * Created by qhuydtvt on 4/29/2016.
 */
public class BulletController extends SingleController {

    public static final int SPEED = 15;

    public BulletController(Bullet gameObject, ImageDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        gameVector.dy = -SPEED;
    }

    @Override
    public void run() {
        super.run();
        if(!GameConfig.getInst().isInScreen(this.gameObject)){
            this.gameObject.setAlive(false);
        }
    }
}
