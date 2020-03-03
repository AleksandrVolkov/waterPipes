import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import pipes.edges.Pipe;
import pipes.enums.DirectionType;
import pipes.enums.NodeType;
import pipes.enums.PipeType;
import pipes.nodes.PipeNode;

import java.awt.*;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    static int min_x_range = 1;
    static int max_x_range = 50;
    static int min_y_range = 1;
    static int max_y_range = 50;
    static PipeNode startNode = new PipeNode(NodeType.START, new Point(min_x_range, 20), 20);
    static PipeNode endNode = new PipeNode(NodeType.END, new Point(max_x_range, 30), 20);
    static List<Pipe> pipeListStart = new ArrayList<>();

    @Override
    public void start(Stage stage) {
        Text text = new Text(100, 50, "Hello World!");
        text.setFont(new Font(20));
        Label l = new Label(text.getText());

        Scene scene = new Scene(new Group(text));

        stage.setTitle("Welcome to JavaFX!");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }

    //делаю лист ребер графа
    public static void main(String[] args) {
        PipeNode toilet = new PipeNode(NodeType.TOILET, new Point(30, min_y_range), 20);

//        List<Pipe> pipeListStart = new ArrayList<>();
        for (int i = 0; i < 30; i++)
            pipeListStart.add(new Pipe(PipeType.WATER, 5, 20));
        List<Pipe> pipeList = new ArrayList<>();

        straight(startNode, new PipeNode(NodeType.START, new Point(min_x_range, 5), 20), pipeList);
        int i = 123;
//        rec(startNode, toilet);

    }

//    Point direction(int curX, int curY, int fieldSizeX, int fieldSizeY, Pipe curPipe) {
//        DirectionType move = DirectionType.STAY;
//
//        Point p = new Point(0, 0);
//
//        if (curY < (fieldSizeY / 2) && curX == 0) {
//            move = DirectionType.UP;
//            p = new Point(0, -curPipe.getLongPipe());
//        } else {
//            move = DirectionType.DOWN;
//            p = new Point(0, curPipe.getLongPipe());
//        }
//        if (curX < (fieldSizeX / 2) && curY == 0) {
//            move = DirectionType.LEFT;
//            p = new Point(-curPipe.getLongPipe(), 0);
//        } else {
//            move = DirectionType.RIGHT;
//            p = new Point(curPipe.getLongPipe(), 0);
//        }
//        return p;
//    }

    Point findAnglePointOld(int x, int y, int num, int fieldSizeX, int fieldSizeY) {
        Point p = null;
        if (y == num && x != num)
            if (x < fieldSizeX / 2)
                p = new Point(0, num);
            else
                p = new Point(fieldSizeX, num);
        if (x == num && y != num)
            if (y < fieldSizeY / 2)
                p = new Point(num, 0);
            else
                p = new Point(num, fieldSizeY);
//        if (y == num && x == num)
//            p = null;

        return p;
    }

    static Point findAnglePoint(Point p1, Point p2) {
        if ((p1.x == min_x_range || p1.x == max_x_range) && (p1.y == min_y_range || p1.y == max_y_range))
            return new Point(p1.x, p2.y);
        else
            return new Point(p2.x, p1.y);
    }

    static Point findPosition(Point p1, Point p2, Pipe pipe) {
        if (p1.x == p2.x)
            if (p1.y < p2.y)
                return new Point(p1.x, p1.y + pipe.getLongPipe());
            else
                return new Point(p2.x, p2.y + pipe.getLongPipe());
        if (p1.y == p2.y)
            if (p1.x < p2.x)
                return new Point(p1.x + pipe.getLongPipe(), p1.y);
            else
                return new Point(p2.x + pipe.getLongPipe(), p2.y);

        return null;
    }

    //сделать метод который строит прямую из одной точки в другую
    //конец оказался меньше чем начало по координатам и в итоге конец с началом поменялись местами в рекурсии, надо как то решать
    static void straight(PipeNode start, PipeNode end, List<Pipe> pipeList) {
        int curX = start.getPosition().x;
        int curY = start.getPosition().y;
        int endX = end.getPosition().x;
        int endY = end.getPosition().y;
        if (curX == endX && curY == endY) return;

        Pipe curPipe;

        if (pipeListStart.size() != 0) {
            curPipe = pipeListStart.get(0);
            pipeListStart.remove(curPipe);
        } else return;
        PipeNode next = new PipeNode(NodeType.COUPLING, findPosition(start.getPosition(), end.getPosition(), curPipe), 20);
        curPipe.setPrevNode(start);
        curPipe.setNextNode(next);
        curPipe.setStartPosition(start.getPosition());
        curPipe.setEndPosition(next.getPosition());
        pipeList.add(curPipe);
        straight(next, end, pipeList);

    }

    public static void rec(PipeNode start, PipeNode end) {
        List<Pipe> pipeList = new ArrayList<>();
        int curX = start.getPosition().x;
        int curY = start.getPosition().y;
        int endX = end.getPosition().x;
        int endY = end.getPosition().y;

        Point anglePoint = findAnglePoint(start.getPosition(), end.getPosition());

//        Pipe curPipe = pipeListStart.get(0);
//        pipeListStart.remove(curPipe);

        while (curX == endX && curY == endY) {
            if (pipeListStart.size() != 0) {
                Pipe curPipe = pipeListStart.get(0);
                pipeListStart.remove(curPipe);
            } else return;


//            DirectionType move = direction(curX, curY, fieldSizeX, fieldSizeY);
//            Point move = direction(curX, curY, fieldSizeX, fieldSizeY, curPipe);
//            PipeNode next = new PipeNode(NodeType.COUPLING, new Point(curX + move.x, curY + move.y), 20);
//            curPipe.setPrevNode(start);
//            curPipe.setNextNode(next);
//            curPipe.setStartPosition(start.getPosition());
//            curPipe.setEndPosition(next.getPosition());
//
//            pipeList.add(curPipe);


        }

    }
}




































