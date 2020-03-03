package pipes.nodes;

import pipes.edges.Pipe;
import pipes.enums.NodeType;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

//узел
public class PipeNode {
    private NodeType type;
    private Point position;
//    private List<PipeNode> pipeNodeList = new ArrayList<>();
//    private List<Pipe> pipeList = new ArrayList<>();//не знаю зачем лис ребер если между узлами всего одно ребро
    private int diameter;


    public PipeNode(NodeType type, Point position, int diameter) {
        this.type = type;
        this.position = position;
        this.diameter = diameter;
    }

    public int getDiameter() {
        return diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    public NodeType getType() {
        return type;
    }

    public void setType(NodeType type) {
        this.type = type;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

//    public List<Pipe> getPipeList() {
//        return pipeList;
//    }

//    public Pipe getPipe(int id) {
//        return pipeList.get(id);
//    }
//
//    public void addPipe(Pipe pipe) {
//        this.pipeList.add(pipe);
//    }
//
//    public List<PipeNode> getPipeNodeList() {
//        return pipeNodeList;
//    }
//
//    public PipeNode getPipeNode(int id) {
//        return pipeNodeList.get(id);
//    }
//
//    public void addPipeNode(PipeNode pipeNode) {
//        this.pipeNodeList.add(pipeNode);
//    }
}
