package com.ktb.design.mode.adapter;

public class ServerTwo implements PlayerCount {
    @Override
    public String getServerName() {
        return "二服";
    }

    @Override
    public int getPlayCount() {
        return Utility.getOnlinePlayerCount(2);
    }
}
