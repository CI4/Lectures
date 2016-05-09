package vn.edu.techkids.controllers;

import vn.edu.techkids.models.EnemyPlane;
import vn.edu.techkids.models.GameConfig;
import vn.edu.techkids.views.ImageDrawer;

/**
 * Created by qhuydtvt on 5/6/2016.
 */
public class EnemyPlaneControllerManager extends ControllerManager {

    private int count = 0;
    private int planeType = 0;

    private EnemyPlaneControllerManager() {
        super();
    }

    @Override
    public void run() {
        super.run();
        count++;
        if(GameConfig.getInst().durationInSeconds(count) > 2) {
            count = 0;
            planeType++;
                for (int x = 40; x < GameConfig.getInst().
                        getScreenWidth() - 40; x += 100) {
                    if(planeType % 2 == 0) {
                        this.singleControllerVector.add(
                                EnemyPlaneController.create(EnemyPlaneType.BLACK, x, 0)
                        );
                    }
                    else {
                        this.singleControllerVector.add(
                                EnemyPlaneController.create(EnemyPlaneType.WHITE, x, 0)
                        );
                    }
                }
        }
    }

    private static EnemyPlaneControllerManager inst;
    public static EnemyPlaneControllerManager getInst() {
        if(inst == null) {
            inst = new EnemyPlaneControllerManager();
        }

        return inst;
    }
}
