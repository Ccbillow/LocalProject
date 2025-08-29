package org.example.auz.blind75.tool.graph;

public class Vertex {

    public int id;
    public Vertex[] neighbours;

    public Vertex(int id, Vertex[] neighbours) {
        this.id = id;
        this.neighbours = neighbours;
    }
}
