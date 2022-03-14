package com.lay.obx;

public interface OnDataChangeListener<T extends Object> {
    void update(Obx<T> obx);
}
