package com.github.keyboard3.developerinterview.entity;

import android.support.annotation.NonNull;

import com.github.keyboard3.developerinterview.Config;
import com.github.keyboard3.developerinterview.pattern.ProblemStateFactory;

import java.io.Serializable;

/**
 * 题目类实体
 *
 * @author keyboard3
 * @date 2017/9/3
 */

public class Problem implements Serializable, Comparable<Problem> {

    public Problem(String id, String title, String content, String answer, String source, int type, String audio) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.answer = answer;
        this.type = type;
        this.source = "";
    }

    public String id;
    public String title;
    public String content;
    public String answer;
    public String source;
    //1java 2android 3html
    public int type;

    public int getId() {
        return Integer.parseInt(id);
    }

    public void setType(String typeName) {
        type = ProblemStateFactory.getProblemType(typeName).getType();
    }

    public int getTypeIcon() {
        return ProblemStateFactory.getProblemType(type).getTypeIcon();
    }

    public String getStorageDir() {
        return Config.STORAGE_DIRECTORY + "/" + getTypeName();
    }

    public String getTypeName() {
        return ProblemStateFactory.getProblemType(type).getTypeStr();
    }

    @Override
    public String toString() {
        return "Problem{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", answer='" + answer + '\'' +
                ", type=" + type +
                '}';
    }

    @Override
    public int compareTo(@NonNull Problem problem) {
        return getId() - problem.getId();
    }
}
