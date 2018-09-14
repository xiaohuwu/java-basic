package com.ktb.design.mode.observer;

import java.util.ArrayList;
import java.util.List;

//被观察对象
public class Subject {
  private List<Observer> list = new ArrayList<>();

  public void register(Observer observer){
      list.add(observer);
  }

  public void  notifyObserver(String message){
      for(Observer observer :list){
          observer.update(message);
      }
  }

}
