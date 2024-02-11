package cn.datawisher.design.pattern.adapter;

public interface ScoreOperation {
    // 成绩排序
    int[] sort(int array[]);

    // 成绩查询
    int search(int array[], int key);
}
