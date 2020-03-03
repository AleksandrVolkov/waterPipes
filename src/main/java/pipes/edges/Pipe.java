package pipes.edges;

import pipes.enums.PipeType;
import pipes.nodes.PipeNode;

import java.awt.*;

// ребро графа
public class Pipe {
    private PipeType type;
    private PipeNode prevNode;
    private PipeNode nextNode;
    private int longPipe;
    private Point startPosition;
    private Point endPosition;
    private int diameterPipe;

    public Pipe(PipeType type, int longPipe, int diameterPipe) {
        this.type = type;
//        this.prevNode = prevNode;
//        this.nextNode = nextNode;
        this.longPipe = longPipe;
//        this.startPosition = startPosition;
//        this.endPosition = endPosition;
        this.diameterPipe = diameterPipe;
    }

//    public Pipe(PipeType type, int longPipe, int diameterPipe) {
//        this.type = type;
//        this.longPipe = longPipe;
//        this.diameterPipe = diameterPipe;
//    }

    public PipeType getType() {
        return type;
    }

    public void setType(PipeType type) {
        this.type = type;
    }

    public PipeNode getPrevNode() {
        return prevNode;
    }

    public void setPrevNode(PipeNode prevNode) {
        this.prevNode = prevNode;
    }

    public PipeNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(PipeNode nextNode) {
        this.nextNode = nextNode;
    }

    public int getLongPipe() {
        return longPipe;
    }

    public void setLongPipe(int longPipe) {
        this.longPipe = longPipe;
    }

    public Point getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(Point startPosition) {
        this.startPosition = startPosition;
    }

    public Point getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(Point endPosition) {
        this.endPosition = endPosition;
    }

    public int getDiameterPipe() {
        return diameterPipe;
    }

    public void setDiameterPipe(int diameterPipe) {
        this.diameterPipe = diameterPipe;
    }


}
