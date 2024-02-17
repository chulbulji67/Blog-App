package com.blog.blogapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Article extends AbstractClass{
   private String title;
   private String content;

    private Date publication_date;
    private long likes_count;



    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;  // (foreign key referencing user_id),]

    @JsonIgnore
    @OneToMany(mappedBy = "article" ,fetch = FetchType.EAGER)
    private List<Comment> comments; //
//

    @JsonIgnore
    @ManyToMany(mappedBy = "articles", fetch = FetchType.EAGER)
    private List<Tag> tags;

}
