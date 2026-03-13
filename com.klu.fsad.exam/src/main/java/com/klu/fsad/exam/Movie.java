package com.klu.fsad.exam;

import javax.persistence.*;
@Entity
@Table(name="movie")
public class Movie
{

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int id;

 private String name;
 private String date;
 private String status;
 private String director;
 private double budget;

 public Movie() {}

 public Movie(String name, String date, String status, String director, double budget)
 {
  this.name = name;
  this.date = date;
  this.status = status;
  this.director = director;
  this.budget = budget;
 }

 public int getId() {
  return id;
 }

 public void setId(int id) {
  this.id = id;
 }

 public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }

 public String getDate() {
  return date;
 }

 public void setDate(String date) {
  this.date = date;
 }

 public String getStatus() {
  return status;
 }

 public void setStatus(String status) {
  this.status = status;
 }

 public String getDirector() {
  return director;
 }

 public void setDirector(String director) {
  this.director = director;
 }

 public double getBudget() {
  return budget;
 }

 public void setBudget(double budget) {
  this.budget = budget;
 }
}