/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.electronic;

/**
 *
 * @author Admin
 */
public class Electronic {
    private int id;
    private String name, type, productiondate, producer, weight;
    
    public Electronic(){
        
    }

    public Electronic(int id, String name, String type, String productiondate, String producer, String weight) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.productiondate = productiondate;
        this.producer = producer;
        this.weight = weight;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProductiondate() {
        return productiondate;
    }

    public void setProductiondate(String productiondate) {
        this.productiondate = productiondate;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

   
    
}
