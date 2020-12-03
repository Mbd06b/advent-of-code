package com.worscipe.aoc;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;


public class AdventSummary {

    private LocalDate date;
    private String title;
    private String  description;
    private BigDecimal solution; 

    public void setDate(LocalDate date){
        this.date = date;
    }
    public void setDate(Date date){
        this.date = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

    }
    public LocalDate getDate(){
        return this.date;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return this.title;
    }
    public void setDescription(String desc){
        this.description = desc;
    }
    public String getDescription(){
        return this.description;
    }
    public void setSolution(BigDecimal solution){
        this.solution = solution;
    }
    public BigDecimal getSolution(){
        return this.solution;
    }

}