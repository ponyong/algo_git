package me.noahlee;

import java.io.IOException;
import java.util.*;

class Road implements Comparable<Road>{
    int x, y, cost, direction; //0이면 가로, 1이면 세로

    public Road(int x, int y, int cost, int direction) {
        this.x = x;
        this.y = y;
        this.cost = cost;
        this.direction = direction;
    }

    static Road makeRoad(int x, int y, int cost, int direction) {
        return new Road(x, y, cost, direction);
    }

    @Override
    public String toString() {
        return "Road{" +
            "x=" + x +
            ", y=" + y +
            ", cost=" + cost +
            ", direction=" + direction +
            '}';
    }


    @Override
    public int compareTo(Road o) {
        return cost - o.cost;
    }
}


class Solution {
    static Queue<Road> pq = new LinkedList<>();
    static final int STRAIGHT = 100;
    static final int CORNER = 500;
    static int[][] map = new int[26][26];
    static int[] px = {0,0,-1,1};//상, 하, 좌, 우
    static int[] py = {-1,1,0,0};

    public int solution(int[][] board) {
        pq = new LinkedList<>();
        pq.add(new Road(0,0,0,0));
        pq.add(new Road(0,0,0,1));
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(map[i],(STRAIGHT+CORNER)*25);
        }

        while (!pq.isEmpty()) {
            Road road = pq.poll();
            int curX = road.x;
            int curY = road.y;
            int curDirection = road.direction;
            int curCost = road.cost;

            for (int i = 0; i < 4; i++) {
                int forX = curX + px[i];
                int forY = curY + py[i];
                if (!(0<=forX&&forX<board.length&&0<=forY&&forY<board.length))continue;
                if (board[forX][forY] == 1) continue;
                int forDirection = curX == forX ? 1 : 0;
                int forCost = curDirection == forDirection ? curCost + STRAIGHT :  curCost + CORNER + STRAIGHT;
                if (map[forX][forY] >= forCost) {
                    map[forX][forY] = forCost;
                    pq.add(Road.makeRoad(forX,forY,forCost,forDirection));
                }
            }
        }
        return map[board.length-1][board.length-1];
    }


}