package com.shivam.todo.Models;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.regex.Pattern;
@Entity
@Table(name="todos")

public class ToDo
{
    @Id
    private int id;
    @Column
    private String title;
    @Column
    private String content;
    @Column
    private String status;
    @Column
    private Date simpledate;
    @Column
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date jsondate;


    public ToDo()
    {
    }

    public ToDo(int id, String title, String content, String status, Date simpledate, Date jsondate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.status = status;
        this.simpledate = simpledate;
        this.jsondate = jsondate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getSimpledate() {
        return simpledate;
    }

    public void setSimpledate(Date simpledate) {
        this.simpledate = simpledate;
    }

    public Date getJsondate() {
        return jsondate;
    }

    public void setJsondate(Date jsondate) {
        this.jsondate = jsondate;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", status='" + status + '\'' +
                ", simpledate=" + simpledate +
                ", jsondate=" + jsondate +
                '}';
    }
}
