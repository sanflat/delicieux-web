package com.family.delicieux.model;

import lombok.Data;
import java.util.Date;

@Data
public class GenreModel {
    private Integer id;
    private String name;
    private Date deletedAt;
    private Date createdAt;
    private Date updatedAt;
}
