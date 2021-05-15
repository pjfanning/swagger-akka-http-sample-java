package com.example.akka.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import java.util.List;

@Schema(name = "ListUsersResponse")
public class ListUsersResponse implements Serializable {
  private List<User> records;
  private Integer pageSize;
  private Integer pageNumber;
  private Integer numberOfPages;

  public List<User> getRecords() {
    return records;
  }

  public void setRecords(List<User> records) {
    this.records = records;
  }

  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public Integer getPageNumber() {
    return pageNumber;
  }

  public void setPageNumber(Integer pageNumber) {
    this.pageNumber = pageNumber;
  }

  public Integer getNumberOfPages() {
    return numberOfPages;
  }

  public void setNumberOfPages(Integer numberOfPages) {
    this.numberOfPages = numberOfPages;
  }
}
