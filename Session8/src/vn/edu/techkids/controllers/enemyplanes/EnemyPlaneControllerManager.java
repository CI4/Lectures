package vn.edu.techkids.controllers.enemyplanes;

import vn.edu.techkids.controllers.ControllerManager;
import vn.edu.techkids.controllers.SingleController;
import vn.edu.techkids.models.GameConfig;

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
        if(GameConfig.getInst().durationInSeconds(count) > 1) {
            count = 0;
            planeType++;
                for (int x = 40; x < GameConfig.getInst().
                        getScreenWidth() - 40; x += 100) {
                    if(planeType % 2 == 0) {
                        this.singleControllerVector.add(
                                EnemyPlaneController.create(EnemyPlaneType.YELLOW, x, 0)
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

    public void dieAll() {
        for(SingleController c : this.singleControllerVector) {
            ((EnemyPlaneController)c).die();
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
