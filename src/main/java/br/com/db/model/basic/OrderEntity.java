package br.com.db.model.basic;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Date date;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List<ItemOrdered> items;

    public OrderEntity() {
        this(new Date());
    }

    public OrderEntity(Date date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<ItemOrdered> getItems() {
        return items;
    }

    public void setItems(List<ItemOrdered> items) {
        this.items = items;
    }
}
