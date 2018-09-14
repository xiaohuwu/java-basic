package com.ktb.design.mode.adapter;

public class ServerThree implements PlayerCount {
    @Override
    public String getServerName() {
        return "三服";
    }

    @Override
    public int getPlayCount() {
        return Utility.getOnlinePlayerCount(3);
    }
}
