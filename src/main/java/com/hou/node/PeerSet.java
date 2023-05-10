package com.hou.node;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Data
public class PeerSet implements Serializable {

    private List<PeerNode> list = new ArrayList<>();

    private volatile PeerNode leader;

    /** final */
    private volatile PeerNode self;

    private PeerSet() {
    }

    public static PeerSet getInstance() {
        return PeerSetLazyHolder.INSTANCE;
    }


    private static class PeerSetLazyHolder {

        private static final PeerSet INSTANCE = new PeerSet();
    }

    public void setSelf(PeerNode peer) {
        self = peer;
    }

    public PeerNode getSelf() {
        return self;
    }

    public void addPeer(PeerNode peer) {
        list.add(peer);
    }

    public void removePeer(PeerNode peer) {
        list.remove(peer);
    }

    public List<PeerNode> getPeers() {
        return list;
    }

    public List<PeerNode> getPeersWithOutSelf() {
        List<PeerNode> list2 = new ArrayList<>(list);
        list2.remove(self);
        return list2;
    }



}
