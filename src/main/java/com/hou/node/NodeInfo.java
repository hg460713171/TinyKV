package com.hou.node;

import com.hou.stateMachine.StateMachineSaveType;
import lombok.Data;

import java.util.List;

@Data
public class NodeInfo {

    public int selfNode;
    public List<String> peerNodes;
    public StateMachineSaveType stateMachineSaveType;

}
