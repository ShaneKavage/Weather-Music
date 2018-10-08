package com.kavage.weathermusic.BackgroundHandler;

import android.app.Activity;

public class BackgroundCodeManager {

    public void chooseHandler(int code, Activity act) {

        int stormCode = code/100;
        ThunderBackgroundHandler TBH = new ThunderBackgroundHandler();
        RainBackgroundHandler RBH = new RainBackgroundHandler();
        SnowBackgroundHandler SBH = new SnowBackgroundHandler();
        CloudBackgroundHandler CBH = new CloudBackgroundHandler();
        NormalBackgroundHandler NBH = new NormalBackgroundHandler();

        switch(stormCode) {
            case 2:
                TBH.setBackground(act);
                break;
            case 3:
                RBH.setBackground(act);
                break;
            case 5:
                SBH.setBackground(act);
                break;
            case 6:
                CBH.setBackground(act);
                break;
            case 8:
                if(code == 800) {
                    NBH.setBackground(act);
                }else {
                    CBH.setBackground(act);
                }
                break;
            default:
                NBH.setBackground(act);
        }
    }//End setBackground()
}
