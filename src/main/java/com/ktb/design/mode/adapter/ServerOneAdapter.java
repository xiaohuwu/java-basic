package com.ktb.design.mode.adapter;

//ServerOneAdapter 就是适配器
public class ServerOneAdapter implements PlayerCount{

    ServerOne serverOne;

    public ServerOneAdapter(ServerOne serverOne) {
        this.serverOne = serverOne;
    }

    @Override
    public String getServerName() {
        return serverOne.getServerName();
    }

    @Override
    public int getPlayCount() {
        return serverOne.count();
    }
}
