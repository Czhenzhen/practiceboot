package com.highlig_spring4.ch3.conditional;

/**
 * Windows下所要创建的Bean的类
 *
 * @author changzhenzhen
 * @date 2018-10-18
 */
public class WindowsListService implements ListService {
    @Override
    public String showListCmd() {
        return "dir";
    }
}
