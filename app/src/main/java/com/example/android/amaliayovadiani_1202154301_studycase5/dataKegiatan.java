package com.example.android.amaliayovadiani_1202154301_studycase5;

/**
 * Created by Asus on 25/03/2018.
 */

public class dataKegiatan {
    String todo;
    String desc;
    String prior;

    public dataKegiatan (String todo, String desc, String prior){
        this.todo=todo;
        this.desc=desc;
        this.prior=prior;
    }

    //method setter dan getter untuk to do deskripsi dan priotiritas
    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPrior() {
        return prior;
    }

    public void setPrior(String prior) {
        this.prior = prior;
    }
}

