package com.candymobi.todaynewinformation.main.Tools;

import android.support.annotation.IntDef;


import static com.candymobi.todaynewinformation.main.Tools.MainContentTool.HANGZHOU;
import static com.candymobi.todaynewinformation.main.Tools.MainContentTool.BEIJING;
import static com.candymobi.todaynewinformation.main.Tools.MainContentTool.SHANGHAI;
import static com.candymobi.todaynewinformation.main.Tools.MainContentTool.SHENZHEN;

@IntDef({HANGZHOU,SHANGHAI,BEIJING,SHENZHEN})
public @interface MainContentTool {

    int SHANGHAI=0;
    int HANGZHOU=1;
    int BEIJING=2;
    int SHENZHEN=3;

}
