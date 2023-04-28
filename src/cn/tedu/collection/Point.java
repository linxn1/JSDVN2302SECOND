package cn.tedu.collection;

import java.util.Objects;

public class Point implements Comparable<Point> {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    /**
     * 接口中的compareTo方法定义规则
     * compareTo
     * A.compareTo(B)
     * A 大于 B 返回正数
     * A 等于 B 返回0
     * A 小于 B 返回负数
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Point o) {
        //定义比较两个点的x坐标
        int x1 = this.getX();
        int x2 = o.getX();
//        if (x1 - x2 > 0) {
//            return 1;
//        } else if (x1 - x2 < 0) {
//            return -1;
//        } else {
//            return 0;
//        }
        return x1 - x2;
    }
}
