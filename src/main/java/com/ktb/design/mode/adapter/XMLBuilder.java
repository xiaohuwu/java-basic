package com.ktb.design.mode.adapter;

public class XMLBuilder {

    public static String buildXML(PlayerCount player) {
        StringBuilder builder = new StringBuilder();
        builder.append("<root>");
        builder.append("<server>").append(player.getServerName()).append("</server>");
        builder.append("<player_count").append(player.getPlayCount()).append("</player_count>");
        builder.append("</root>");

        return builder.toString();
    }

}
