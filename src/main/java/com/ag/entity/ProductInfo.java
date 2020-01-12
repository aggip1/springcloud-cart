package com.ag.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductInfo implements Serializable {

  private String productId;
  private String prodcutName;
  private double productPrice;
  private long productStock;
  private String productDescription;
  private String productIcon;
  private long categoryType;
  private Date createTime;
  private Date updateTime;

}
