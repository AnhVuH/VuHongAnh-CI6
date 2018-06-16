package action;

import base.GameObject;

public interface Action {
    boolean run(GameObject owner); // trả về true nếu action đã thực hiện xong

    void reset();
}
