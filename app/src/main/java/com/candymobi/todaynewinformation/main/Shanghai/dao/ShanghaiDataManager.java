package com.candymobi.todaynewinformation.main.Shanghai.dao;

import android.util.Log;

import java.util.ArrayList;

public class ShanghaiDataManager {
    /**
     * 获取竖向数据
     *
     * @param len
     * @return
     */
    private static ArrayList<ShanghaiBean> getVerData(int len) {
        ArrayList<ShanghaiBean> data = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            ShanghaiBean bean = new ShanghaiBean();
            bean.setShowImg(false).setmDec("上海欢迎您");
            data.add(bean);
        }
        return data;
    }

    /**
     * 获取横向数据
     *
     * @param len
     * @return
     */
    private static ArrayList<ShanghaiBean> getHorData(int len) {
        ArrayList<ShanghaiBean> data = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            ShanghaiBean bean = new ShanghaiBean();
            bean.setShowImg(true).setmDec("上海是魔都");
            data.add(bean);
        }
        return data;
    }

    public static ArrayList<ShanghaiBean> getData() {
        ArrayList<ShanghaiBean> data = new ArrayList<>();
        data.addAll(getVerData(5));
        data.add(new ShanghaiBean().setData(getHorData(10)).setmItemType(ShanghaiBean.IShangHaiItemType.HORIZONTAL));
        data.addAll(getVerData(5));
        data.add(new ShanghaiBean().setData(getHorData(10)).setmItemType(ShanghaiBean.IShangHaiItemType.HORIZONTAL));

        return data;
    }
}
